package entidades;

import lombok.*;

import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude="empresa")

public class Sucursal {
    private Long id;
    private String nombreSucursal;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean es_Casa_Matriz;

    private Domicilio domicilio;

    private Empresa empresa;



}
