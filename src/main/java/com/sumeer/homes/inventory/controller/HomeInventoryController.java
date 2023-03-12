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
@RestController
@RequestMapping("/homeinventory")
public class HomeInventoryController {
    @Autowired
    private HomeInventoryService homeInventoryService;

    @PostMapping("/create")
    public ResponseMessage createHomeInventory(HomeInventory homeInventory) {
        HomeInventory result = homeInventoryService.saveHomeInventory(homeInventory);
        return new ResponseMessage(" Inventory Created with ID : "+result.getInventoryId());
    }

    @GetMapping("/list")
    public List<HomeInventory> getHomeInventoryList() {
        return homeInventoryService.getAllInventory();
    }


}
