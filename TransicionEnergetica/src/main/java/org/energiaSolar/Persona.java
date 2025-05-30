package org.energiaSolar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Persona {

    protected String nombre;
    protected String documento;
    protected String ciudad;


    public void mostrarDatosBasicos() {
        System.out.println("\tNombre: " + this.nombre);
        System.out.println("\tDocumento: " + this.documento);
        System.out.println("\tCiudad: " + this.ciudad);
    }
}
