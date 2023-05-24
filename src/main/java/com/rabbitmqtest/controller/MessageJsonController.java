package com.rabbitmqtest.controller;

import com.rabbitmqtest.dto.UserDto;
import com.rabbitmqtest.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {

    private final RabbitMQJsonProducer jsonProducer;
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDto user) {
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent successfully!");

    }
}
