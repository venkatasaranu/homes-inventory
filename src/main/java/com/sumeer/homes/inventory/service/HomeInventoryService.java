package com.sumeer.homes.inventory.service;

import com.sumeer.homes.inventory.exception.ResourceNotFoundException;
import com.sumeer.homes.inventory.model.HomeInventory;
import com.sumeer.homes.inventory.repository.HomeInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Venkata Saranu
 */
@Service
public class HomeInventoryService {
    @Autowired
    private HomeInventoryRepository homeInventoryRepository;

    public List<HomeInventory> getAllInventory(){
        return homeInventoryRepository.findAll();
    }


    public HomeInventory getHomeInventory(Integer inventoryId) {
        return homeInventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Home with id = " + inventoryId));
    }

    public HomeInventory saveHomeInventory(HomeInventory homeInventory){
        return homeInventoryRepository.save(homeInventory);
    }

    public void deleteHomeInventory(Integer inventoryId) {
        homeInventoryRepository.deleteById(inventoryId);
    }

}
