package org.energiaSolar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CaracteristicasPanel {

    private String ubicacion;
    private String radiacion;
    private String eficiencia;
    private String area;
    private TipoPanel tipoPanel;

}
