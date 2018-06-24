package com.zhgy.dao;

import com.zhgy.entity.VideocardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideocardDao extends PagingAndSortingRepository<VideocardEntity, String> {
    @Query("select c from VideocardEntity c")
    List<VideocardEntity> findBrandSet(); // 该方法获得所有品牌

    @Query("select c from VideocardEntity c where c.brands = :brand")
    List<VideocardEntity> findNameByBrand(@Param("brand") String brand); // 该方法获得指定品牌的所有系列名

    @Query("select c from VideocardEntity c where c.brands = :brand and c.name = :name")
    List<VideocardEntity> findModelByBrandAndName(@Param("brand") String brand, @Param("name") String name); // 该方法获得指定品牌下系列的的所有产品型号名
}
