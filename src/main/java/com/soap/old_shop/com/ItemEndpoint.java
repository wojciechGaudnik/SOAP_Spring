package com.soap.old_shop.com;

import localhost.item.GetItemRequest;
import localhost.item.GetItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ItemEndpoint {
	private static final String NAMESPACE_URI = "http://localhost/item";
	private final ItemRepository itemRepository;

	@Autowired
	public ItemEndpoint(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getItemRequest")
	@ResponsePayload
	public GetItemResponse getItem(@RequestPayload GetItemRequest request) {
		GetItemResponse response = new GetItemResponse();
		response.setItem(itemRepository.findItem(request.getName()));
		return response;
	}
}
   
