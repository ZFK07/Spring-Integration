package io.spring.integration.springintegration.controller;

import io.spring.integration.springintegration.gateways.ImageGateway;
import io.spring.integration.springintegration.gateways.IntegrationGateway;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integrate")
@AllArgsConstructor
public class IntegrationController {
    private IntegrationGateway integrationGateway;
    private ImageGateway imageGateway;

    @GetMapping(value = "{name}")
    public String getMessageFromIntegrationService(@PathVariable("name") String name){
        return integrationGateway.sendMessage(name);
    }

    @GetMapping(value = "image/{name}")
    public String getImageFromIntegrationService(@PathVariable("name") String name){
        return imageGateway.sendProcessedImage(name);
    }

}
