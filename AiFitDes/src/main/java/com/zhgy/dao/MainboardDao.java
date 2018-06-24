package com.zhgy.dao;

import com.zhgy.entity.MainboardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MainboardDao extends PagingAndSortingRepository<MainboardEntity, String> {
    @Query("select c from MainboardEntity c")
    List<MainboardEntity> findBrandSet(); // 该方法获得所有品牌

    @Query("select c from MainboardEntity c where c.brands = :brand")
    List<MainboardEntity> findNameByBrand(@Param("brand") String brand); // 该方法获得指定品牌的所有系列名

    @Query("select c from MainboardEntity c where c.brands = :brand and c.name = :name")
    List<MainboardEntity> findModelByBrandAndName(@Param("brand") String brand, @Param("name") String name); // 该方法获得指定品牌下系列的的所有产品型号名
}
