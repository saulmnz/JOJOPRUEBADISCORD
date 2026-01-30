package org.example.service;

import org.example.model.Arcos;
import org.example.model.Usuarios_Stand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Secuencia {

    private final ConexionService conexionService;
    private final ArcosService arcosService;

    public Secuencia(ConexionService conexionService, ArcosService arcosService) {
        this.arcosService = arcosService;
        this.conexionService = conexionService;
    }

    public void executar() {
        System.out.println("SECUENCIAAAAA");

        arcosService.borrarTodo();

        List<Usuarios_Stand> Maricon = new ArrayList<>();
        Maricon.add(new Usuarios_Stand("Manolo", "Puto", "Pene"));
        Maricon.add(new Usuarios_Stand("Manue", "Puta", "Polla"));
        Maricon.add(new Usuarios_Stand("Monita", "Putita", "Pollita"));

        Arcos a1 = new Arcos();
        a1.setNombreParte("Maricon");
        a1.setNumeroParte(1);
        a1.setProtagonista("Gilipollas");
        a1.setUsuarios(Maricon);


        List<Usuarios_Stand> Maricona = new ArrayList<>();
        Maricona.add(new Usuarios_Stand("Manolu", "Putotu", "Penetu"));
        Maricona.add(new Usuarios_Stand("Manuelu", "Putatu", "Pollatu"));
        Maricona.add(new Usuarios_Stand("Monitalu", "Putitatu", "Pollitatu"));

        Arcos a2 = new Arcos();
        a2.setNombreParte("Maricona");
        a2.setNumeroParte(2);
        a2.setProtagonista("Gilipollis");
        a2.setUsuarios(Maricona);

        a1 = conexionService.crearArcos(a1);
        a2 = conexionService.crearArcos(a2);


        // AHORA YA METIMOS LOS DATOS EN POSTGRES, TENEMOS QUE SINCRONIZARLOS CON MONGO
        if (a1 != null) {
            System.out.println("\nBUSCANDO POR ID" + a1.getIdArco());

            Arcos sincronizadoId = conexionService.getArcosById(a1.getIdArco());
            if (sincronizadoId != null) {
                arcosService.guardarEnMongo(sincronizadoId);
            }
        }

        // SINCRONIZAR POR NOMBRE DE ARCO
        String arcoBuscar= "Maricona";
        System.out.println("\nBUSCANDO POR NOMBRE"+ arcoBuscar);

        List<Arcos> resultados= conexionService.getArcosByNombre(arcoBuscar);
        System.out.println(resultados);
        if(resultados!=null && !resultados.isEmpty()){

            Arcos recuperadosNombre = resultados.get(0); // COGEMOS EL PRIMERO
            System.out.println(recuperadosNombre);
            arcosService.guardarEnMongo(recuperadosNombre);
        }

        System.out.println("\nGENERANDO JSON");
        arcosService.exportarJson();
    }

}