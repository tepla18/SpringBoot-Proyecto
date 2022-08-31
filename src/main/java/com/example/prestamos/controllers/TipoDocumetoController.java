package com.example.prestamos.controllers;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TipoDocumetoController {

    //inicilizar dependencias
    private TipoDocumentoService tipoDocumentoService;

    public TipoDocumetoController(TipoDocumentoService service){
        this.tipoDocumentoService = service;
    }

    @RequestMapping("gettipodocumento")
    public ArrayList<TipoDocumento> getTipoDocumento(){
        return this.tipoDocumentoService.selectAll();
    }

    @PostMapping("createtipodocumento")
    public Response createTipoDocumento(@RequestBody TipoDocumento request){
        return this.tipoDocumentoService.createTipoDocumento(request);
    }

}
