package com.atbjut.boot.mapper;

import com.atbjut.boot.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from product")
    List<Product> getProduct();

    @Select("select * from product where id=#{id}")
    Product getProductById(int id);
}
