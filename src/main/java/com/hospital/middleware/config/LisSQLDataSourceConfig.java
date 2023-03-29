package com.hospital.middleware.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/*
 * 从库无事务管理
 */
@Configuration
@MapperScan(basePackages = "com.hospital.middleware.*.dao.lis", sqlSessionFactoryRef = "LisSqlSessionFactory")
public class LisSQLDataSourceConfig {

    @Bean(name = "LisDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.lis-datasource")
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "LisSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(
            @Qualifier("LisDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean  ();
        bean.setDataSource(datasource);
        bean.setMapperLocations(// 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/*/mapper/lis/*.xml"));
        return bean.getObject();
    }

    @Bean("LisSqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(
            @Qualifier("LisSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }

}