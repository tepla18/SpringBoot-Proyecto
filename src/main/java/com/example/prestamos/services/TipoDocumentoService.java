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

    public Response createTipoDocumento(TipoDocumento data){
        Response response = new Response();
        this.tipoDocumentoRepository.save(data);
        response.setCode(200);
        response.setMessage("tipo documento registrado correctamente");
        return response;
    }
}