package com.facturacion.service;

import com.facturacion.commons.ResourceNotFoundException;
import com.facturacion.models.Cliente;
import com.facturacion.models.Factura;
import com.facturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private FacturaRepository repository;

    @Autowired
    private ClienteService serviceCliente;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("La Factura con id: " + id + " no se encontro"));
    }

    @Override
    @Transactional
    public Factura save(Factura factura) {
        Cliente clienteDB = serviceCliente.getById(factura.getCliente().getId());
        factura.setCliente(clienteDB);
        return repository.save(factura);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public Factura update(Factura factura) {
        return null;
    }
}
