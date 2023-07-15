package com.facturacion.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lineaFactura" )
public class LineaFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    private double descuento;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    @JsonIgnoreProperties(value = {"lineaFactura"})
    private Factura factura;

    public LineaFactura(int cantidad, double descuento, Long productoId) {
        this.cantidad = cantidad;
        this.descuento = descuento;

        Producto producto = new Producto();
        producto.setId(productoId);
        this.producto = producto;
    }
}
