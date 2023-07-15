package com.facturacion.controller;

import com.facturacion.models.Factura;
import com.facturacion.models.Producto;
import com.facturacion.request.FacturaRequest;
import com.facturacion.request.ProductoRequest;
import com.facturacion.service.FacturaService;
import com.facturacion.web.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController//
@RequestMapping("/facturas")//
public class FacturaController {
    @Autowired
    private FacturaService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK,  "Listado Facturas", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {

        return ResponseOk.createResponse(HttpStatus.OK, "Factura con id: " + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> save(@RequestBody @Valid FacturaRequest facturaRequest) {
        Factura facturaBD = service.save(facturaRequest.toFacturaModal());
        return ResponseOk.createResponse(HttpStatus.OK, "Factura nueva creada ", service.save(facturaBD) );
    }
}
