package io.syria.devideReadAndWrite.dao.master;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Slf4j
@Configuration
@MapperScan(basePackages = MasterDbConfig.PACKAGE,sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDbConfig {
    static final String PACKAGE = "io.syria.**.dao.master";
    private static final String MAPPER_LOCATION = "classpath*:mapper/master/*.xml";
    //todo ?
    private static final String DOMAIN_PACKAGE = "io.syria.**.domain";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource(){
        //todo 后面改为课上讲的连接池配置
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(this.dbUrl);
        dataSource.setUsername(this.userName);
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setPassword(this.password);

        return dataSource;
    }

    @Bean(name="masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(){
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name="masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDatasource)throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDatasource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MasterDbConfig.MAPPER_LOCATION));
        //todo ?
        sessionFactory.setTypeAliasesPackage(DOMAIN_PACKAGE);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}
