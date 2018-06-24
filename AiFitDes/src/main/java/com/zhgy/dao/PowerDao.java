package com.zhgy.dao;

import com.zhgy.entity.PowerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PowerDao extends PagingAndSortingRepository<PowerEntity, String> {
    @Query("select c from PowerEntity c")
    List<PowerEntity> findBrandSet(); // 该方法获得所有品牌

    @Query("select c from PowerEntity c where c.brands = :brand")
    List<PowerEntity> findNameByBrand(@Param("brand") String brand); // 该方法获得指定品牌的所有系列名

    @Query("select c from PowerEntity c where c.brands = :brand and c.name = :name")
    List<PowerEntity> findModelByBrandAndName(@Param("brand") String brand, @Param("name") String name); // 该方法获得指定品牌下系列的的所有产品型号名
}
