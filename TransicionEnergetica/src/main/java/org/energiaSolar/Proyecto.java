package org.energiaSolar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Proyecto {

    private String nombre;
    private String descripcion;
    private EstadoProyecto estado;
    private Rol persona;
    private CaracteristicasPanel caracteristicasPanel;


}
