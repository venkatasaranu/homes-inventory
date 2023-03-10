package com.sumeer.homes.inventory.repository;

import com.sumeer.homes.inventory.model.HomeInventory;
import com.sumeer.homes.inventory.model.InventoryImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Venkata Saranu
 */
public interface InventoryImageRepository extends JpaRepository<InventoryImage, Integer> {

    List<InventoryImage> findByHomeInventory(Integer inventoryId);
}
