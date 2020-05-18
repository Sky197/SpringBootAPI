package xyz.dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${packages-to-scan}")
    private String packages;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSourceBuilder = new DriverManagerDataSource();
        dataSourceBuilder.setDriverClassName(System.getenv("DB_DRIVER"));
        dataSourceBuilder.setUsername(System.getenv("DB_USER"));
        dataSourceBuilder.setPassword(System.getenv("DB_PASSWORD"));
        dataSourceBuilder.setUrl(System.getenv("JDBC_DB_URL"));
        return dataSourceBuilder;
    }

    @Autowired
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(packages);
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jpaVendorAdapter);
        return em;
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }


}
