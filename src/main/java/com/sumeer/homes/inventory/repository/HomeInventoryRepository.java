package com.sumeer.homes.inventory.repository;

import com.sumeer.homes.inventory.model.HomeInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Venkata Saranu
 */
public interface HomeInventoryRepository extends JpaRepository<HomeInventory, Integer> {

}
