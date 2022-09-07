package com.example.prestamos.services;


import com.example.prestamos.entities.User;
import com.example.prestamos.repository.InterfaceUserRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    private InterfaceUserRepository userRepository;

    public UserService(InterfaceUserRepository rep){
        this.userRepository = rep;
    }

    // Buscar todos los usuarios
    public ArrayList<User> selectAll(){
        return (ArrayList<User>) this.userRepository.findAll();
    }

    // Crear  usuario
    public Response createUser(User data){
        Response response = new Response();

        //validar correo...
        if(!validarEmailAddress(data.getCorreoElectronico())){
            response.setCode(500);
            response.setMessage("Error, el usuario dado no es válido.");
            return  response;
        }

        //validar password
        if (data.getPassword().equals(null) && data.getPassword().equals("")) {
            response.setCode(500);
            response.setMessage("Contraseña incorrecta");
            return response;
        }

        // validar que no se repita el correo
        ArrayList<User> exists = this.userRepository.validaCorreo(data.getCorreoElectronico());
        if(exists != null && exists.size() > 0){
            response.setCode(500);
            response.setMessage("correo electronico ya esta en uso");
            return response;
        }

        this.userRepository.save(data);
        response.setCode(200);
        response.setMessage("usuario registrado correctamente");
        return response;
    }

    // Buscar usuario por Id
    public User selectById(int id){
        Optional<User> exists = this.userRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else{
            return null;
        }
    }

    // Eliminar usuario
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
        // Validar nombre
        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, nombre no especificado");
            return response;
        }
        // Validar apellido
        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, apellido no especificado");
            return response;
        }
        // Validar tipo de documento
        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, tipo documento no especificado");
            return response;
        }
        // Validar numero de documento
        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, numero de documento no especificado");
            return response;
        }
        // Validar edad
        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, edad no especificada");
            return response;
        }
        // Validar correo
        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, correo no especificado");
            return response;
        }
        // Actulizar datos
        exists.setNombres(data.getNombres());
        exists.setApellidos(data.getApellidos());
        exists.setTipoDocumento(data.getTipoDocumento());
        exists.setNumeroDocumento(data.getNumeroDocumento());
        exists.setEdad(data.getEdad());
        exists.setCorreoElectronico(data.getCorreoElectronico());

        this.userRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado crectamente");
        return response;
    }

    // Login
    public Response loginUser(User data){
        Response response = new Response();

        //validar correo...
        if(!validarEmailAddress(data.getCorreoElectronico())){
            response.setCode(500);
            response.setMessage("Error, el usuario dado no es válido.");
            return  response;
        }

        //validar password
        if (data.getPassword().equals(null) && data.getPassword().equals("")) {
            response.setCode(500);
            response.setMessage("Contraseña incorrecta");
            return response;
        }

        ArrayList<User> exists = this. userRepository.validaCredenciales(data.getCorreoElectronico(), data.getPassword());
        if (exists != null && exists.size() > 0) {
            response.setCode(200);
            response.setMessage("datos correctos");
            return response;
        }

        response.setCode(500);
        response.setMessage("Error, datos de acceso no son validos");
        return response;
    }

    // Validar correo electronico
    public boolean validarEmailAddress(String correoElectronico) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher =emailPat.matcher(correoElectronico);
        return matcher.find();
    }


}