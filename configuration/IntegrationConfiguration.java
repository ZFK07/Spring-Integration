package io.spring.integration.springintegration.configuration;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
@IntegrationComponentScan
@EnableAutoConfiguration
public class IntegrationConfiguration {

    @Bean
    public MessageChannel receiverChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }

}