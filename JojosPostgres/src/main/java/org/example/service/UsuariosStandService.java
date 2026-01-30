package org.example.service;

import org.example.model.Usuarios_Stand;
import org.example.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosStandService {

    // TRAEMOS REPO
    @Autowired
    private UsuariosRepository usuariosRepository;

    // GUARDAMOS USUARIO
    public Usuarios_Stand save(Usuarios_Stand usuario){
        return usuariosRepository.save(usuario);
    }

    // BUSCAR POR ID CON OPTIONAL
    public Optional<Usuarios_Stand> findById(Long id){
        return usuariosRepository.findById(id);
    }

    // BUSCAR POR NOMBRE
    public List<Usuarios_Stand> findByNombre_Usuario(String nombre){
        return usuariosRepository.findByNombreUsuario(nombre);
    }

    // LISTAR TODO
    public List<Usuarios_Stand> findAll(){
        return usuariosRepository.findAll();
    }

    // BORRAR POR ID
    public void deleteById(Long id){
        usuariosRepository.deleteById(id);
    }

}
