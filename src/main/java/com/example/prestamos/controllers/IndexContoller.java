package com.example.prestamos.controllers;

import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class IndexContoller {

    // Se coloca una propiedad del tipo uderservice
    // para poder trabajar con la logica de negocio de la aplicacion
    private UserService userService;
    // por medio de la inyeccion de dependencias se iniaciliza el servicio
    public IndexContoller(UserService service){
        this.userService = service;
    }

    @RequestMapping("/")
    public String index(){
        return "Hello Developers";
    }

    @RequestMapping("getusuarios")
    public ArrayList<User> getUsuarios(){
        return this.userService.selectAll();
    }

    @PostMapping("createusuario")
    public Response createUser(@RequestBody User request){
        return this.userService.createUser(request);
    }
}
