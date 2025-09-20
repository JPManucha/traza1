package entidades;

import lombok.*;

import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude="localidad")
@Builder
@NonNull


public class Domicilio {
    @NonNull private Long id;
    private String calle;
    private Integer numero;
    private Integer cp;
    private Integer piso;
    private Integer nroDpto;

    private Localidad localidad;


}
