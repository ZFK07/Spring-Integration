package io.spring.integration.springintegration.gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {
    @Gateway(requestChannel = "integration.gateway.channel")
    public String sendMessage(String message);
}
