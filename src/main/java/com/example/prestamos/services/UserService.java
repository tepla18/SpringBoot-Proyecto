package com.example.prestamos.services;

import com.example.prestamos.entities.User;
import com.example.prestamos.repository.InterfaceUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public Response createUser(User data){
        this.userRepository.save(data);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("usuario registrado correctamente");
        return response;
    }

    // Buscar registro por Id
    public User selectById(int Id){
        Optional<User> exists = this.userRepository.findById(Id);
        if (exists.isPresent()){
            return exists.get();
        }
        else{
            return null;
        }
    }

    // Eliminar un usuario
    public Response deleteUserById(int id){
        Response response = new Response();
        try{
            this.userRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("usuario eliminado correctamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }
    }

    // Actualizar usuario
    public Response actualizarUsuario (User data){
        Response response = new Response();

        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id del usuario no es valido" );
            return response;
        }
        // Validar si el usuario existe
        User exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, el usuario no existe en la base de datos");
            return response;
        }

        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, el usuario no existe en la base de datos");
            return response;
        }
        exists.setCorreoElectronico(data.getCorreoElectronico());
        exists.setEdad(data.getEdad());
        this.userRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado crectamente");
        return response;
    }

}