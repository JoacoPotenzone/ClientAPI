package com.coderhouse.ClientAPIRest.controller;

import com.coderhouse.ClientAPIRest.middleware.ResponseHandler;
import com.coderhouse.ClientAPIRest.model.Client;
import com.coderhouse.ClientAPIRest.model.ClientDTO;
import com.coderhouse.ClientAPIRest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping(path = "/client")
public class ClientController{
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Object> crearCliente(@RequestBody Client cliente){
        try{
            System.out.println(cliente);
            Client clienteGuardado = clientService.crearCliente(cliente);
            return ResponseHandler.generateResponse(
                    "Data obtenida exitosamente",
                    HttpStatus.OK,
                    clienteGuardado
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            ClientDTO clientFound = clientService.getClient(id);
            return ResponseHandler.generateResponse(
                    "Client found successfully",
                    HttpStatus.OK,
                    clientFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

}