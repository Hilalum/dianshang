package com.zhgy.service;

import com.zhgy.dao.MemorybarDao;
import com.zhgy.dao.VideocardDao;
import com.zhgy.entity.MemorybarEntity;
import com.zhgy.entity.VideocardEntity;
import com.zhgy.util.GetSession;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class VideocardService {

    @Autowired
    private VideocardDao videocardDao;

    // 该方法获得cpu的所有品牌
    public List<String> getAllBrandsName() {
        List<VideocardEntity> list = videocardDao.findBrandSet();
        HashSet<String> set = new HashSet<String>();
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) { set.add(list.get(i).getBrands()); }
        for (String s : set) { ret.add(s); }
        return ret;
    }

    // 该方法获得指定品牌的所有系列名
    public List<String> getAllNameByBrand(String brand_name) {
        List<VideocardEntity> list = videocardDao.findNameByBrand(brand_name);
        HashSet<String> set = new HashSet<String>();
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) { set.add(list.get(i).getName()); }
        for (String s : set) { ret.add(s); }
        return ret;
    }

    // 该方法获得制定品牌和系列名的所有产品型号
    public List<String> getAllModelByBrandAndName(String brand_name, String name) {
        List<VideocardEntity> list = videocardDao.findModelByBrandAndName(brand_name, name);
        HashSet<String> set = new HashSet<String>();
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) { set.add(list.get(i).getModel()); }
        for (String s : set) { ret.add(s); }
        return ret;
    }

    // 该方法返回分页查询的结果。page-想返回的页数。size-返回的页数中最多有多少数据
    public List<VideocardEntity> getAllByPageNumAndSize(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        PageRequest pageRequest = new PageRequest(page - 1, size, sort);
        return videocardDao.findAll(pageRequest).getContent();
    }

    // 该方法返回按条件分页查询的结果。where_context-查询条件。page-想返回的页数。size-返回的页数中最多有多少数据
    public ArrayList<VideocardEntity> getCPUByCondition(String where_context, Integer start_num, Integer page_size){
        start_num = (--start_num) * page_size;
        Session session = GetSession.getSession();
        session.beginTransaction();
        String sql = "select * from videocard where " + where_context + " limit " + start_num + " , " + page_size;
        SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(VideocardEntity.class);
        return (ArrayList<VideocardEntity>) sqlQuery.list();
    }

    // 该方法提供了按照id删除一个CPU
    public void deleteById(String id){  videocardDao.delete(id); }

    // 该方法提供了按照ID查询一个CPU的方法
    public VideocardEntity getCPUById(String id) { return videocardDao.findOne(id); }
}
