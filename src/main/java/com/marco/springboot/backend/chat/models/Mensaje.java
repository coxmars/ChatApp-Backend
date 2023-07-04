package com.marco.springboot.backend.chat.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@Document(collection="mensajes")
public class Mensaje implements Serializable {
    @Id
    private String id;
    private String texto;
    private Long fecha;
    private String username;
    private String tipo;
    private String color;
    @Serial
    private static final long serialVersionUID = -3777582564067492550L;

}
