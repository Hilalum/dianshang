package com.zhgy.entity;

import javax.persistence.*;

@Entity
@Table(name = "cpu", schema = "afds", catalog = "afds")
public class CpuEntity {
    private String id;
    private String brands;
    private String name;
    private String model;
    private String price;
    private String applicableType;
    private String cpuSeries;
    private String cpuMainFrequency;
    private String ghz;
    private String slotType;
    private String twoLevelCaching;
    private String coreQuantity;
    private String threadNumber;
    private String img;

    @Id
    @Column(name = "id", nullable = false, length = 255)
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
    @Column(name = "cpu_series", nullable = true, length = 255)
    public String getCpuSeries() {
        return cpuSeries;
    }

    public void setCpuSeries(String cpuSeries) {
        this.cpuSeries = cpuSeries;
    }

    @Basic
    @Column(name = "cpu_main_frequency", nullable = true, length = 255)
    public String getCpuMainFrequency() {
        return cpuMainFrequency;
    }

    public void setCpuMainFrequency(String cpuMainFrequency) {
        this.cpuMainFrequency = cpuMainFrequency;
    }

    @Basic
    @Column(name = "ghz", nullable = true, length = 255)
    public String getGhz() {
        return ghz;
    }

    public void setGhz(String ghz) {
        this.ghz = ghz;
    }

    @Basic
    @Column(name = "slot_type", nullable = true, length = 255)
    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    @Basic
    @Column(name = "two_level_caching", nullable = true, length = 255)
    public String getTwoLevelCaching() {
        return twoLevelCaching;
    }

    public void setTwoLevelCaching(String twoLevelCaching) {
        this.twoLevelCaching = twoLevelCaching;
    }

    @Basic
    @Column(name = "core_quantity", nullable = true, length = 255)
    public String getCoreQuantity() {
        return coreQuantity;
    }

    public void setCoreQuantity(String coreQuantity) {
        this.coreQuantity = coreQuantity;
    }

    @Basic
    @Column(name = "thread_number", nullable = true, length = 255)
    public String getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(String threadNumber) {
        this.threadNumber = threadNumber;
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

        CpuEntity cpuEntity = (CpuEntity) o;

        if (id != null ? !id.equals(cpuEntity.id) : cpuEntity.id != null) return false;
        if (brands != null ? !brands.equals(cpuEntity.brands) : cpuEntity.brands != null) return false;
        if (name != null ? !name.equals(cpuEntity.name) : cpuEntity.name != null) return false;
        if (model != null ? !model.equals(cpuEntity.model) : cpuEntity.model != null) return false;
        if (price != null ? !price.equals(cpuEntity.price) : cpuEntity.price != null) return false;
        if (applicableType != null ? !applicableType.equals(cpuEntity.applicableType) : cpuEntity.applicableType != null)
            return false;
        if (cpuSeries != null ? !cpuSeries.equals(cpuEntity.cpuSeries) : cpuEntity.cpuSeries != null) return false;
        if (cpuMainFrequency != null ? !cpuMainFrequency.equals(cpuEntity.cpuMainFrequency) : cpuEntity.cpuMainFrequency != null)
            return false;
        if (ghz != null ? !ghz.equals(cpuEntity.ghz) : cpuEntity.ghz != null) return false;
        if (slotType != null ? !slotType.equals(cpuEntity.slotType) : cpuEntity.slotType != null) return false;
        if (twoLevelCaching != null ? !twoLevelCaching.equals(cpuEntity.twoLevelCaching) : cpuEntity.twoLevelCaching != null)
            return false;
        if (coreQuantity != null ? !coreQuantity.equals(cpuEntity.coreQuantity) : cpuEntity.coreQuantity != null)
            return false;
        if (threadNumber != null ? !threadNumber.equals(cpuEntity.threadNumber) : cpuEntity.threadNumber != null)
            return false;
        if (img != null ? !img.equals(cpuEntity.img) : cpuEntity.img != null) return false;

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
        result = 31 * result + (cpuSeries != null ? cpuSeries.hashCode() : 0);
        result = 31 * result + (cpuMainFrequency != null ? cpuMainFrequency.hashCode() : 0);
        result = 31 * result + (ghz != null ? ghz.hashCode() : 0);
        result = 31 * result + (slotType != null ? slotType.hashCode() : 0);
        result = 31 * result + (twoLevelCaching != null ? twoLevelCaching.hashCode() : 0);
        result = 31 * result + (coreQuantity != null ? coreQuantity.hashCode() : 0);
        result = 31 * result + (threadNumber != null ? threadNumber.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
