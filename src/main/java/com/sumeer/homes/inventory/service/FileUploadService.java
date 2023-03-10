package com.sumeer.homes.inventory.service;

import com.sumeer.homes.inventory.model.HomeInventory;
import com.sumeer.homes.inventory.repository.HomeInventoryRepository;
import com.sumeer.homes.inventory.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Venkata Saranu
 */
@Service
public class FileUploadService {
    @Autowired
    private HomeInventoryRepository homeInventoryRepository;


    public List<HomeInventory> save(MultipartFile file) throws IOException {
        try {
            List<HomeInventory> homeInventories = ExcelHelper.processExcel(file.getInputStream());
            return homeInventoryRepository.saveAll(homeInventories);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
