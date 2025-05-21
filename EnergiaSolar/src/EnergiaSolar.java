import java.util.Scanner;

public class EnergiaSolar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            double[] datos = capturarDatos(scanner);
            if (datos != null) {
                calcularEnergiaYClasificar(datos[0], datos[1], datos[2]);
            }

            System.out.print("¿Desea realizar otro cálculo? (si/no): ");
            continuar = scanner.next().trim().toLowerCase();
        } while (continuar.equals("si"));

        System.out.println("Gracias por usar el sistema de energía solar. ¡Hasta pronto!");
    }

    public static double[] capturarDatos(Scanner scanner) {
        double n = 0, a = 0, g = 0;

        System.out.println("\n=== Nuevo cálculo de Energía Solar ===");

        // Captura eficiencia n
        while (true) {
            try {
                System.out.print("Ingrese la eficiencia del panel (entre 0.10 y 0.25): ");
                n = Double.parseDouble(scanner.next());
                if (n >= 0.10 && n <= 0.25) break;
                System.out.println("Error: la eficiencia debe estar entre 0.10 y 0.25.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número decimal.");
            }
        }

        // Captura área a
        while (true) {
            try {
                System.out.print("Ingrese el área instalada (m²): ");
                a = Double.parseDouble(scanner.next());
                if (a > 0) break;
                System.out.println("Error: el área debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
            }
        }

        // Captura radiación g
        while (true) {
            try {
                System.out.print("Ingrese la radiación solar diaria (KWh/m²/día): ");
                g = Double.parseDouble(scanner.next());
                if (g > 0) break;
                System.out.println("Error: la radiación debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
            }
        }

        return new double[]{n, a, g};
    }

    public static void calcularEnergiaYClasificar(double n, double a, double g) {
        double energia = n * a * g;

        System.out.printf("Energía generada: %.2f KWh/día%n", energia);
        System.out.print("Clasificación: ");

        if (energia < 5) {
            System.out.println("Baja");
        } else if (energia <= 10) {
            System.out.println("Media");
        } else {
            System.out.println("Alta");
        }
    }
}
