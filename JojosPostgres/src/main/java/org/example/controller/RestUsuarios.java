package org.example.controller;

import org.example.model.Usuarios_Stand;
import org.example.service.UsuariosStandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgres/usuarios_stand")
public class RestUsuarios {

    @Autowired
    private UsuariosStandService usuariosStandService;


    @PostMapping
    public ResponseEntity<Usuarios_Stand> guardarUsuario (@RequestBody Usuarios_Stand usuario){
        return ResponseEntity.ok(usuariosStandService.save(usuario));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios_Stand> getById (@PathVariable Long id){
        return usuariosStandService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Usuarios_Stand>> getAll(){
        return ResponseEntity.ok(usuariosStandService.findAll());
    }
}
