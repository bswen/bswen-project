package com.bswen.multids.config;

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
 * Created by on 2017-1-13.
 *
 * @author xx
 */
@Configuration
public class MultiDatasourceConfig {
    /**
     * The default datasource.
     */
    @Bean(name = "dsMaster")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * The second datasource.
     */
    @Bean(name = "dsSecondary")
    @ConfigurationProperties(prefix="spring.datasource2")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcMaster")
    @Autowired
    public JdbcTemplate masterJdbcTemplate(@Qualifier("dsMaster") DataSource dsMaster) {
        return new JdbcTemplate(dsMaster);
    }

    @Bean(name = "jdbcSecondary")
    @Autowired
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("dsSecondary") DataSource dsMaster) {
        return new JdbcTemplate(dsMaster);
    }
}
