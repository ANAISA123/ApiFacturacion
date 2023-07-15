package com.facturacion.controller;

import com.facturacion.models.Producto;
import com.facturacion.request.ProductoRequest;
import com.facturacion.service.ClienteService;
import com.facturacion.service.ProductoService;
import com.facturacion.web.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController//
@RequestMapping("/productos")//
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK,  "Listado Productos", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {

        return ResponseOk.createResponse(HttpStatus.OK, "Producto con id: " + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> save(@RequestBody @Valid ProductoRequest productoRequest) {
        Producto productoBD = service.save(productoRequest.toProductoModal());
        return ResponseOk.createResponse(HttpStatus.OK, "Producto nuevo creado ", service.save(productoBD) );
    }

}
