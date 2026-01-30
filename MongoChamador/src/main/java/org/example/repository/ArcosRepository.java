package org.example.repository;

import org.example.model.Arcos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArcosRepository extends MongoRepository<Arcos,Long> {
}
