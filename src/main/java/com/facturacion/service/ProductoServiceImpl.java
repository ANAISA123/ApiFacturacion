package com.facturacion.service;

import com.facturacion.commons.ResourceNotFoundException;
import com.facturacion.models.Producto;
import com.facturacion.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("El Producto con id: " + id + " no se encontro"));
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }


    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Producto update(Producto producto) {
        return null;
    }
}
