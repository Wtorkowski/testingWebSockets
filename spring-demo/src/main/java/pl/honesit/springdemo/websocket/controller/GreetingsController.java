package pl.honesit.springdemo.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingsController {

    @MessageMapping("/news")
    @SendTo("/topic/news")
    public Greeting greeting(@Payload String message) {
        return message;
    }
}
