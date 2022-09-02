package com.example.prestamos.controllers;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TipoDocumetoController {

    //inicilizar dependencias
    private TipoDocumentoService tipoDocumentoService;

    public TipoDocumetoController(TipoDocumentoService service){
        this.tipoDocumentoService = service;
    }

    @RequestMapping("gettipodocumentos")
    public ArrayList<TipoDocumento> getTipoDocumentos(){
        return this.tipoDocumentoService.selectAll();
    }

    @RequestMapping("gettipodocumento/{id}")
    public TipoDocumento gettipodocumento(@PathVariable int id){
        return this.tipoDocumentoService.selectById(id);
    }

    @PostMapping("createtipodocumento")
    public Response createTipoDocumento(@RequestBody TipoDocumento request){
        return this.tipoDocumentoService.createTipoDocumento(request);
    }

    @DeleteMapping("deletetipodocumento/{id}")
    public Response deleteTipoDocumento(@PathVariable int id){
        return this.tipoDocumentoService.deleteTipoDocumentoById(id);
    }

    @PutMapping("actualizartipodocumento/{id}")
    public Response updateTipoDocumento(@RequestBody TipoDocumento request){
        return this.tipoDocumentoService.actualizarTipoDocumento(request);
    }
}
