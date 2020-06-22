package ru.itis.userscrud.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.Locale;
import java.util.logging.LogManager;

@Configuration
@ComponentScan(basePackages = {"ru.itis.userscrud"})
@PropertySource("classpath:application.properties")
@EnableJpaRepositories
@EnableAspectJAutoProxy
public class RootConfig{

    static {
        Collections.list(LogManager.getLogManager().getLoggerNames()).stream().forEach(System.out::println);
    }

    @Autowired
    private Environment environment;


    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("user-persistence");

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(environment.getProperty("db.url"));
        config.setUsername(environment.getProperty("db.user"));
        config.setPassword(environment.getProperty("db.password"));
        config.setDriverClassName(environment.getProperty("db.driver"));
        return config;
    }

    @Bean
    public DataSource hikariDataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(hikariDataSource());
    }


    @Bean("myEntityManager")
    public EntityManager entityManager(){

        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n");
        return messageSource;
    }
}
