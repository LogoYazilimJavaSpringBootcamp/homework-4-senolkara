package com.karakurt.answer1.Listener;

import com.karakurt.answer1.Entities.User.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserListener {

    @RabbitListener(queues = "isbasi.email")
    public void handleMessage(User iUser) {
        System.out.println("Call Received...:" + iUser);
        System.out.println("User created....:" + iUser);
    }
}
