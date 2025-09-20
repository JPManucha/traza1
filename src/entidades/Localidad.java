package entidades;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude="provincia")
@Builder

public class Localidad {
    private Long id;
    private String nombreLocalidad;

    private Provincia provincia;

}
