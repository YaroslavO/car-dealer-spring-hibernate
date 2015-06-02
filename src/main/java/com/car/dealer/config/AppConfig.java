package com.car.dealer.config;

import com.car.dealer.service.ConsoleWriter;
import com.car.dealer.service.CarDealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Configuration
@ComponentScan(basePackages = "com.car.dealer")
@Import(DatabaseConfig.class)
public class AppConfig {

    @Bean(name = "carDealer")
    @Autowired
    public CarDealer getCarDealer() {
        return new CarDealer();
    }

    @Bean(name = "consoleWriter")
    @Autowired
    public ConsoleWriter getConsoleWriter() {
        return new ConsoleWriter();
    }
}
