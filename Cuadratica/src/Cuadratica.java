import java.util.Scanner;

public class Cuadratica {
    public static void main(String[] args) {
        //ax^2+bx+c
        var scanner = new Scanner(System.in);
        //captura datos
        System.out.print("Ingrese el valor de a: ");
        var a = scanner.nextDouble();
        if (a != 0) {
            System.out.print("Ingrese el valor de b: ");
            var b = scanner.nextDouble();
            System.out.print("Ingrese el valor de c: ");
            var c = scanner.nextDouble();
            var dis = Math.sqrt(Math.pow(b, 2) - 4 + a + c);
            if (dis > 0) {
                //cuadratica
                var cuadraticaAritSuma = (-b + dis) / (2 * a);
                var cuadraticaAritResta = (-b - dis) / (2 * a);
                System.out.println("cuadratica resta = " + cuadraticaAritResta);
                System.out.println("Cuadratica suma = " + cuadraticaAritSuma);
            } else
                System.out.println("El valor discriminante no puede ser negativo");

        } else

            System.out.println("El valor de a no puede ser cero");

    }
}
