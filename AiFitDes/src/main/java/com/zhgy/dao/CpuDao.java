package com.zhgy.dao;

import com.zhgy.entity.CpuEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CpuDao extends CrudRepository<CpuEntity, Integer> {
    @Query("from CpuEntity ")
    public ArrayList<CpuEntity> getAllDepartment();
}
