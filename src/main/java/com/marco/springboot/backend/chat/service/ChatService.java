package com.marco.springboot.backend.chat.service;

import com.marco.springboot.backend.chat.models.Mensaje;

import java.util.List;

public interface ChatService {
    List<Mensaje> obtenerUltimos20Mensajes ();
    Mensaje guardar (Mensaje mensaje);
}
