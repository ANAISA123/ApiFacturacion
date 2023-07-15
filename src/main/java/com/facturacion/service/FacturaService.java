package com.facturacion.service;

import com.facturacion.models.Factura;

import java.util.List;

public interface FacturaService {
    public List<Factura> getAll();

    public Factura getById(Long id);

    public Factura save(Factura factura);

    public void deleteById(Long id);

    public Factura update(Factura factura);
}
