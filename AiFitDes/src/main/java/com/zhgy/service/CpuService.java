package com.zhgy.service;

import com.zhgy.dao.CpuDao;
import com.zhgy.entity.CpuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class CpuService {

    @Autowired
    private CpuDao cpuDao;

    public ArrayList<CpuEntity> getAll(){
        return (ArrayList<CpuEntity>) cpuDao.getAllDepartment();
    }
}
