package com.consultadd.Inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultadd.Inventory.entity.Item;
import com.consultadd.Inventory.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
	
	public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
	
	public Item addItem(Item item) {
        return itemRepository.save(item);
    }
	
	public Item updateItemQuantity(Long id, int quantity) {
		
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
        item.setQuantity(quantity);
        return itemRepository.save(item);
    }
	
	public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

}
