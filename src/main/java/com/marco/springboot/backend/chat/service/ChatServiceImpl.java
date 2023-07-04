package com.marco.springboot.backend.chat.service;

import com.marco.springboot.backend.chat.models.Mensaje;
import com.marco.springboot.backend.chat.repository.IChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final IChatRepository chatRepository;

    @Autowired
    public ChatServiceImpl (IChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<Mensaje> obtenerUltimos20Mensajes() {
        return chatRepository.findFirst20ByOrderByFechaDesc();
    }

    @Override
    public Mensaje guardar(Mensaje mensaje) {
        return chatRepository.save(mensaje);
    }
}
