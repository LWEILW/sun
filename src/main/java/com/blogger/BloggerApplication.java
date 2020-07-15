package com.blogger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * 启动程序
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 */
@SpringBootApplication
@MapperScan("com.blogger.dao*")
@EnableCaching
public class BloggerApplication {

    public static void main(String[] args) {

        SpringApplication.run(BloggerApplication.class, args);
    }


}
