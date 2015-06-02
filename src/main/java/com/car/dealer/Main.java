package com.car.dealer;

import com.car.dealer.config.AppConfig;
import com.car.dealer.service.ConsoleWriter;
import com.car.dealer.service.CarDealer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        CarDealer carDealer = (CarDealer) appContext.getBean("carDealer");
        carDealer.init();
        ConsoleWriter consoleWriter = (ConsoleWriter) appContext.getBean("consoleWriter");
        consoleWriter.write();
    }
}
