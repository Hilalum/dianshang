package com.zhgy.dao;

import com.zhgy.entity.MemorybarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemorybarDao extends PagingAndSortingRepository<MemorybarEntity, String> {
    @Query("select c from MemorybarEntity c")
    List<MemorybarEntity> findBrandSet(); // 该方法获得所有品牌

    @Query("select c from MemorybarEntity c where c.brands = :brand")
    List<MemorybarEntity> findNameByBrand(@Param("brand") String brand); // 该方法获得指定品牌的所有系列名

    @Query("select c from MemorybarEntity c where c.brands = :brand and c.name = :name")
    List<MemorybarEntity> findModelByBrandAndName(@Param("brand") String brand, @Param("name") String name); // 该方法获得指定品牌下系列的的所有产品型号名
}
