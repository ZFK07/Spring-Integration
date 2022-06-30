package io.spring.integration.springintegration.gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface ImageGateway {
    @Gateway(requestChannel = "image.jpeg")
    public String sendProcessedImage(String path);

}
