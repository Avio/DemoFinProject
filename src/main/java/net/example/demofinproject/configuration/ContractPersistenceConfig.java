package net.example.demofinproject.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(basePackages = "net.example.demofinproject.repository.contract",
        entityManagerFactoryRef = "contractEntityManager",
        transactionManagerRef = "contractTransactionManager")
public class ContractPersistenceConfig {



    @Bean(name = "contractDS")
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource contractDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "contractEntityManager")
    public LocalContainerEntityManagerFactoryBean contractEntityManager(@Qualifier("contractDS") DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("net.example.demofinproject.model");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        final HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        em.setJpaPropertyMap(properties);
        em.setPersistenceUnitName("contracts");

        return em;
    }

    @Bean(name = "contractTransactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("contractEntityManager") EntityManagerFactory contractEntityManager){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(contractEntityManager);
        return transactionManager;
    }
}
