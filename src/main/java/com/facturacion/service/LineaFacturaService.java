package com.facturacion.service;

import com.facturacion.models.LineaFactura;

import java.util.List;

public interface LineaFacturaService {
    public List<LineaFactura> getAll();

    public LineaFactura getById(Long id);

    public LineaFactura save(LineaFactura lineaFactura);

    public void deleteById(Long id);

    public LineaFactura update(LineaFactura lineaFactura);
}
