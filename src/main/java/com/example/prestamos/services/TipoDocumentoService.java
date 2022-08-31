package com.example.prestamos.services;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.repository.InterfaceTipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    // Metodo que permite crear un documento
    public Response createTipoDocumento(TipoDocumento data){

        //Validar si el documento ya existe
        /*ArrayList<TipoDocumento> documentos = this.tipoDocumentoRepository.findByNombre(data.getNombreDocumento());
        if(documentos != null && documentos.size() >= 0){
            Response response = new Response();
            response.setCode(500);
            response.setMessage("tipo documento ya esta registrado");
            return response;
        }*/
        //Crear el documento
        this.tipoDocumentoRepository.save(data);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("tipo documento registrado correctamente");
        return response;
    }
}