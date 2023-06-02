package com.atbjut.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Boss {

    private String userName;
    private Integer age;
    private Date birth;
    private Car car;
}
