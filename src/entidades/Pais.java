package entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class Pais {
    private String nombrePais;
    private Long id;
    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();

}
