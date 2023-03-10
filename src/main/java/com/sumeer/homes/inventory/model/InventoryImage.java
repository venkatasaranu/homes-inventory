package com.sumeer.homes.inventory.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Venkata Saranu
 */
@Entity
@Table(name="inventory_images")
public class InventoryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer imageId;
    @Column
    private String imageName;
    @Column
    private String imageType;
    @Lob
    private byte[] imageContent;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private HomeInventory homeInventory;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

    public HomeInventory getHomeInventory() {
        return homeInventory;
    }

    public void setHomeInventory(HomeInventory homeInventory) {
        this.homeInventory = homeInventory;
    }
}
