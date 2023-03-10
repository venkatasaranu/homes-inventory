package com.sumeer.homes.inventory.service;

import com.sumeer.homes.inventory.exception.ResourceNotFoundException;
import com.sumeer.homes.inventory.model.InventoryImage;
import com.sumeer.homes.inventory.repository.InventoryImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Venkata Saranu
 */
@Service
public class InventoryImageService {
    @Autowired
    private InventoryImageRepository inventoryImageRepository;

    List<InventoryImage> getAllImagesByInventory(Integer inventoryId) {
        return inventoryImageRepository.findByHomeInventory(inventoryId);
    }

    public InventoryImage saveImage(InventoryImage inventoryImage) {
        return inventoryImageRepository.save(inventoryImage);
    }

    public InventoryImage getImage(Integer imageId) {
        return inventoryImageRepository.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Image with id = " + imageId));
    }
}
