package com.zhgy.entity;

import javax.persistence.*;

@Entity
@Table(name = "mainboard", schema = "afds", catalog = "afds")
public class MainboardEntity {
    private String id;
    private String brands;
    private String name;
    private String model;
    private String price;
    private String mainChipset;
    private String audioChip;
    private String memoryType;
    private String maxMemoryCapacity;
    private String motherboardType;
    private String shapeSize;
    private String powerSupplySocket;
    private String powerSupplyMode;
    private String img;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brands", nullable = true, length = 255)
    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 255)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 255)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "main_chipset", nullable = true, length = 255)
    public String getMainChipset() {
        return mainChipset;
    }

    public void setMainChipset(String mainChipset) {
        this.mainChipset = mainChipset;
    }

    @Basic
    @Column(name = "audio_chip", nullable = true, length = 255)
    public String getAudioChip() {
        return audioChip;
    }

    public void setAudioChip(String audioChip) {
        this.audioChip = audioChip;
    }

    @Basic
    @Column(name = "memory_type", nullable = true, length = 255)
    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    @Basic
    @Column(name = "max_memory_capacity", nullable = true, length = 255)
    public String getMaxMemoryCapacity() {
        return maxMemoryCapacity;
    }

    public void setMaxMemoryCapacity(String maxMemoryCapacity) {
        this.maxMemoryCapacity = maxMemoryCapacity;
    }

    @Basic
    @Column(name = "motherboard_type", nullable = true, length = 255)
    public String getMotherboardType() {
        return motherboardType;
    }

    public void setMotherboardType(String motherboardType) {
        this.motherboardType = motherboardType;
    }

    @Basic
    @Column(name = "shape_size", nullable = true, length = 255)
    public String getShapeSize() {
        return shapeSize;
    }

    public void setShapeSize(String shapeSize) {
        this.shapeSize = shapeSize;
    }

    @Basic
    @Column(name = "power_supply_socket", nullable = true, length = 255)
    public String getPowerSupplySocket() {
        return powerSupplySocket;
    }

    public void setPowerSupplySocket(String powerSupplySocket) {
        this.powerSupplySocket = powerSupplySocket;
    }

    @Basic
    @Column(name = "power_supply_mode", nullable = true, length = 255)
    public String getPowerSupplyMode() {
        return powerSupplyMode;
    }

    public void setPowerSupplyMode(String powerSupplyMode) {
        this.powerSupplyMode = powerSupplyMode;
    }

    @Basic
    @Column(name = "img", nullable = true, length = 255)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainboardEntity that = (MainboardEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brands != null ? !brands.equals(that.brands) : that.brands != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (mainChipset != null ? !mainChipset.equals(that.mainChipset) : that.mainChipset != null) return false;
        if (audioChip != null ? !audioChip.equals(that.audioChip) : that.audioChip != null) return false;
        if (memoryType != null ? !memoryType.equals(that.memoryType) : that.memoryType != null) return false;
        if (maxMemoryCapacity != null ? !maxMemoryCapacity.equals(that.maxMemoryCapacity) : that.maxMemoryCapacity != null)
            return false;
        if (motherboardType != null ? !motherboardType.equals(that.motherboardType) : that.motherboardType != null)
            return false;
        if (shapeSize != null ? !shapeSize.equals(that.shapeSize) : that.shapeSize != null) return false;
        if (powerSupplySocket != null ? !powerSupplySocket.equals(that.powerSupplySocket) : that.powerSupplySocket != null)
            return false;
        if (powerSupplyMode != null ? !powerSupplyMode.equals(that.powerSupplyMode) : that.powerSupplyMode != null)
            return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brands != null ? brands.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (mainChipset != null ? mainChipset.hashCode() : 0);
        result = 31 * result + (audioChip != null ? audioChip.hashCode() : 0);
        result = 31 * result + (memoryType != null ? memoryType.hashCode() : 0);
        result = 31 * result + (maxMemoryCapacity != null ? maxMemoryCapacity.hashCode() : 0);
        result = 31 * result + (motherboardType != null ? motherboardType.hashCode() : 0);
        result = 31 * result + (shapeSize != null ? shapeSize.hashCode() : 0);
        result = 31 * result + (powerSupplySocket != null ? powerSupplySocket.hashCode() : 0);
        result = 31 * result + (powerSupplyMode != null ? powerSupplyMode.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
