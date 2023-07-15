package com.facturacion.service;

import com.facturacion.models.Cliente;
import com.facturacion.models.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> getAll();

    public Producto getById(Long id);

    public Producto save(Producto producto);

    public void deleteById(Long id);

    public Producto update(Producto producto);
}
