import java.util.Scanner;

public class RedComunitaria {
    public static void main(String[] args) {
        var emprendedor = new Emprendedores();
        var proyecto = new Proyecto();
        capturarDatos(emprendedor, proyecto);

    }

    public static void capturarDatos(Emprendedores emprendedor, Proyecto proyecto) {
        var sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del emprendedor: ");
        emprendedor.setNombre(sc.nextLine());
        System.out.println("Ingrese el numero de documento del emprendedor: ");
        emprendedor.setDocumento(sc.nextLine());
        System.out.println("Ingrese el id del proyecto: ");
        emprendedor.setProyecto(proyecto.setId(sc.nextInt());
        System.out.println("Ingrese el nombre del proyecto: ");
        emprendedor.proyecto.nombre = sc.nextLine();
        System.out.println("Ingrese la decripcion del proyecto");
        emprendedor.proyecto.descripcion = sc.nextLine();

    }

}
