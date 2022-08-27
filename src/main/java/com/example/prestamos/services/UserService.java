package com.example.prestamos.services;

import com.example.prestamos.entities.User;
import com.example.prestamos.repository.InterfaceUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private InterfaceUserRepository userRepository;

    public UserService(InterfaceUserRepository rep){
        this.userRepository = rep;
    }

    //metodo que trae todos los usuarios de la BD
    public ArrayList<User> selectAll(){
        return (ArrayList<User>) this.userRepository.findAll();
    }

}
