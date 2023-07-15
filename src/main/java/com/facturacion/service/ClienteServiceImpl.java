package com.facturacion.service;

import com.facturacion.commons.ResourceNotFoundException;
import com.facturacion.models.Cliente;
import com.facturacion.models.Factura;
import com.facturacion.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
            return repository.findAll();
        }


    @Override
    public Cliente getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("El Cliente con id: " + id + " no se encontro"));
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Cliente update(Cliente cliente) {
        return null;
    }
}
