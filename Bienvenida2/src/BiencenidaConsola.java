import java.util.Scanner;

public class BiencenidaConsola {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el nombre: ");
        var nombre = entrada.nextLine();
        ;
        System.out.println("Introduzca el Codigo = ");
        var codigo = entrada.nextLine();
        System.out.println("Bienvenido al sistema " + nombre + " Codigo [" + codigo + "]");

    }
}
