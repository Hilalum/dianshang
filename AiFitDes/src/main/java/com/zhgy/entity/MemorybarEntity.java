package com.zhgy.entity;

import javax.persistence.*;

@Entity
@Table(name = "memorybar", schema = "afds", catalog = "afds")
public class MemorybarEntity {
    private String id;
    private String brands;
    private String name;
    private String model;
    private String price;
    private String applicableType;
    private String memoryCapacity;
    private String memoryType;
    private String mainFrequencyOfMemory;
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
    @Column(name = "applicable_type", nullable = true, length = 255)
    public String getApplicableType() {
        return applicableType;
    }

    public void setApplicableType(String applicableType) {
        this.applicableType = applicableType;
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
    @Column(name = "memory_type", nullable = true, length = 255)
    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    @Basic
    @Column(name = "main_frequency_of_memory", nullable = true, length = 255)
    public String getMainFrequencyOfMemory() {
        return mainFrequencyOfMemory;
    }

    public void setMainFrequencyOfMemory(String mainFrequencyOfMemory) {
        this.mainFrequencyOfMemory = mainFrequencyOfMemory;
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

        MemorybarEntity that = (MemorybarEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brands != null ? !brands.equals(that.brands) : that.brands != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (applicableType != null ? !applicableType.equals(that.applicableType) : that.applicableType != null)
            return false;
        if (memoryCapacity != null ? !memoryCapacity.equals(that.memoryCapacity) : that.memoryCapacity != null)
            return false;
        if (memoryType != null ? !memoryType.equals(that.memoryType) : that.memoryType != null) return false;
        if (mainFrequencyOfMemory != null ? !mainFrequencyOfMemory.equals(that.mainFrequencyOfMemory) : that.mainFrequencyOfMemory != null)
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
        result = 31 * result + (applicableType != null ? applicableType.hashCode() : 0);
        result = 31 * result + (memoryCapacity != null ? memoryCapacity.hashCode() : 0);
        result = 31 * result + (memoryType != null ? memoryType.hashCode() : 0);
        result = 31 * result + (mainFrequencyOfMemory != null ? mainFrequencyOfMemory.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
