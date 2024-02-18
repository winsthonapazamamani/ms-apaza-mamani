package com.codigo.msapazamamani.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(getProperties());
        Environment env = app.run(args).getEnvironment();
        log.info("""
                        Access URLs:
                        ----------------------------------------------------------
                        \tLocal: \t\thttp://127.0.0.1:{}
                        \tExternal: \thttp://{}:{}
                        ----------------------------------------------------------""",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("server.port", "8080");
        props.setProperty("spring.datasource.url", "jdbc:postgresql://localhost:5432/examen1");
        props.setProperty("spring.datasource.username", "postgres");
        props.setProperty("spring.datasource.password", "your-password-here");
        props.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("spring.jpa.hibernate.ddl-auto", "update");
        props.setProperty("spring.jpa.show-sql", "true");
        return props;
    }

}