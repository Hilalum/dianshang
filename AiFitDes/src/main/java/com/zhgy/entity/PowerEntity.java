package com.zhgy.entity;

import javax.persistence.*;

@Entity
@Table(name = "power", schema = "afds", catalog = "afds")
public class PowerEntity {
    private String id;
    private String brands;
    private String name;
    private String model;
    private String price;
    private String powerType;
    private String outLineType;
    private String ratedPower;
    private String maxPower;
    private String motherboardInterface;
    private String hardDiskInterface;
    private String pfcType;
    private String conversionEfficiency;
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
    @Column(name = "power_type", nullable = true, length = 255)
    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    @Basic
    @Column(name = "out_line_type", nullable = true, length = 255)
    public String getOutLineType() {
        return outLineType;
    }

    public void setOutLineType(String outLineType) {
        this.outLineType = outLineType;
    }

    @Basic
    @Column(name = "rated_power", nullable = true, length = 255)
    public String getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(String ratedPower) {
        this.ratedPower = ratedPower;
    }

    @Basic
    @Column(name = "max_power", nullable = true, length = 255)
    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower;
    }

    @Basic
    @Column(name = "motherboard_interface", nullable = true, length = 255)
    public String getMotherboardInterface() {
        return motherboardInterface;
    }

    public void setMotherboardInterface(String motherboardInterface) {
        this.motherboardInterface = motherboardInterface;
    }

    @Basic
    @Column(name = "hard_disk_interface", nullable = true, length = 255)
    public String getHardDiskInterface() {
        return hardDiskInterface;
    }

    public void setHardDiskInterface(String hardDiskInterface) {
        this.hardDiskInterface = hardDiskInterface;
    }

    @Basic
    @Column(name = "pfc_type", nullable = true, length = 255)
    public String getPfcType() {
        return pfcType;
    }

    public void setPfcType(String pfcType) {
        this.pfcType = pfcType;
    }

    @Basic
    @Column(name = "conversion_efficiency", nullable = true, length = 255)
    public String getConversionEfficiency() {
        return conversionEfficiency;
    }

    public void setConversionEfficiency(String conversionEfficiency) {
        this.conversionEfficiency = conversionEfficiency;
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

        PowerEntity that = (PowerEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brands != null ? !brands.equals(that.brands) : that.brands != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (powerType != null ? !powerType.equals(that.powerType) : that.powerType != null) return false;
        if (outLineType != null ? !outLineType.equals(that.outLineType) : that.outLineType != null) return false;
        if (ratedPower != null ? !ratedPower.equals(that.ratedPower) : that.ratedPower != null) return false;
        if (maxPower != null ? !maxPower.equals(that.maxPower) : that.maxPower != null) return false;
        if (motherboardInterface != null ? !motherboardInterface.equals(that.motherboardInterface) : that.motherboardInterface != null)
            return false;
        if (hardDiskInterface != null ? !hardDiskInterface.equals(that.hardDiskInterface) : that.hardDiskInterface != null)
            return false;
        if (pfcType != null ? !pfcType.equals(that.pfcType) : that.pfcType != null) return false;
        if (conversionEfficiency != null ? !conversionEfficiency.equals(that.conversionEfficiency) : that.conversionEfficiency != null)
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
        result = 31 * result + (powerType != null ? powerType.hashCode() : 0);
        result = 31 * result + (outLineType != null ? outLineType.hashCode() : 0);
        result = 31 * result + (ratedPower != null ? ratedPower.hashCode() : 0);
        result = 31 * result + (maxPower != null ? maxPower.hashCode() : 0);
        result = 31 * result + (motherboardInterface != null ? motherboardInterface.hashCode() : 0);
        result = 31 * result + (hardDiskInterface != null ? hardDiskInterface.hashCode() : 0);
        result = 31 * result + (pfcType != null ? pfcType.hashCode() : 0);
        result = 31 * result + (conversionEfficiency != null ? conversionEfficiency.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }
}
