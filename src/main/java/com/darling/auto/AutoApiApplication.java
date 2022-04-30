package com.darling.auto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.darling.auto"})
@EnableTransactionManagement
@MapperScan("com.darling.auto.mapper")
// 生产上目前没有配置redis所以关闭下面的缓存注解
//@EnableCaching
public class AutoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoApiApplication.class, args);
    }

}
