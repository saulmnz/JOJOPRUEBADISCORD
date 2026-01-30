package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Arcos;
import org.example.repository.ArcosRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ArcosService {


    private final ArcosRepository arcosRepository;
    public ArcosService(ArcosRepository arcosRepository){
        this.arcosRepository=arcosRepository;
    }

    public void guardarEnMongo(Arcos arco){
        arco.setId(null);
        arcosRepository.save(arco);
        System.out.println("GUARDADO EN MONGO" + arco.getNombreParte());
    }

    public void exportarJson(){
        List<Arcos> lista = arcosRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nombreArchivo = "mongo.json";
        try(FileWriter escritor = new FileWriter(nombreArchivo)){
            gson.toJson(lista,escritor);
            System.out.println("JSON GENERADO");
        } catch (IOException e) {
            System.out.println("ERROR EXPORTANDO");;
        }
    }

    public void borrarTodo(){
        arcosRepository.deleteAll();
    }


}
