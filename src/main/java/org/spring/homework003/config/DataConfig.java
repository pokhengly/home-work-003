package org.spring.homework003.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataConfig {


    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/basic_rest_api_2",
                "postgres",
                "123"
        );
    }

//    @Bean
//    public DataSource dataSource(){
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/basic_rest_api_2");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("123");
//        return dataSourceBuilder.build();
//    }
//
//    public openApi(){
//        Server server = new Server();
//        server.setUrl("http://localhost:8080");
//        server.setDescription("Local server");
//
//        Info infomation = new Info()
//                .title("API")
//                .description("API")
//                .version("1.0.0");
//        return new OpenAPI().info(infomation).servers(List.of(server));
//
//    }


}
