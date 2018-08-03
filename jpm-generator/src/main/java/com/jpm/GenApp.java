package com.jpm;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import java.util.Properties;

@SpringBootApplication
@MapperScan("com.jpm.gen.dao")
public class GenApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GenApp.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GenApp.class);
    }

    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties p = new Properties();
        p.setProperty("Oracle", "oracle");
        p.setProperty("MySQL", "mysql");
        p.setProperty("SQL Server", "mssql");
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }



}
