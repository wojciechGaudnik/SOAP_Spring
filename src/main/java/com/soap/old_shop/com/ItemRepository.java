package com.soap.old_shop.com;

import localhost.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ItemRepository {
	private static final Map<String, Item> items = new HashMap<>();

	@PostConstruct
	public void initData() {
		Item bread = Item.builder()
				.name("bread")
				.price(666d)
				.size(33f)
				.weight(44f)
				.build();
		Item roll = Item.builder()
				.name("bread")
				.price(666d)
				.size(33f)
				.weight(44f)
				.build();

		items.put(bread.getName(), bread);
		items.put(roll.getName(), roll);
	}

	public Item findItem(String name) {
		Assert.notNull(name, "The item's name must not be null");
		return items.get(name);
	}
}
   
