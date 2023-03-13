package com.sumeer.homes.inventory.model;

import jakarta.persistence.*;

/**
 * @author Venkata Saranu
 */
@Entity
@Table(name="home_inventory")
public class HomeInventory {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="inventory_id")
    private Integer inventoryId;

    @Column
    private String saleManager;

    @Column
    private String community;

    @Column
    private String city;

    @Column
    private String county;

    @Column
    private String schoolISD;

    @Column
    private String address;

    @Column(name="no_of_stories")
    private Double stories;

    @Column(name="no_of_baths")
    private Double baths;

    @Column(name="no_of_rooms")
    private Integer rooms;

    @Column
    private Integer garageSize;

    @Column
    private String direction;

    @Column
    private Integer houseSize;

    @Column
    private String lotSize;

    @Column
    private Double listPrice;

    @Column
    private String mlsListingId;

    @Column
    private String status;

    @Column
    private String available;

    @Column
    private Double hoaFee;
    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSchoolISD() {
        return schoolISD;
    }

    public void setSchoolISD(String schoolISD) {
        this.schoolISD = schoolISD;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getStories() {
        return stories;
    }

    public void setStories(Double stories) {
        this.stories = stories;
    }

    public Double getBaths() {
        return baths;
    }

    public void setBaths(Double baths) {
        this.baths = baths;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getGarageSize() {
        return garageSize;
    }

    public void setGarageSize(Integer garageSize) {
        this.garageSize = garageSize;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    public String getLotSize() {
        return lotSize;
    }

    public void setLotSize(String lotSize) {
        this.lotSize = lotSize;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public String getMlsListingId() {
        return mlsListingId;
    }

    public void setMlsListingId(String mlsListingId) {
        this.mlsListingId = mlsListingId;
    }

    public String getSaleManager() {
        return saleManager;
    }

    public void setSaleManager(String saleManager) {
        this.saleManager = saleManager;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Double getHoaFee() {
        return hoaFee;
    }

    public void setHoaFee(Double hoaFee) {
        this.hoaFee = hoaFee;
    }
}
