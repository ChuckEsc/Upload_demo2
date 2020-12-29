package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
//作用：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
public class UploadApplication {

//    Tue Sep 29 15:28:18 CST 2020
    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class, args);
    }

}
