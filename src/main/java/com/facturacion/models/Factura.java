package com.facturacion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturas" )
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa;

    private Date fecha;

    private double total;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "factura")
    @JsonIgnoreProperties(value = {"factura"})
    private List<LineaFactura> lineaFactura;


    public Factura(String empresa, double total, Long clienteId, List<LineaFactura> lineaFactura) {
        this.empresa = empresa;
        this.total = total;
        this.lineaFactura = lineaFactura;
        this.fecha = new Date();

        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        this.cliente = cliente;
    }


}
