package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component //bu classın objeleri spring container tarafından oluşturulur ve yönetilir ve bu objelere özel olarak spring bean adı verilir.
@Scope("prototype")//defaultu budur eğer istersek prototype yapabiliriz
public class SmsService implements MessageService{

    //field injection
//    @Autowired//bağımlılığın enjekte edilesini sağlar
//    @Qualifier("fileRepository")//birden fazla aynı data tipinde bean varsa belirleyici görevi görür.
//    private Repository repo;

    //setter injection

//    private Repository repo;
//
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repository repo) {
//        this.repo = repo;
//    }

    @PostConstruct //bu anotasyon metodun classın constructorı kullanıldıktan hemen sonra çağrılmasını sağlar
    public void postConstruct(){
        System.out.println("----> SmsService objesi üretildi.");
    }

    @PreDestroy //bu anatasyon metodun classın objesi imha edilmeden hemen önce çağrılmasını sağlar
    public void preDestroy(){
        System.out.println("<---- SmsService objesi imha edildi.");
    }

    //constructor injection : daha güvenli, daha anlaşılır, test etmesi daha kolay
    private Repository repo;

    @Autowired
    public SmsService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız sms ile gönderiliyor... Mesaj : " + message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        repo.save(message);

    }
}
