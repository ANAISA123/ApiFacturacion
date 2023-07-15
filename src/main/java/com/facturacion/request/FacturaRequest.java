package com.facturacion.request;

import com.facturacion.models.Factura;
import com.facturacion.models.LineaFactura;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class FacturaRequest {

        @NotBlank
        private String empresa;

        private List<LineaFacturaRequest> lineaFacturas;

        private double total;

        @JsonProperty("cliente_id")
        private Long clienteId;

        public Factura toFacturaModal(){
            List<LineaFactura> lineaFactura = new ArrayList<>();
            for (int i = 0; i < this.lineaFacturas.size(); i++) {
                lineaFactura.add(lineaFacturas.get(i).toLineaFacturaModal());
            }

            Factura factura = new Factura(
                    this.getEmpresa(),
                    this.getTotal(),
                    this.getClienteId(),
                    lineaFactura
            );

            return factura;
        }
}
