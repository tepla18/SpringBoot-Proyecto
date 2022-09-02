package com.example.prestamos.services;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.repository.InterfaceTipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TipoDocumentoService {

    private InterfaceTipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(InterfaceTipoDocumentoRepository rep) {
        this.tipoDocumentoRepository = rep;
    }

    //metodo que trae la lista de tipo_documento
    public ArrayList<TipoDocumento> selectAll() {
        return (ArrayList<TipoDocumento>) this.tipoDocumentoRepository.findAll();
    }

    //metodo que permite buscar un documento por Id
    public TipoDocumento selectById(int id){
        Optional<TipoDocumento> exists = this.tipoDocumentoRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else {
            return null;
        }
    }

    // Metodo que permite crear un documento
    public Response createTipoDocumento(TipoDocumento data){

        //Validar si el documento ya existe
        ArrayList<TipoDocumento> documentos = this.tipoDocumentoRepository.findByNombre(data.getNombreDocumento());
        if(documentos != null && documentos.size() > 0){
            Response response = new Response();
            response.setCode(500);
            response.setMessage("tipo documento ya esta registrado");
            return response;
        }
        //Crear el documento
        this.tipoDocumentoRepository.save(data);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("tipo documento registrado correctamente");
        return response;
    }

    //metodo que permite eliminar un tipo documento
    public Response deleteTipoDocumentoById(int id){
        Response response = new Response();
        try{
            this.tipoDocumentoRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("tipo documento eliminado correctamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }
    }

    // Actualizar tipo documento
    public Response actualizarTipoDocumento (TipoDocumento data){
        Response response = new Response();
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id del tipo documento no es valido" );
            return response;
        }
        //validar si el tipo documento existe
        TipoDocumento exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, tipo de documento no existe en la base de datos");
            return response;
        }
        if (data.getNombreDocumento().equals(null) || data.getNombreDocumento().equals("")){
            response.setCode(500);
            response.setMessage("Error, tipo de documento no especificado");
            return response;
        }
        exists.setNombreDocumento(data.getNombreDocumento());
        this.tipoDocumentoRepository.save(exists);
        response.setCode(200);
        response.setMessage("Tipo documento modificado crectamente");
        return response;
    }
}