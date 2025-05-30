package org.energiaSolar;

import java.util.Scanner;

public class app {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Proyecto proyecto = null;
        CaracteristicasPanel caracteristicasPanel = null;
        Rol rol = null;

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar nuevo proyecto");
            System.out.println("2. Actualizar datos del proyecto");
            System.out.println("3. Mostrar resumen del proyecto");
            System.out.println("4. Calcular energía y clasificar instalacion");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    rol = capturarDatosBasicos(sc);
                    caracteristicasPanel = capturarDatosPanel(sc);
                    proyecto = capturarDatosProyecto(sc, caracteristicasPanel, rol);
                    System.out.println("Proyecto registrado exitosamente.");
                    break;

                case 2:
                    if (proyecto == null) {
                        System.out.println("No hay proyecto registrado para actualizar.");
                    } else {
                        actualizarDatosProyecto(sc, proyecto);
                    }
                    break;

                case 3:
                    if (proyecto == null) {
                        System.out.println("No hay proyecto registrado para mostrar.");
                    } else {
                        imprimirDatos(proyecto, caracteristicasPanel, rol);
                    }
                    break;

                case 4:
                    if (caracteristicasPanel == null) {
                        System.out.println("No hay datos del panel registrados para calcular energía.");
                    } else {
                        calcularEnergiaYClasificar(
                                Double.parseDouble(caracteristicasPanel.getEficiencia()),
                                Double.parseDouble(caracteristicasPanel.getArea()),
                                Double.parseDouble(caracteristicasPanel.getRadiacion())
                        );
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opcion no válida. Intente nuevamente.");
            }
        }
    }

    public static Rol capturarDatosBasicos(Scanner sc) {
        var rol = new Rol();
        System.out.println("\nIngrese los datos básicos de la persona");
        System.out.print("Ingrese el nombre: ");
        rol.nombre = (sc.nextLine());
        System.out.print("Ingrese el número de documento: ");
        rol.documento = (sc.nextLine());
        System.out.print("Ingrese la ciudad: ");
        rol.setCiudad(sc.nextLine());

        Roles roles = null;
        while (roles == null) {
            try {
                System.out.print("Ingrese el rol (INGENIEROS, INSTALADORES, MANTENIMIENTO): ");
                roles = Roles.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Rol no válido. Intente de nuevo.");
            }
        }
        rol.setRol(roles);
        return rol;
    }

    public static CaracteristicasPanel capturarDatosPanel(Scanner sc) {
        var caracteristicasPanel = new CaracteristicasPanel();
        System.out.println("\n--- Ingrese datos del panel solar ---");

        TipoPanel tipoPanel = null;
        while (tipoPanel == null) {
            try {
                System.out.print("Ingrese el tipo del panel (POLICRISTALINO, MONOCRISTALINO): ");
                tipoPanel = TipoPanel.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo del panel no valido.");
            }
        }

        System.out.print("Ingrese la ubicacion del panel solar: ");
        caracteristicasPanel.setUbicacion(sc.nextLine());

        double eficiencia = 0;
        while (eficiencia < 0.10 || eficiencia > 0.25) {
            try {
                System.out.print("Ingrese la eficiencia del panel (entre 0.10 y 0.25): ");
                eficiencia = Double.parseDouble(sc.nextLine());
                if (eficiencia < 0.10 || eficiencia > 0.25) {
                    System.out.println("Error: la eficiencia debe estar entre 0.10 y 0.25.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: la eficiencia debe ser un numero valido.");
            }
        }

        System.out.print("Ingrese la radiacion solar diaria (KWh/m²/día): ");
        double radiacion = Double.parseDouble(sc.nextLine());

        double area = 0;
        while (area < 5 || area > 50) {
            try {
                System.out.print("Ingrese el area instalada (m²): ");
                area = Double.parseDouble(sc.nextLine());
                if (area < 5 || area > 50) {
                    System.out.println("Error: el area debe estar entre 5 y 50.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: el área debe ser un numero valido.");
            }
        }

        caracteristicasPanel.setEficiencia(String.valueOf(eficiencia));
        caracteristicasPanel.setRadiacion(String.valueOf(radiacion));
        caracteristicasPanel.setArea(String.valueOf(area));
        caracteristicasPanel.setTipoPanel(tipoPanel);

        return caracteristicasPanel;
    }

    public static Proyecto capturarDatosProyecto(Scanner sc, CaracteristicasPanel caracteristicasPanel, Rol rol) {
        var proyecto = new Proyecto();
        System.out.println("\n--- Ingrese datos del proyecto ---");
        System.out.print("Ingrese el nombre del proyecto: ");
        proyecto.setNombre(sc.nextLine());
        System.out.print("Ingrese la descripcion del proyecto: ");
        proyecto.setDescripcion(sc.nextLine());

        EstadoProyecto estadoProyecto = null;
        while (estadoProyecto == null) {
            try {
                System.out.print("Ingrese el estado del proyecto (NUEVO, ACTIVO, FINALIZADO): ");
                estadoProyecto = EstadoProyecto.valueOf(sc.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Estado no válido. Intente de nuevo.");
            }
        }
        proyecto.setEstado(estadoProyecto);
        proyecto.setPersona(rol);
        proyecto.setCaracteristicasPanel(caracteristicasPanel);

        return proyecto;
    }

    public static void actualizarDatosProyecto(Scanner sc, Proyecto proyecto) {
        System.out.println("\n--- Actualizar datos del proyecto ---");
        System.out.println("1. Actualizar nombre");
        System.out.println("2. Actualizar descripcion");
        System.out.println("3. Actualizar estado");
        System.out.print("Seleccione una opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                proyecto.setNombre(sc.nextLine());
                System.out.println("Nombre actualizado exitosamente.");
                break;

            case 2:
                System.out.print("Ingrese la nueva descripcion: ");
                proyecto.setDescripcion(sc.nextLine());
                System.out.println("Descripcion actualizada exitosamente.");
                break;

            case 3:
                EstadoProyecto estadoProyecto = null;
                while (estadoProyecto == null) {
                    try {
                        System.out.print("Ingrese el nuevo estado del proyecto (NUEVO, ACTIVO, FINALIZADO): ");
                        estadoProyecto = EstadoProyecto.valueOf(sc.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Estado no válido. Intente de nuevo.");
                    }
                }
                proyecto.setEstado(estadoProyecto);
                System.out.println("Estado actualizado exitosamente.");
                break;

            default:
                System.out.println("Opcion no válida.");
        }
    }

    public static void calcularEnergiaYClasificar(double eficiencia, double area, double radiacion) {
        var energia = eficiencia * area * radiacion;
        String clasificacion;

        if (energia < 5) {
            clasificacion = "Baja";
        } else if (energia <= 10) {
            clasificacion = "Media";
        } else {
            clasificacion = "Alta";
        }

        System.out.println("\nResultados de tu instalacion:");
        System.out.println("\tArea total: " + area + " m²");
        System.out.println("\tEficiencia del panel: " + eficiencia);
        System.out.println("\tRadiacion promedio diaria: " + radiacion + " kWh/m²");
        System.out.printf("\tEnergía generada estimada: %.2f kWh/día\n", energia);
        System.out.printf("\tClasificacion: %s\n\n", clasificacion);
    }

    public static void imprimirDatos(Proyecto proyecto, CaracteristicasPanel caracteristicasPanel, Rol rol) {
        System.out.println("\n--- Datos del Proyecto ---");
        System.out.println("\tNombre: " + proyecto.getNombre());
        System.out.println("\tDescripcion: " + proyecto.getDescripcion());
        System.out.println("\tEstado: " + proyecto.getEstado().toString().toLowerCase());
        System.out.println("\tPersona: " + rol.getNombre());
        System.out.println("\tRol persona: " + rol.getRol().toString().toLowerCase());
        System.out.println("\tCaracteristicas del Panel:");
        System.out.println("\tUbicacion: " + caracteristicasPanel.getUbicacion());
        System.out.println("\tRadiacion: " + caracteristicasPanel.getRadiacion());
        System.out.println("\tEficiencia: " + caracteristicasPanel.getEficiencia());
        System.out.println("\tArea: " + caracteristicasPanel.getArea());
        System.out.println("\tTipo de Panel: " + caracteristicasPanel.getTipoPanel().toString().toLowerCase());
    }
}