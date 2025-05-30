import java.util.Scanner;

public class RedComunitaria {
    public static void main(String[] args) {
        capturarDatos();

    }

    public static void capturarDatos() {
        var emprendedor = new Emprendedores();
        var proyecto = new Proyecto();

        var sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del emprendedor: ");
        emprendedor.setNombre(sc.nextLine());
        System.out.print("Ingrese el numero de documento del emprendedor: ");
        emprendedor.setDocumento(sc.nextLine());
        System.out.print("Ingrese el sector al que pertenece el emprendedor: ");
        emprendedor.setSector(sc.nextLine());
        System.out.print("Ingrese la ciudad del emprendedor: ");
        emprendedor.setCiudad(sc.nextLine());

        System.out.print("Ingrese nombre del proyecto: ");
        proyecto.setNombre(sc.nextLine());
        System.out.print("Ingrese la descripcion del proyecto: ");
        proyecto.setDescripcion(sc.nextLine());

        EstadoProyecto estadoProyecto = null;
        while (estadoProyecto == null) {
            try {
                System.out.print("Ingrese el estado del proyecto (EN_DISENIO, EN_MARCHA, CRECIMIENTO): ");
                estadoProyecto = EstadoProyecto.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Estado no valido. Intente de nuevo.");
            }
        }
        NIvelInnovacion nivelInnovacion = null;
        while (nivelInnovacion == null) {
            try {
                System.out.print("Ingrese el nivel de innovacion del proyecto (BAJO, MEDIO, ALTO): ");
                nivelInnovacion = NIvelInnovacion.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Nivel de innovacion no valido. Intente de nuevo.");
            }
        }

        proyecto.setNivelInnovacion(nivelInnovacion);
        proyecto.setEstado(estadoProyecto);

        proyecto.setEmprendedor(emprendedor);
        proyecto.mostrarResumen();

        proyecto.mostrarResumen();
        sc.close();

    }

}
