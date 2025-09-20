package entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude="pais")
@Builder

public class Provincia {
    private Long id;
    private String nombreProvincia;

    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();
    private Pais pais;
}
