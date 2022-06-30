package io.spring.integration.springintegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class IntegrationService {
    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void anotherMessage(Message<String> message) {
        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        Message<String> newMessage = MessageBuilder.withPayload("Welcome " + message.getPayload() + " to Spring Integration").build();
        replyChannel.send(newMessage);
    }

    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void anotherMessage2(Message<String> message) {
        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        Message<String> newMessage = MessageBuilder.withPayload("Bye " + message.getPayload() + " to Spring Integration").build();
        replyChannel.send(newMessage);
    }

    @ServiceActivator(inputChannel = "image.jpeg")
    public void processedImage(Message<String> path) {
        MessageChannel replyChannel = (MessageChannel) path.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(path);
        Message<String> newMessage = MessageBuilder.withPayload("Good image").build();
        replyChannel.send(newMessage);


    }
}
