package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MessageService;
import com.tpe.service.SlackService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MessageApplicationSpring {
    public static void main(String[] args) {
        Message message = new Message();
        message.setBody("Welcome Spring");

        //config classını okur ve componentscan ile componentları ve beanleri tarar ve her birinden
        //sadece 1 tane Spring bean olusturur ve contexte atar ve hazır olarak bekletir.
        //bean istenildiğinde gerekliyse içine bağımlılığını da enjekte ederek gönderir.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        //mesajımızı SmsService ile göndermek istiyoruz.
        MessageService service=context.getBean(SmsService.class);//newlemedik rica ettik :)
        service.sendMessage(message);

        MessageService service2=context.getBean("smsService", MessageService.class);
        service2.sendMessage(message);

        //mesajımızı SlackService ile gönderelim.
//        MessageService service3 = context.getBean(SlackService.class);
        MessageService service3 = context.getBean("slack_service", MessageService.class);
        //getbean metoduna paramtre olarak parenti verirsek ve birden fazla childi varsa
        //beanin ismini de belirtmeliyiz.
        service3.sendMessage(message);
        service3.saveMessage(message);
        System.out.println("*************");
        service3.sendMessage(message);

        //bağımlılık varsa ne olur?
        MessageService service4 = context.getBean("smsService", MessageService.class);
        service4.saveMessage(message); //smsService i newlemedik
        //                               service repoya bağımlı ama biz enjekte etmedik
        //                               repo objesini de biz oluşturmadık
        //                               Spring sağolsun :)



        //smsServicede setter injection yapılırsa sonradan repo değiştirilebilir.

//        SmsService service5=context.getBean(SmsService.class);
//        service5.saveMessage(message);
//        Repository repository=context.getBean(DbRepository.class);
//        service5.setRepo(repository);
//        service5.saveMessage(message);



        //random bir değer yazdıralım
        //Random random = new Random();
//        Random random = context.getBean(Random.class);
//        System.out.println(random.nextInt(100));

        //context objemiz varsa beani getBean ile isteyip kullanabiliriz
        //diğer classlarda ise enjekte ederek aynı beani kullanabiliriz


        //bean scope
        //1-singleton:default
        //sadece 1 tane bean üretilir her istekte aynı bean verilir
        //beanin tüm life cycle ından Spring sorumludur.


        //2-prototype
        //her istekte yeni bir bean üretilip gönderilir
        //beanin imhasından Spring SORUMLU DEĞİLDİR.

//        MessageService service6=context.getBean(SmsService.class);
//        MessageService service7=context.getBean(SmsService.class);
//
//        if (service6==service7){
//            System.out.println("Aynı objeler");
//            System.out.println(service6);
//            System.out.println(service7);
//        }else {
//            System.out.println("Farklı objeler");
//            System.out.println(service6);
//            System.out.println(service7);
//        }

        System.out.println("***********************");
        SlackService service8 = context.getBean(SlackService.class);
        service8.printContact();
        System.out.println("***********************");

        System.out.println("------------------------");
        service8.getContact();
        System.out.println("------------------");





        context.close();

        System.out.println("context kapatıldı");
        //context.getBean(SmsService.class);


    }
}
