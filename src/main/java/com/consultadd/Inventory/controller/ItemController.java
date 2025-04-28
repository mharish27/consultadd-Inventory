package com.consultadd.Inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consultadd.Inventory.entity.Item;
import com.consultadd.Inventory.repository.ItemRepository;
import com.consultadd.Inventory.service.ItemService;

@RestController
@RequestMapping("items")
public class ItemController {
	
	@Autowired
    private ItemService itemService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
	
	@GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }
	
	@PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }
	
	@PutMapping("/{id}/quantity")
    public Item updateItemQuantity(@PathVariable Long id, @RequestParam int quantity) {
        return itemService.updateItemQuantity(id, quantity);
    }
	
	@DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

}
