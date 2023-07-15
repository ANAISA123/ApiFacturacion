package com.facturacion.request;

import com.facturacion.models.Producto;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class ProductoRequest {


    @NotBlank
    private String nombre;

    @NotBlank
    private  String descripcion;

    private double precio;

    public Producto toProductoModal(){
        Producto producto = new Producto(
                this.getNombre(),
                this.getDescripcion(),
                this.getPrecio()
                );

        return producto;
    }
}

