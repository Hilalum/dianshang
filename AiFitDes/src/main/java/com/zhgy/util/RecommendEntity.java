package com.zhgy.util;

import com.zhgy.entity.*;

public class RecommendEntity {
    private CpuEntity cpuEntity = null;
    private HarddiskEntity harddiskEntity = null;
    private MainboardEntity mainboardEntity = null;
    private MemorybarEntity memorybarEntity = null;
    private PowerEntity powerEntity = null;
    private VideocardEntity videocardEntity = null;

    public HarddiskEntity getHarddiskEntity() {
        return harddiskEntity;
    }

    public void setHarddiskEntity(HarddiskEntity harddiskEntity) {
        this.harddiskEntity = harddiskEntity;
    }

    public MainboardEntity getMainboardEntity() {
        return mainboardEntity;
    }

    public void setMainboardEntity(MainboardEntity mainboardEntity) {
        this.mainboardEntity = mainboardEntity;
    }

    public MemorybarEntity getMemorybarEntity() {
        return memorybarEntity;
    }

    public void setMemorybarEntity(MemorybarEntity memorybarEntity) {
        this.memorybarEntity = memorybarEntity;
    }

    public PowerEntity getPowerEntity() {
        return powerEntity;
    }

    public void setPowerEntity(PowerEntity powerEntity) {
        this.powerEntity = powerEntity;
    }

    public VideocardEntity getVideocardEntity() {
        return videocardEntity;
    }

    public void setVideocardEntity(VideocardEntity videocardEntity) {
        this.videocardEntity = videocardEntity;
    }

    public CpuEntity getCpuEntity() {

        return cpuEntity;
    }

    public void setCpuEntity(CpuEntity cpuEntity) {
        this.cpuEntity = cpuEntity;
    }
}
