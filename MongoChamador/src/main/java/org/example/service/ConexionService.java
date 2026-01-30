package org.example.service;

import org.example.model.Arcos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ConexionService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8085/postgres/arcos";

    public Arcos getArcosById(Long id){
        try{
            String url = URL + "/" + id;
            ResponseEntity<Arcos> response = restTemplate.exchange(
                    url, HttpMethod.GET,null,Arcos.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e){
            System.out.println("ERROR CONECTANDO A POSTGRES");
            return null;
        }
    }

    public List<Arcos> getArcosByNombre(String nombre){
        try{
            String url=URL + "/nombre_arco/" + nombre;
            ResponseEntity<List<Arcos>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Arcos>>() {
                    }
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("ERROR CONECTANDO A POSTGRES POR NOMBRE");
            return Collections.emptyList();
        }
    }

    public Arcos crearArcos(Arcos arco){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Arcos> request = new HttpEntity<>(arco,headers);
            ResponseEntity<Arcos> response = restTemplate.exchange(
                    URL, HttpMethod.POST, request, Arcos.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e){
            System.out.println("ERROR AL CREAR EN POSTGRES");
            return null;
        }
    }
}
