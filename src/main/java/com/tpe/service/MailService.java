package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.Repository;

public class MailService implements MessageService {

    private Repository repo;

    public MailService(Repository repo) {
        this.repo = repo;
    }

    public void sendMessage(Message message){
        System.out.println("Mesajınız mail ile gönderiliyor... " + message);
    }

    @Override
    public void saveMessage(Message message) {
        //DbRepository repo = new DbRepository();
        repo.save(message);

    }
}
