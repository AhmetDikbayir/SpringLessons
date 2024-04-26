package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;

@Component("slack_service")
public class SlackService implements MessageService{

    @PostConstruct //bu anotasyon metodun classın constructorı kullanıldıktan hemen sonra çağrılmasını sağlar
    public void postConstruct(){
        System.out.println("----> SlackService objesi üretildi.");
    }

    @PreDestroy //bu anatasyon metodun classın objesi imha edilmeden hemen önce çağrılmasını sağlar
    public void preDestroy(){
        System.out.println("<---- SlackService objesi imha edildi.");
    }

    @Autowired
    @Qualifier("dbRepository")
    private Repository repo;

    @Autowired
    private Random random;

    @Autowired
    private Properties properties;

    public SlackService(Random random) {
        this.random = random;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesaj slack ile gönderiliyor. Mesaj : " + message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        System.out.println(random.nextInt(20));
        repo.save(message);
    }

    @Value("${eposta}")
    private String email;
    @Value("${phone}")
    private String phone;

    public void printContact(){
        System.out.println("e-mail : " + email);
        System.out.println("phone : " + phone);
    }

    public void getContact(){
        System.out.println("email : " + properties.getProperty("mymail"));
        System.out.println("phone : " + properties.getProperty("myphone"));
    }



}
