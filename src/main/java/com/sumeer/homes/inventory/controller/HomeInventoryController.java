package com.sumeer.homes.inventory.controller;

import com.sumeer.homes.inventory.domain.ResponseMessage;
import com.sumeer.homes.inventory.model.HomeInventory;
import com.sumeer.homes.inventory.service.HomeInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Venkata Saranu
 */
@CrossOrigin
@RestController
@RequestMapping("/homeinventory")
public class HomeInventoryController {
    @Autowired
    private HomeInventoryService homeInventoryService;

    @PostMapping(value = "/create")
    public ResponseMessage createHomeInventory(@RequestBody HomeInventory homeInventory) {
        HomeInventory result = homeInventoryService.saveHomeInventory(homeInventory);
        return new ResponseMessage(" Inventory Created with ID : "+result.getInventoryId());
    }

    @PutMapping(value = "/{inventoryId}/update")
    public ResponseMessage createHomeInventory(@PathVariable("inventoryId") Integer inventoryId , @RequestBody HomeInventory homeInventory) {
        homeInventory.setInventoryId(inventoryId);
        HomeInventory result = homeInventoryService.saveHomeInventory(homeInventory);
        return new ResponseMessage(" Inventory Created with ID : "+result.getInventoryId());
    }

    @DeleteMapping(value = "/{inventoryId}/delete")
    public HomeInventory getHomeInventoryList(@PathVariable("inventoryId") Integer inventoryId) {
        HomeInventory home = homeInventoryService.getHomeInventory(inventoryId);
        homeInventoryService.deleteHomeInventory(inventoryId);
        return home;
    }
    @GetMapping("/list")
    public List<HomeInventory> getHomeInventoryList() {
        return homeInventoryService.getAllInventory();
    }

    @GetMapping("/{inventoryId}")
    public HomeInventory getHomeInventoryById(@PathVariable("inventoryId") Integer inventoryId ) {
        return homeInventoryService.getHomeInventory(inventoryId);
    }


}
