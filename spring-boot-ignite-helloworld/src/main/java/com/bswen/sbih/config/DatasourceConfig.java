package com.bswen.sbih.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created on 2018/10/19.
 */
@Configuration
public class DatasourceConfig {
    @Bean(name = "dsIgnite")
    @Primary
    @ConfigurationProperties(prefix="spring.datasourceIgnite")
    public DataSource igniteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcIgnite")
    @Autowired
    public JdbcTemplate igniteJdbcTemplate(@Qualifier("dsIgnite") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
