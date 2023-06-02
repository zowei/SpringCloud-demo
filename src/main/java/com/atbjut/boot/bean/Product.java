package com.atbjut.boot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class Product {

    private Integer id;
    private String name;
    private Float price;
    private Integer category;

}
