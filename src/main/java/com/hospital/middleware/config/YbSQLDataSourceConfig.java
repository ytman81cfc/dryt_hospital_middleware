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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hospital.middleware.*.dao.yb", sqlSessionFactoryRef = "YbSqlSessionFactory")
public class YbSQLDataSourceConfig {
    @Bean(name = "YbDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.yb-datasource")
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "YbSqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(
            @Qualifier("YbDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean  ();
        bean.setDataSource(datasource);
        bean.setMapperLocations(// 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/*/mapper/yb/*.xml"));
        return bean.getObject();
    }

    @Bean("YbSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(
            @Qualifier("YbSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }

}
