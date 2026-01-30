package org.example.model;


public class Usuarios_Stand {

    private Long idUsuario;
    private String nombreUsuario;
    private String nombreStand;
    private String tipoAtaque;

    public Usuarios_Stand(){}

    public Usuarios_Stand(String nombreUsuario, String nombreStand, String tipoAtaque) {
        this.nombreUsuario = nombreUsuario;
        this.nombreStand = nombreStand;
        this.tipoAtaque = tipoAtaque;
    }

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

}
