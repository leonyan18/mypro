package config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
public class DataConfig {
    /**
     * 数据源配置
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring");
        ds.setUsername("root");
        ds.setPassword("0709");
        return ds;
    }

    /**
     * sessionFactoryBean
     */
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan("entity");
        Properties pros = new Properties();
        pros.setProperty("dialect", "org.hibernate.dialect.MySQL57Dialect");
        sfb.setHibernateProperties(pros);
        return sfb;
    }
    /**
     * 异常转换
     */
    @Bean
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     *容器管理类型的jpa
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL57Dialect");
        return hibernateJpaVendorAdapter;
    }

    /**
     *entityManagerFactory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
            LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
            entityManagerFactory.setDataSource(dataSource);
            entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
            entityManagerFactory.setPackagesToScan("entity");
            return entityManagerFactory;
    }

    /**
     * jpa规范
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor paPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }

}