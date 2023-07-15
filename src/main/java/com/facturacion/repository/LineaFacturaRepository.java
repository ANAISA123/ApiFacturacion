package com.facturacion.repository;

import com.facturacion.models.LineaFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaFacturaRepository extends JpaRepository<LineaFactura, Long> {
}
