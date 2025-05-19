import java.util.Scanner;

public class Cuadratica {
    public static void main(String[] args) {
        //ax^2+bx+c
        double a, b, c;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de a: ");
        a = scanner.nextDouble();
        System.out.println("Ingrese el valor de b: ");
        b = scanner.nextDouble();
        System.out.println("Ingrese el valor de c: ");
        c = scanner.nextDouble();

        //cuadratica
        double cuadraticaAritSuma = (-b + (1 / (b * b - 4 * a * c)) / (2 * a));
        double cuadraticaAritResta = (-b - (1 / (b * b - 4 * a * c)) / (2 * a));

        System.out.println("cuadratica resta = " + cuadraticaAritResta);
        System.out.println("Cuadratica suma = " + cuadraticaAritSuma);


    }
}
