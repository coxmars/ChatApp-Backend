package com.marco.springboot.backend.chat.repository;

import com.marco.springboot.backend.chat.models.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IChatRepository extends MongoRepository<Mensaje, String> {
    List<Mensaje> findFirst20ByOrderByFechaDesc();
}
