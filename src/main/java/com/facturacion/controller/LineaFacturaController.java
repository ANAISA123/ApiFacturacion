package com.facturacion.controller;

import com.facturacion.service.ClienteService;
import com.facturacion.service.LineaFacturaService;
import com.facturacion.web.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//
@RequestMapping("/lineaFacturas")//
public class LineaFacturaController {
    @Autowired
    private LineaFacturaService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK,  "Listado Linea Factura", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {

        return ResponseOk.createResponse(HttpStatus.OK, "Linea Factura con id: " + id, service.getById(id));
    }
}
