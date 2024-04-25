package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration //bu classta configuration yapılacak
@ComponentScan("com.tpe")//bu pthdeki bütün componentleri tarar ve spring bean oluşturur.
//default olarak path : AppConfiguration classının içinde bulunduğu path tanımlıdır.
public class AppConfiguration {

    //thirdPArty classtan bean olusturmasını sağlar
    @Bean
    public Random random(){
        return new Random();
    }

}
