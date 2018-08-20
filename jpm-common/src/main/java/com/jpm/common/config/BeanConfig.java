package com.jpm.common.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @description: bean配置
 * @author: 李杰
 * @create: 2018-08-15 16:34
 **/
@Configuration
public class BeanConfig {

    /*@Bean
    public JpmStandarDialect jpmDialect() {
        return new JpmStandarDialect();
    }*/

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

    /*@Bean
    public StandardExpressionObjectFactory standardExpressionObjectFactory(){
        StandardExpressionObjectFactory seof=new StandardExpressionObjectFactory();
        seof.buildObject()
    }*/
}
