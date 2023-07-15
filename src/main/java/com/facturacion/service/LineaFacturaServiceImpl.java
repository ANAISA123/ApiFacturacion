package com.facturacion.service;

import com.facturacion.commons.ResourceNotFoundException;
import com.facturacion.models.Cliente;
import com.facturacion.models.LineaFactura;
import com.facturacion.models.Producto;
import com.facturacion.repository.LineaFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LineaFacturaServiceImpl implements LineaFacturaService{
    @Autowired
    private LineaFacturaRepository repository;

    @Autowired
    private ProductoService serviceProducto;

    @Override
    @Transactional(readOnly = true)
    public List<LineaFactura> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public LineaFactura getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("La LineaFactura con id: " + id + " no se encontro"));
    }

    @Override
    public LineaFactura save(LineaFactura lineaFactura) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public LineaFactura update(LineaFactura lineaFactura) {
        return null;
    }
}
