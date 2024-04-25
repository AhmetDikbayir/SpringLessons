package com.tpe.controller;

import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.Repository;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.WhatsAppService;

public class MessageApplication {
    public static void main(String[] args) {

        Repository repo = new DbRepository();

        Message message = new Message();
        message.setBody("Spring is COMING");

        //mesajı mail ile gönderelim
//        MailService mailService = new MailService();
//        mailService.sendMessage(message);

        //bu mesajı whatsapp ile gönderelim: 1 service interface tanımlamalıydık
//        WhatsAppService whatsAppService = new WhatsAppService();
//        whatsAppService.sendMessage(message);

        //ref interface almalıydık
        MessageService service = new MailService(repo);
        service.sendMessage(message);

        //newleyerek obje oluşturmak maliyetli, yönetimi zahmetli?

        //mesajı Db ye kaydedelim
        service.saveMessage(message);

        //mesajı dosyaya kaydedilim
        service.saveMessage(message);

        //yeni mesaj service
        MessageService service1 = new MailService(repo);

        //spring is COMING :)



    }
}
