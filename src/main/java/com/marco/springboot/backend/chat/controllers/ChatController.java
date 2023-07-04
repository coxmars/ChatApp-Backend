package com.marco.springboot.backend.chat.controllers;

import com.marco.springboot.backend.chat.models.Mensaje;
import com.marco.springboot.backend.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final SimpMessagingTemplate webSocket;

    @Autowired
    public ChatController (ChatService chatService,SimpMessagingTemplate webSocket) {
        this.chatService = chatService;
        this.webSocket = webSocket;
    }

    // Colores para diferenciar a los usuarios que se conectan al chat
    private final String[] colores = {"red","green","orange","blue","black","gray","yellow"};

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibeMensaje (Mensaje mensaje) {
        mensaje.setFecha(new Date().getTime());
        if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
            mensaje.setColor(colores[new Random().nextInt(colores.length)]);
            mensaje.setTexto("se ha unido");
        }
        else {
            chatService.guardar(mensaje);
        }
        return mensaje;
    }

    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String escribiendoMensaje (String username) {
        return username.concat(" está escribiendo...");
    }


    @MessageMapping("/historial")
    public void historial (String clienteId) {
        webSocket.convertAndSend("/chat/historial/" + clienteId, chatService.obtenerUltimos20Mensajes());
    }

}
