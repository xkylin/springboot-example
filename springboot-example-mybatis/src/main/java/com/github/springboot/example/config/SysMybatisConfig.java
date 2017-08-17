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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * sys数据库整合Mybatis配置
 */
@Configuration
@MapperScan(basePackages = "com.github.springboot.example.repository.sys", sqlSessionTemplateRef = "sysSqlSessionTemplate")
public class SysMybatisConfig {

    // 配置数据源
    @Bean(name = "sysDataSource")
    public DataSource sysDataSource(SysDsConfig sysDsConfig) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(sysDsConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(sysDsConfig.getPassword());
        mysqlXaDataSource.setUser(sysDsConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("sysDataSource");

        xaDataSource.setMinPoolSize(sysDsConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(sysDsConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(sysDsConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(sysDsConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(sysDsConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(sysDsConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(sysDsConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(sysDsConfig.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "sysSqlSessionFactory")
    public SqlSessionFactory sysSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setTypeAliasesPackage("com.github.springboot.example.entities");
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mapper/sys/*.xml"));
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis/mybatis-config.xml"));
        return bean.getObject();
    }

    @Bean(name = "sysSqlSessionTemplate")
    public SqlSessionTemplate sysSqlSessionTemplate(
            @Qualifier("sysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
