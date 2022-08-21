package com.hackathon.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.app.models.Item;
import com.hackathon.app.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
//	---------------Find All Items -------------
	public List<Item> findAllItems(){
		return itemRepo.findAll();
	}
//	---------------Find Project By Id -------------
	public Item findItemById(Long id) {
		Optional<Item> potentialItem = itemRepo.findById(id);
		if(potentialItem.isPresent()) {
			return potentialItem.get();
		}
		else return null;
	}
}
