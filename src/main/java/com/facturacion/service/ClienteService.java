package com.facturacion.service;

import com.facturacion.models.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> getAll();

    public Cliente getById(Long id);

    public Cliente save(Cliente cliente);

    public void deleteById(Long id);

    public Cliente update(Cliente cliente);
}
