package org.example.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="arcos")
public class Arcos {

    // EL ID SE GENERARÁ DE FORMA AUTOMÁTICA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_arco")
    private Long idArco;

    @Column(name="nombre_parte",length = 150)
    private String nombreParte;

    @Column(name="numero_parte")
    private Integer numeroParte;

    @Column(name="protagonista",length = 150)
    private String protagonista;

    // RELACIÓN ONETOMANY POOOORQUE EN UN ARCO ( ONE ) PUEDE HABER VARIOS USUARIOS CON STANDS
    @OneToMany(mappedBy = "arco", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // PERMITE SERIALIZAR LA LISTA DE HIJOS
    @JsonManagedReference
    private List<Usuarios_Stand> usuarios=new ArrayList<>();


    // CONSTRUCTORES
    public Arcos() {}
    public Arcos(String nombreParte, Integer numeroParte, String protagonista) {
        this.nombreParte = nombreParte;
        this.numeroParte = numeroParte;
        this.protagonista = protagonista;
    }




    // GETSET
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

    public int getNumeroParte() {
        return numeroParte;
    }

    public void setNumeroParte(int numeroParte) {
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

    public void setUsuarios(List<Usuarios_Stand> usuarios){
        this.usuarios= usuarios;
        if(this.usuarios!=null){
            this.usuarios.forEach(u -> u.setArco(this));
        }
    }
}
