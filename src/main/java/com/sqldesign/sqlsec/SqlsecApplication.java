package com.sqldesign.sqlsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = {"com.sqldesign.sqlsec.mapper"})
@SpringBootApplication
public class SqlsecApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlsecApplication.class, args);
    }

}
