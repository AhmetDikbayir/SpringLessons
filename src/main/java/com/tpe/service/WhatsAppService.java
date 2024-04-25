package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.Repository;

public class WhatsAppService implements MessageService{

    private Repository repo;

    public WhatsAppService(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız whatsapp ile gönderiliyor... " + message);

    }


    @Override
    public void saveMessage(Message message) {

    }
}
