package com.zhgy.entity;

import javax.persistence.*;

@Entity
@Table(name = "videocard", schema = "afds", catalog = "afds")
public class VideocardEntity {
    private String id;
    private String brands;
    private String name;
    private String model;
    private String price;
    private String graphicsCardType;
    private String videoCardChip;
    private String coreFrequency;
    private String memoryFrequency;
    private String memoryCapacity;
    private String memoryInterface;
    private String powerInterface;
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
    @Column(name = "graphics_card_type", nullable = true, length = 255)
    public String getGraphicsCardType() {
        return graphicsCardType;
    }

    public void setGraphicsCardType(String graphicsCardType) {
        this.graphicsCardType = graphicsCardType;
    }

    @Basic
    @Column(name = "video_card_chip", nullable = true, length = 255)
    public String getVideoCardChip() {
        return videoCardChip;
    }

    public void setVideoCardChip(String videoCardChip) {
        this.videoCardChip = videoCardChip;
    }

    @Basic
    @Column(name = "core_frequency", nullable = true, length = 255)
    public String getCoreFrequency() {
        return coreFrequency;
    }

    public void setCoreFrequency(String coreFrequency) {
        this.coreFrequency = coreFrequency;
    }

    @Basic
    @Column(name = "memory_frequency", nullable = true, length = 255)
    public String getMemoryFrequency() {
        return memoryFrequency;
    }

    public void setMemoryFrequency(String memoryFrequency) {
        this.memoryFrequency = memoryFrequency;
    }

    @Basic
    @Column(name = "memory_capacity", nullable = true, length = 255)
    public String getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(String memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    @Basic
    @Column(name = "memory_interface", nullable = true, length = 255)
    public String getMemoryInterface() {
        return memoryInterface;
    }

    public void setMemoryInterface(String memoryInterface) {
        this.memoryInterface = memoryInterface;
    }

    @Basic
    @Column(name = "power_interface", nullable = true, length = 255)
    public String getPowerInterface() {
        return powerInterface;
    }

    public void setPowerInterface(String powerInterface) {
        this.powerInterface = powerInterface;
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

        VideocardEntity that = (VideocardEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brands != null ? !brands.equals(that.brands) : that.brands != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (graphicsCardType != null ? !graphicsCardType.equals(that.graphicsCardType) : that.graphicsCardType != null)
            return false;
        if (videoCardChip != null ? !videoCardChip.equals(that.videoCardChip) : that.videoCardChip != null)
            return false;
        if (coreFrequency != null ? !coreFrequency.equals(that.coreFrequency) : that.coreFrequency != null)
            return false;
        if (memoryFrequency != null ? !memoryFrequency.equals(that.memoryFrequency) : that.memoryFrequency != null)
            return false;
        if (memoryCapacity != null ? !memoryCapacity.equals(that.memoryCapacity) : that.memoryCapacity != null)
            return false;
        if (memoryInterface != null ? !memoryInterface.equals(that.memoryInterface) : that.memoryInterface != null)
            return false;
        if (powerInterface != null ? !powerInterface.equals(that.powerInterface) : that.powerInterface != null)
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
        result = 31 * result + (graphicsCardType != null ? graphicsCardType.hashCode() : 0);
        result = 31 * result + (videoCardChip != null ? videoCardChip.hashCode() : 0);
        result = 31 * result + (coreFrequency != null ? coreFrequency.hashCode() : 0);
        result = 31 * result + (memoryFrequency != null ? memoryFrequency.hashCode() : 0);
        result = 31 * result + (memoryCapacity != null ? memoryCapacity.hashCode() : 0);
        result = 31 * result + (memoryInterface != null ? memoryInterface.hashCode() : 0);
        result = 31 * result + (powerInterface != null ? powerInterface.hashCode() : 0);
        result = 31 * result + (powerSupplyMode != null ? powerSupplyMode.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
