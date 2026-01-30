package org.example.service;

import org.example.model.Arcos;
import org.example.repository.ArcosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArcosService {

    // HAY QUE IMPORTAR EL MODEL DE LA CLASE A LA QUE LE VAMOS A HACER EL SERVICIO
    // TRAER LOS MÉTODOS CRUD
    @Autowired
    private ArcosRepository arcosRepository;

    // GUARDAR
    public Arcos save(Arcos arco){
        return arcosRepository.save(arco);
    }

    // GUARDAR MÁS DE UNO
    public Optional<List<Arcos>> saveVarios(List<Arcos> arcos){
        return Optional.of(arcosRepository.saveAll(arcos));
    }

    // BUSCAR POR ID, OPTIONAL POR SI NO EXISTE EL ARCO
    public Optional<Arcos> findById(Long id){
        return arcosRepository.findById(id);
    }

    // BUSCAR POR NOMBRE
    public Optional<List<Arcos>> findByNombre_Parte(String nombre){
        return Optional.ofNullable(arcosRepository.findByNombreParte(nombre));
    }

    // LISTAR TODOS LOS ARCOS
    public List<Arcos> findAll(){
        return arcosRepository.findAll();
    }

    // BORRAR POR ID
    public void deleteById(Long id){
        arcosRepository.deleteById(id);
    }

    // VER SI EXISTE O NO EL ARCO
    public boolean existe(Long id){
        return arcosRepository.existsById(id);
    }

}
