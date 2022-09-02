package com.example.prestamos.controllers;

import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserContoller {

    // Se coloca una propiedad del tipo uderservice
    // para poder trabajar con la logica de negocio de la aplicacion
    private UserService userService;
    // por medio de la inyeccion de dependencias se iniaciliza el servicio
    public UserContoller(UserService service){
        this.userService = service;
    }

    //buscar todos los usuarios
    @RequestMapping("getusuarios")
    public ArrayList<User> getUsuarios(){
        return this.userService.selectAll();
    }

    //buscar usuario por id
    @RequestMapping("getusuario/{id}")
    public User getUsuario(@PathVariable int id){
        return this.userService.selectById(id);
    }

    //crear usuarios
    @PostMapping("createusuario")
    public Response createUser(@RequestBody User request){
        return this.userService.createUser(request);
    }

    // Eliminar un usuario
    @DeleteMapping("deleteusuario/{id}")
    public Response deleteUsuario(@PathVariable int id){
        return this.userService.deleteUserById(id);
    }

    // Actualizar usuario
    @PutMapping("actualizarusuario/{id}")
    public Response updateUser(@RequestBody User request){
        return this.userService.actualizarUsuario(request);
    }

    @PostMapping("login")
    public Response loginUser(@RequestBody User request){
        return this.userService.loginUser(request);
    }
}
