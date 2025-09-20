import entidades.*;
import repositorios.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        Pais argentina = Pais.builder()
                .nombrePais("Argentina")
                .build();
        Provincia buenosAires = Provincia.builder()
                .id(1L)
                .nombreProvincia("Buenos Aires")
                .pais(argentina)
                .build();
        Localidad caba = Localidad.builder()
                .id(1L)
                .nombreLocalidad("CABA")
                .provincia(buenosAires)
                .build();
        Domicilio domicilioCaba1 = Domicilio.builder()
                .id(1L)
                .calle("Anzorena")
                .numero(67)
                .cp(10004)
                .localidad(caba)
                .build();
        Localidad laPlata = Localidad.builder()
                .id(2L)
                .nombreLocalidad("La Plata")
                .provincia(buenosAires)
                .build();
        Domicilio domicilioLaPlata = Domicilio.builder()
                .id(2L)
                .calle("Sajones")
                .numero(1856)
                .piso(2)
                .nroDpto(6)
                .cp(3490)
                .localidad(laPlata)
                .build();
        Provincia cordoba = Provincia.builder()
                .id(2L)
                .nombreProvincia("Cordoba")
                .pais(argentina)
                .build();
        Localidad cordobaCapital = Localidad.builder()
                .id(3L)
                .nombreLocalidad("Cordoba Capital")
                .provincia(cordoba)
                .build();
        Domicilio domicilioCordocaCap = Domicilio.builder()
                .id(3L)
                .calle("La Mona")
                .numero(333)
                .cp(4560)
                .localidad(cordobaCapital)
                .build();
        Localidad villaCarlosPaz = Localidad.builder()
                .id(4L)
                .nombreLocalidad("Villa Carlos Paz")
                .provincia(cordoba)
                .build();
        Domicilio domicilioCarlosPaz = Domicilio.builder()
                .id(4L)
                .calle("El cucu")
                .numero(270)
                .cp(4565)
                .localidad(villaCarlosPaz)
                .build();
        Sucursal sucursal1 = Sucursal.builder()
                .id(1L)
                .nombreSucursal("La primera")
                .domicilio(domicilioCaba1)
                .es_Casa_Matriz(true)
                .horarioApertura(LocalTime.of(9,0))
                .horarioCierre(LocalTime.of(20,0))
                .build();
        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombreSucursal("La primera LP")
                .domicilio(domicilioLaPlata)
                .es_Casa_Matriz(false)
                .horarioApertura(LocalTime.of(10,0))
                .horarioCierre(LocalTime.of(20,30))
                .build();

        Sucursal sucursal3 = Sucursal.builder()
                .id(3L)
                .nombreSucursal("La primera Cba")
                .domicilio(domicilioCordocaCap)
                .es_Casa_Matriz(true)
                .horarioApertura(LocalTime.of(10,0))
                .horarioCierre(LocalTime.of(21,0))
                .build();

        Sucursal sucursal4 = Sucursal.builder()
                .id(4L)
                .nombreSucursal("La cuarta")
                .domicilio(domicilioCarlosPaz)
                .es_Casa_Matriz(false)
                .horarioApertura(LocalTime.of(9,0))
                .horarioCierre(LocalTime.of(20,0))
                .build();

        Empresa empresa1 = Empresa.builder()
                .id(1L)
                .nombreEmpresa("La portenia")
                .build();

        Empresa empresa2 = Empresa.builder()
                .id(2L)
                .nombreEmpresa("La federal")
                .build();

        sucursal1.setEmpresa(empresa1);
        sucursal2.setEmpresa(empresa1);
        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();

        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);

        System.out.println("Todas las empresas:");
        List<Empresa> todasLasEmpresas = empresaRepository.findAll();
        todasLasEmpresas.forEach(System.out::println);

        System.out.println("Buscando por ID:");
        Optional<Empresa> empresa = empresaRepository.findById(3L);
        empresa.ifPresent(e -> System.out.println("Encontrada: " + e));

        System.out.println("Buscando empresa por nombre:");
        List<Empresa> empresaXnombre = empresaRepository.genericFindByField("nombreEmpresa","La portenia");
        empresaXnombre.forEach(System.out::println);


        Empresa empresaActualizada = Empresa.builder()
                .id(1L)
                .nombreEmpresa("Empresa 1 Actualizada")
                .razonSocial("Razon Social 1 Actualizada")
                .cuit(35661462)
                .sucursales(empresa1.getSucursales())
                .build();

        empresaRepository.genericUpdate(1L, empresaActualizada);
        Optional<Empresa> empresaVerificada = empresaRepository.findById(1L);
        empresaVerificada.ifPresent(e -> System.out.println("Empresa después de la actualización: " + e));


        empresaRepository.genericDelete(1L);
        Optional<Empresa> empresaEliminada = empresaRepository.findById(1L);
        if (empresaEliminada.isEmpty()) {
            System.out.println("La empresa con ID 1 ha sido eliminada.");
        }

        todasLasEmpresas.forEach(System.out::println);

    }
}