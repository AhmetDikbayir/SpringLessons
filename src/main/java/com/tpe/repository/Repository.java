package com.tpe.repository;

import com.tpe.domain.Message;
import com.tpe.service.MessageService;

public interface Repository {

    void save(Message message);
}
