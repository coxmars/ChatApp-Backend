package com.marco.springboot.backend.chat.models.documents;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Mensaje implements Serializable {
    private String texto;
    private Long fecha;
    @Serial
    private static final long serialVersionUID = -3777582564067492550L;

}
