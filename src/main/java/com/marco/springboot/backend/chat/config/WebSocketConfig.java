package com.marco.springboot.backend.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-websocket")
                .setAllowedOrigins("http://localhost:4200", "https://chat-app-marco.netlify.app")
                .withSockJS(); // Por debajo Stomp utiliza SockJS
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Este es el prefijo para el nombre de los eventos para notificar a los clientes que estan suscritos
        registry.enableSimpleBroker("/chat/");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
