package sbdd.config;

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
 * Created by  on 2018/4/25.
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "dsMaster")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name="dsCustom")
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("root")
                .password("123456")
                .url("jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }

    @Bean(name = "jdbcMaster")
    @Autowired
    public JdbcTemplate masterJdbcTemplate(@Qualifier("dsMaster") DataSource dsMaster) {
        return new JdbcTemplate(dsMaster);
    }

    @Bean(name = "jdbcCustom")
    @Autowired
    public JdbcTemplate customJdbcTemplate(@Qualifier("dsCustom") DataSource dsCustom) {
        return new JdbcTemplate(dsCustom);
    }
}
