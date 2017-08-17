package com.github.springboot.example.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * boot数据库整合Mybatis配置
 */
@Configuration
@MapperScan(basePackages = "com.github.springboot.example.repository.boot", sqlSessionTemplateRef = "bootSqlSessionTemplate")
public class BootMybatisConfig {

    // 配置数据源
    @Primary
    @Bean(name = "bootDataSource")
    public DataSource bootDataSource(BootDsConfig bootDsConfig) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(bootDsConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(bootDsConfig.getPassword());
        mysqlXaDataSource.setUser(bootDsConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("bootDataSource");

        xaDataSource.setMinPoolSize(bootDsConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(bootDsConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(bootDsConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(bootDsConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(bootDsConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(bootDsConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(bootDsConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(bootDsConfig.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "bootSqlSessionFactory")
    public SqlSessionFactory bootSqlSessionFactory(@Qualifier("bootDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setTypeAliasesPackage("com.github.springboot.example.entities");
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mapper/boot/*.xml"));
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis/mybatis-config.xml"));
        return bean.getObject();
    }

    @Bean(name = "bootSqlSessionTemplate")
    public SqlSessionTemplate bootSqlSessionTemplate(
            @Qualifier("bootSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
