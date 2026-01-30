package org.example.repository;

import org.example.model.Usuarios_Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios_Stand, Long> {
    List<Usuarios_Stand> findByNombreUsuario(String nombre);
}
