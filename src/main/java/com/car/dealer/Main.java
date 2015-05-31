package com.car.dealer;

import com.car.dealer.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        CarDealer carDealer = (CarDealer) appContext.getBean("carDealer");
        carDealer.init();
        Calculator calculator = (Calculator) appContext.getBean("calculator");
        calculator.display();
    }
}
