package org.example.controller;

import org.example.model.Arcos;
import org.example.repository.ArcosRepository;
import org.example.service.ArcosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/postgres/arcos")
public class RestArcos {

    @Autowired
    private ArcosService arcosService;

    // CREAR UN ARCO
    // MÉTODO HTTP POST
    @PostMapping
    // RESPONSE ENTITY REPRESENTA TODA LA RESPUESTA HTTP, ESTO REPRESENTA, EL BODY ( ARCO O USUARIO ), EL CODIGO DEL ESTADO Y LAS CABECERAS
    public ResponseEntity<Arcos> create(@RequestBody Arcos arco){
        // SI ARCO ( OBTENEMOS LOS USUARIOS DEL ARCO ) -> SI EN ESE ARCO HAY USUARIOS
        if(arco.getUsuarios()!=null){
            // OBTENEMOS LOS USUARIOS DEL ARCO Y POR CADA UNO DE ELLOS LOS METEMOS EN EL ARCO
            arco.getUsuarios().forEach(a->a.setArco(arco));
        }
        // GUARDAMOS EL ARCO
        return ResponseEntity.ok(arcosService.save(arco));
    }

    // CREAR VARIOS ARCO
    // MÉTODO HTTP POST
    @PostMapping("/batch")
    // RESPONSE ENTITY REPRESENTA TODA LA RESPUESTA HTTP, ESTO REPRESENTA, EL BODY ( ARCO O USUARIO ), EL CODIGO DEL ESTADO Y LAS CABECERAS
    public ResponseEntity<List<Arcos>> createVarios(@RequestBody List <Arcos> arcos){
        return arcosService.saveVarios(arcos)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }


    // OBTENER POR ID USANDO MAP Y ORELSEGET (OPTIONAL)
    @GetMapping("/{id}")
    public ResponseEntity<Arcos> getById(@PathVariable Long id){
        return arcosService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // OBTENER POR NOMBRE
    @GetMapping("/nombre_arco/{nombre_arco}")
    public ResponseEntity<List<Arcos>> getArcosbyNombre(@PathVariable("nombre_arco")String nombre){
          return arcosService.findByNombre_Parte(nombre)
                  .map(ResponseEntity::ok)
                  .orElseGet(()->ResponseEntity.notFound().build());
    }


    // OBTENER TODOS LOS ARCOS
    @GetMapping
    public ResponseEntity<List<Arcos>> getAll(){
        return ResponseEntity.ok(arcosService.findAll());
    }


    // BORRAR ARCO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (!arcosService.existe(id)){
            return ResponseEntity.notFound().build();
        }
        arcosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
