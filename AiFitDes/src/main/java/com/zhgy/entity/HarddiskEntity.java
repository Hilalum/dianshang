package com.zhgy.entity;

import javax.persistence.*;

@Entity
@Table(name = "harddisk", schema = "afds", catalog = "afds")
public class HarddiskEntity {
    private String id;
    private String brands;
    private String name;
    private String model;
    private String price;
    private String type;
    private String storageCapacity;
    private String harddiskSize;
    private String interfaceType;
    private String cache;
    private String rwspeed;
    private String wspeed;
    private String faultFreeTime;
    private String searchTime;
    private String applicableType;
    private String harddiskSizeP;
    private String harddiskCapacity;
    private String singleDiskCapacity;
    private String cacheP;
    private String speed;
    private String interfaceTypeP;
    private String interfaceRate;
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
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "storage_capacity", nullable = true, length = 255)
    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Basic
    @Column(name = "harddisk_size", nullable = true, length = 255)
    public String getHarddiskSize() {
        return harddiskSize;
    }

    public void setHarddiskSize(String harddiskSize) {
        this.harddiskSize = harddiskSize;
    }

    @Basic
    @Column(name = "Interface_type", nullable = true, length = 255)
    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Basic
    @Column(name = "cache", nullable = true, length = 255)
    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    @Basic
    @Column(name = "rwspeed", nullable = true, length = 255)
    public String getRwspeed() {
        return rwspeed;
    }

    public void setRwspeed(String rwspeed) {
        this.rwspeed = rwspeed;
    }

    @Basic
    @Column(name = "wspeed", nullable = true, length = 255)
    public String getWspeed() {
        return wspeed;
    }

    public void setWspeed(String wspeed) {
        this.wspeed = wspeed;
    }

    @Basic
    @Column(name = "fault_free_time", nullable = true, length = 255)
    public String getFaultFreeTime() {
        return faultFreeTime;
    }

    public void setFaultFreeTime(String faultFreeTime) {
        this.faultFreeTime = faultFreeTime;
    }

    @Basic
    @Column(name = "search_time", nullable = true, length = 255)
    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
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
    @Column(name = "harddisk_size_p", nullable = true, length = 255)
    public String getHarddiskSizeP() {
        return harddiskSizeP;
    }

    public void setHarddiskSizeP(String harddiskSizeP) {
        this.harddiskSizeP = harddiskSizeP;
    }

    @Basic
    @Column(name = "harddisk_capacity", nullable = true, length = 255)
    public String getHarddiskCapacity() {
        return harddiskCapacity;
    }

    public void setHarddiskCapacity(String harddiskCapacity) {
        this.harddiskCapacity = harddiskCapacity;
    }

    @Basic
    @Column(name = "single_disk_capacity", nullable = true, length = 255)
    public String getSingleDiskCapacity() {
        return singleDiskCapacity;
    }

    public void setSingleDiskCapacity(String singleDiskCapacity) {
        this.singleDiskCapacity = singleDiskCapacity;
    }

    @Basic
    @Column(name = "cache_p", nullable = true, length = 255)
    public String getCacheP() {
        return cacheP;
    }

    public void setCacheP(String cacheP) {
        this.cacheP = cacheP;
    }

    @Basic
    @Column(name = "speed", nullable = true, length = 255)
    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "interface_type_p", nullable = true, length = 255)
    public String getInterfaceTypeP() {
        return interfaceTypeP;
    }

    public void setInterfaceTypeP(String interfaceTypeP) {
        this.interfaceTypeP = interfaceTypeP;
    }

    @Basic
    @Column(name = "interface_rate", nullable = true, length = 255)
    public String getInterfaceRate() {
        return interfaceRate;
    }

    public void setInterfaceRate(String interfaceRate) {
        this.interfaceRate = interfaceRate;
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

        HarddiskEntity that = (HarddiskEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brands != null ? !brands.equals(that.brands) : that.brands != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (storageCapacity != null ? !storageCapacity.equals(that.storageCapacity) : that.storageCapacity != null)
            return false;
        if (harddiskSize != null ? !harddiskSize.equals(that.harddiskSize) : that.harddiskSize != null) return false;
        if (interfaceType != null ? !interfaceType.equals(that.interfaceType) : that.interfaceType != null)
            return false;
        if (cache != null ? !cache.equals(that.cache) : that.cache != null) return false;
        if (rwspeed != null ? !rwspeed.equals(that.rwspeed) : that.rwspeed != null) return false;
        if (wspeed != null ? !wspeed.equals(that.wspeed) : that.wspeed != null) return false;
        if (faultFreeTime != null ? !faultFreeTime.equals(that.faultFreeTime) : that.faultFreeTime != null)
            return false;
        if (searchTime != null ? !searchTime.equals(that.searchTime) : that.searchTime != null) return false;
        if (applicableType != null ? !applicableType.equals(that.applicableType) : that.applicableType != null)
            return false;
        if (harddiskSizeP != null ? !harddiskSizeP.equals(that.harddiskSizeP) : that.harddiskSizeP != null)
            return false;
        if (harddiskCapacity != null ? !harddiskCapacity.equals(that.harddiskCapacity) : that.harddiskCapacity != null)
            return false;
        if (singleDiskCapacity != null ? !singleDiskCapacity.equals(that.singleDiskCapacity) : that.singleDiskCapacity != null)
            return false;
        if (cacheP != null ? !cacheP.equals(that.cacheP) : that.cacheP != null) return false;
        if (speed != null ? !speed.equals(that.speed) : that.speed != null) return false;
        if (interfaceTypeP != null ? !interfaceTypeP.equals(that.interfaceTypeP) : that.interfaceTypeP != null)
            return false;
        if (interfaceRate != null ? !interfaceRate.equals(that.interfaceRate) : that.interfaceRate != null)
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
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (storageCapacity != null ? storageCapacity.hashCode() : 0);
        result = 31 * result + (harddiskSize != null ? harddiskSize.hashCode() : 0);
        result = 31 * result + (interfaceType != null ? interfaceType.hashCode() : 0);
        result = 31 * result + (cache != null ? cache.hashCode() : 0);
        result = 31 * result + (rwspeed != null ? rwspeed.hashCode() : 0);
        result = 31 * result + (wspeed != null ? wspeed.hashCode() : 0);
        result = 31 * result + (faultFreeTime != null ? faultFreeTime.hashCode() : 0);
        result = 31 * result + (searchTime != null ? searchTime.hashCode() : 0);
        result = 31 * result + (applicableType != null ? applicableType.hashCode() : 0);
        result = 31 * result + (harddiskSizeP != null ? harddiskSizeP.hashCode() : 0);
        result = 31 * result + (harddiskCapacity != null ? harddiskCapacity.hashCode() : 0);
        result = 31 * result + (singleDiskCapacity != null ? singleDiskCapacity.hashCode() : 0);
        result = 31 * result + (cacheP != null ? cacheP.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (interfaceTypeP != null ? interfaceTypeP.hashCode() : 0);
        result = 31 * result + (interfaceRate != null ? interfaceRate.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
