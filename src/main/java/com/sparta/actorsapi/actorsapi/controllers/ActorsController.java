package com.sparta.actorsapi.actorsapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.actorsapi.actorsapi.dataobjects.Actor;
import com.sparta.actorsapi.actorsapi.services.SakilaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ActorsController {
    // id is parameter
    @Autowired
    SakilaDAO dao;

    @Autowired
    ObjectMapper mapper;
    // alternative


    @PostMapping("/newActor")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void insertActor(@RequestBody Actor newActor){
        dao.addActor(newActor);
    }


    @GetMapping("/actors/{id}")
    public Actor actorDetails(@PathVariable int id){
        try {
            return dao.getActor(id);
        } catch (Exception e) {
            System.out.println(" Error when connecting");
            throw new RuntimeException(e);
        }
//        return new Actor(id, "Fred", "Bloggs", new Date());
    }


//     example
//    @GetMapping("actors/{fname}/{lname}")
//    public Actor getActorByName(@PathVariable String fname, @PathVariable String lname){
//        return dao.getActor(fname, lname);
//    }

    @GetMapping("/actors")
    public Actor getActorParam(@RequestParam int actor_id){
        try {
            return dao.getActor(actor_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    public String webRoot(){
        return "<h1>No Results</h1>";
    }

    @GetMapping("/actorsAll")
    public List<Actor> allActors(){
        try {
            return dao.getAllActors();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @GetMapping("/actors/{fname}/{lname}")
//    public ResponseEntity<String> getActorByName(@PathVariable String fname, @PathVariable String lname){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("content type", "application/json");
//        try {
//            Actor result = dao.getActor(fname, lname);
//            return new ResponseEntity<String>(mapper.writeValueAsString(result),
//                    headers, HttpStatus.OK);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return new ResponseEntity<String>("{\"message\":\"JSON processing failed\"}", headers, HttpStatus.OK);
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }


}
