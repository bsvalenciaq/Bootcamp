import java.util.Scanner;

public class EnergiaSolar {

    public static void main(String[] args) {
        energiaSolarCiclo();
    }

    private static void energiaSolarCiclo() {
        var sc = new Scanner(System.in);
        String continuar;
        do {
            var datos = capturarDatos();
            calcularEnergiaYClasificar(datos[0], datos[1], datos[2]);
            System.out.print("¿Desea realizar otro cálculo? (si/no): ");
            continuar = sc.next().trim().toLowerCase();
        } while (continuar.equals("si"));

        System.out.println("¡Hasta pronto!");
    }

    public static double[] capturarDatos() {
        double n = 0, a = 0, g = 0;
        var scanner = new Scanner(System.in);
        System.out.println("Cálculo de Energía Solar");
        // Captura eficiencia n
        System.out.print("Ingrese la eficiencia del panel (entre 0.10 y 0.25): ");
        n = Double.parseDouble(scanner.next());
        if (n < 0.10 || n > 0.25) {
            System.out.println("Error: la eficiencia debe estar entre 0.10 y 0.25.");
            System.exit(0);
        }
        // Captura área a
        System.out.print("Ingrese el área instalada (m²): ");
        a = Double.parseDouble(scanner.next());
        if (a < 5 || a > 50) {
            System.out.println("Error: el área debe estar entre 5 y 50.");
            System.exit(0);
        }
        // Captura radiación g
        System.out.print("Ingrese la radiación solar diaria (KWh/m²/día): ");
        g = Double.parseDouble(scanner.next());
        if (g < 0) {
            System.out.println("Error: la radiación debe ser mayor que cero.");
            System.exit(0);
        }
        return new double[]{n, a, g};
    }

    public static void calcularEnergiaYClasificar(double eficiencia, double area, double radiacion) {
        var energia = eficiencia * area * radiacion;
        String clasificaicon;
        System.out.printf("Energía generada: %.2f KWh/día%n", energia);

        if (energia < 5) {
            clasificaicon = "Baja";
        } else if (energia <= 10) {
            clasificaicon = "Media";
        } else {
            clasificaicon = "Alta";
        }
        //Resultados
        System.out.println("\nResultados de tu instalacion:");
        System.out.println("\tArea total: : " + area + "m²");
        System.out.println("\tEficiencia del panel: " + eficiencia);
        System.out.println("\tRadiacion promedio diaria: " + radiacion + "kWh/m²");
        System.out.printf("\tEnergia generacion estimada: %.2f kWh/dia\n", energia);
        System.out.printf("\tClasificacion: %s\n\n", clasificaicon);
    }
}
