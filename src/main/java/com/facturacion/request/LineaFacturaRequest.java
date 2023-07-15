package com.facturacion.request;

import com.facturacion.models.Factura;
import com.facturacion.models.LineaFactura;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LineaFacturaRequest {

    private int cantidad;

    private double descuento;

    @JsonProperty("producto_id")
    private Long productoId;

    public LineaFactura toLineaFacturaModal() {
        LineaFactura lineaFactura = new LineaFactura(
                this.getCantidad(),
                this.getDescuento(),
                this.getProductoId()
        );
        return lineaFactura;
    }
}