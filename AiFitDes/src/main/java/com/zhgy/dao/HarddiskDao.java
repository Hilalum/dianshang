package com.zhgy.dao;

import com.zhgy.entity.HarddiskEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HarddiskDao extends PagingAndSortingRepository<HarddiskEntity, String> {
    @Query("select c from HarddiskEntity c")
    List<HarddiskEntity> findBrandSet(); // 该方法获得所有品牌

    @Query("select c from HarddiskEntity c where c.brands = :brand")
    List<HarddiskEntity> findNameByBrand(@Param("brand") String brand); // 该方法获得指定品牌的所有系列名

    @Query("select c from HarddiskEntity c where c.brands = :brand and c.name = :name")
    List<HarddiskEntity> findModelByBrandAndName(@Param("brand") String brand, @Param("name") String name); // 该方法获得指定品牌下系列的的所有产品型号名
}
