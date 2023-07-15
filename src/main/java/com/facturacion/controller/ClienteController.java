package com.facturacion.controller;


import ch.qos.logback.core.net.server.Client;
import com.facturacion.models.Cliente;
import com.facturacion.models.Producto;
import com.facturacion.request.ClienteRequest;
import com.facturacion.request.ProductoRequest;
import com.facturacion.service.ClienteService;
import com.facturacion.service.FacturaService;
import com.facturacion.web.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController//
@RequestMapping("/clientes")//
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK,  "Listado Clientes", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {

        return ResponseOk.createResponse(HttpStatus.OK, "Cliente con id: " + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> save(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente clienteBD = service.save(clienteRequest.toClienteModal());
        return ResponseOk.createResponse(HttpStatus.OK, "Cliente nuevo creado ", service.save(clienteBD) );
    }
}
