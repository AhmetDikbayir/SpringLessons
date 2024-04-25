package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("slack_service")
public class SlackService implements MessageService{

    @Autowired
    @Qualifier("dbRepository")
    private Repository repo;

    @Autowired
    private Random random;

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
}
