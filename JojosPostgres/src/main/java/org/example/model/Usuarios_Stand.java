package org.example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="usuarios_stand")
public class Usuarios_Stand {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombreUsuario;
    private String nombreStand;
    private String tipoAtaque;

    @ManyToOne
    @JoinColumn(name="id_arco")
    @JsonBackReference
    private Arcos arco;


    // CONSTRUCTORES
    public Usuarios_Stand(){}
    public Usuarios_Stand(String nombreUsuario, String nombreStand, String tipoAtaque, Arcos arco) {
        this.nombreUsuario = nombreUsuario;
        this.nombreStand = nombreStand;
        this.tipoAtaque = tipoAtaque;
        this.arco = arco;
    }


    // GETSET
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreStand() {
        return nombreStand;
    }

    public void setNombreStand(String nombreStand) {
        this.nombreStand = nombreStand;
    }

    public String getTipoAtaque() {
        return tipoAtaque;
    }

    public void setTipoAtaque(String tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

    public Arcos getArco() {
        return arco;
    }

    public void setArco(Arcos arco) {
        this.arco = arco;
    }

}
