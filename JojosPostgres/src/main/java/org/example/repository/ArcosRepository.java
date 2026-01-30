package org.example.repository;

import org.example.model.Arcos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArcosRepository extends JpaRepository<Arcos,Long> {
    List<Arcos> findByNombreParte(String nombreParte);


    // EN EL REPOSITORY SOLO HAY QUE PONER @REPOSITORY Y EXTENDER JpaRepository <CLASE(tabla), Long>
    // TE TRAE LOS METODOS CRUD findBy DeleteBy, save...
    // SI SE QUIERE HACER UN MÉTODO ESPECÍFICO SE AÑADE EL NOMBRE DE LA COLUMNA AL METODO
}
