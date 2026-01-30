package org.example.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "arcos")
public class Arcos {

    @Id
    private String id;


    private Long idArco;
    private String nombreParte;
    private Integer numeroParte;
    private String protagonista;

    private List<Usuarios_Stand> usuarios;



    public Arcos(){}




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdArco() {
        return idArco;
    }

    public void setIdArco(Long idArco) {
        this.idArco = idArco;
    }

    public String getNombreParte() {
        return nombreParte;
    }

    public void setNombreParte(String nombreParte) {
        this.nombreParte = nombreParte;
    }

    public Integer getNumeroParte() {
        return numeroParte;
    }

    public void setNumeroParte(Integer numeroParte) {
        this.numeroParte = numeroParte;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public List<Usuarios_Stand> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios_Stand> usuarios) {
        this.usuarios = usuarios;
    }

}
