package entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude="sucursales")

public class Empresa {
    private Long id;
    private String nombreEmpresa;
    private String razonSocial;
    private Integer cuit;
    private String logo;


    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

}
