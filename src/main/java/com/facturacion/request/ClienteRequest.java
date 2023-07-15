package com.facturacion.request;

import com.facturacion.models.Cliente;
import lombok.Data;


import javax.validation.constraints.NotBlank;
@Data
public class ClienteRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String direccion;

    private int telefono;

    @NotBlank
    private String email;

    public Cliente toClienteModal() {
        Cliente cliente = new Cliente(
                this.getNombre(),
                this.getApellido(),
                this.getDireccion(),
                this.getTelefono(),
                this.getEmail()
        );


        return cliente;

    }
}
