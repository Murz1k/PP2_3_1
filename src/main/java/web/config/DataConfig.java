package web.config;



import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("web")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class DataConfig {

private final Environment environment;
    @Autowired
    public DataConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());
        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter(); //  в качесте JPA провайдера используем хибер
        em.setJpaVendorAdapter(hibernateAdapter);

        Properties properties = new Properties();
        properties.getProperty("db.driver");
        properties.getProperty("hibernate.connection.characterEncoding");
        properties.getProperty("hibernate.dialect");
        properties.getProperty("hibernate.show_sql");
        properties.getProperty("hibernate.connection.CharSet");
        properties.getProperty("hibernate.hbm2ddl.auto");

        em.setJpaProperties(properties);
        em.setPackagesToScan("web");

        return em;

    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getRequiredProperty("db.url"));
        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
        dataSource.setUsername(environment.getRequiredProperty("db.username"));
        dataSource.setPassword(environment.getRequiredProperty("db.password"));

        return dataSource;
    }


    @Bean
    public TransactionManager transactionManager(EntityManagerFactory entityManagerFactory){   //????
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(entityManagerFactoryBean().getDataSource());
        return jpaTransactionManager;
    }
}
