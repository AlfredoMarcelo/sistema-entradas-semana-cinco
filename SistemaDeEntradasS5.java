package sistemadeentradass5;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeEntradasS5 {

    //variables de clase
    static int entradasVendidas = 0;
    static int ventaTotal = 0;
    static int entradasDisponibles = 0;

    public static void main(String[] args) {
        // Variables Locales
        ArrayList<String> entradasVip = new ArrayList<>();
        ArrayList<String> entradasPlatea = new ArrayList<>();
        ArrayList<String> entradasGeneral = new ArrayList<>();
        Boolean salirDeSistema = false;

        // Menu principal
        while (!salirDeSistema) {

            System.out.println("\nBienvenido a Teatro Moro, ingesa el número de la opción que quieras realizar\n"
                    + "1 => Vender Entrada\n"
                    + "2 => Ver Promociones\n"
                    + "3 => Salir");
            Scanner scannerString = new Scanner(System.in);
            String opcionSeleccionada = scannerString.nextLine();
            switch (opcionSeleccionada) {
                case "1":
                    System.out.println("haz  seleccionado comprar entrada");
                    entradasVip = venderEntrada(scannerString);
                    break;
                case "2":
                    mostrarPromociones(scannerString);
                    break;
                case "3":
                    salirDeSistema = true;
                    System.out.println("\nHasta luego....");
                    break;
                default:
                    System.out.println("Debes ingresar un número de opción disponible en el menú");
                    throw new AssertionError();
            }
        }

    }

    // Submenu mostrar promociones disponibles
    static void mostrarPromociones(Scanner scannerString) {
        Boolean salirDeSubMenu = false;
        while (!salirDeSubMenu) {
            System.out.println("\nEstas son las promociones disponibles\n"
                    + "1 => Por la compra de 2 entradas, pagas la segunda con un 10% de descuento(valido solo en VIP)\n"
                    + "2 => Por la compra de 3 entradas, paga solo 2\n"
                    + "3 => Por la compra de 4 entradas, pagas solo 3\n"
                    + "4 => Descuento especial de 10% a estudiante y 15% a tercera edad\n"
                    + "\nIngresa 0 para volver al menú principal");

            //Selección y validación para salir de submenu
            String opcionSeleccionada = scannerString.nextLine();
            if (opcionSeleccionada.equals("0")) {
                salirDeSubMenu = true;
            } else {
                System.out.println("opción incorrecta :(\n");
            }
        }
    }

    public static ArrayList<String> venderEntrada(Scanner scannerString) {
        Boolean salirDeSubMenu = false;
        ArrayList<String> entradasVip = new ArrayList<>();
        Entrada entrada = new Entrada();
        Double valorEntradaGeneral = 5000.0;
        Double valorEntradaPlatea = 10000.0;
        Double valorEntradaVip = 15000.0;

        while (!salirDeSubMenu) {
            System.out.println("\nA continuación se muestran los valores de entrada por ubicacion\n"
                        + "General => $5.000\n"
                        + "Platea  => $10.000\n"
                        + "Vip     => $15.000\n");
            Boolean ubicacionFueSeleccionada = false;
            while (!ubicacionFueSeleccionada) {
                System.out.println("\nSelecciona una ubicación\n"
                        + "1 => General\n"
                        + "2 => Platea\n"
                        + "3 => Vip\n"
                        + "\nIngresa el número de la ubicación en que se desea comprar la entrada:");

                // Selección de ubicación
                String ubicacionSeleccionada = scannerString.nextLine();
                switch (ubicacionSeleccionada) {
                    case "1":
                        entrada.setUbicacion("general");
                        ubicacionFueSeleccionada = true;
                        break;
                    case "2":
                        entrada.setUbicacion("platea");
                        ubicacionFueSeleccionada = true;
                        break;
                    case "3":
                        entrada.setUbicacion("vip");
                        ubicacionFueSeleccionada = true;
                        break;
                    default:
                        System.out.println("ingresa el número de una ubicación disponible");
                        throw new AssertionError();
                }
            }

            //Selección de numero asiento
            System.out.println("Selecciona un número de asiento del 1 al 20");
            String numeroAsientoSeleccionado = scannerString.nextLine();
            entrada.setNumeroAsiento(numeroAsientoSeleccionado);

            // Calculo de precio final
            Boolean precioFueCalculado = false;
            while (!precioFueCalculado) {
                System.out.println("Ingresa:\n"
                        + "1 => si es Estudiante\n"
                        + "2 => si es de Tercera Edad(mayor a 60 años)\n"
                        + "3 => No es estudiantes ni de Tercera Edad");
                String tipoDeComprador = scannerString.nextLine();
                switch (tipoDeComprador) {
                    case "1":
                        System.out.println("Obtienes un 10% de descuento por ser estudiante :)\n");
                        if (entrada.getUbicacion().equals("general")) {
                            entrada.setPrecio(valorEntradaGeneral * 0.90);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        if (entrada.getUbicacion().equals("platea")) {
                            entrada.setPrecio(valorEntradaPlatea * 0.90);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        if (entrada.getUbicacion().equals("vip")) {
                            entrada.setPrecio(valorEntradaVip * 0.90);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        break;
                    case "2":
                        System.out.println("Obtienes un 15% de descuento por ser estudiante :)\n");
                        if (entrada.getUbicacion().equals("general")) {
                            entrada.setPrecio(valorEntradaGeneral * 0.85);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        if (entrada.getUbicacion().equals("platea")) {
                            entrada.setPrecio(valorEntradaPlatea * 0.85);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        if (entrada.getUbicacion().equals("vip")) {
                            entrada.setPrecio(valorEntradaVip * 0.85);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        break;
                    case "3":
                        if (entrada.getUbicacion().equals("general")) {
                            entrada.setPrecio(valorEntradaGeneral);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        if (entrada.getUbicacion().equals("platea")) {
                            entrada.setPrecio(valorEntradaPlatea);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        if (entrada.getUbicacion().equals("vip")) {
                            entrada.setPrecio(valorEntradaVip);
                            precioFueCalculado = !precioFueCalculado;
                        }
                        break;
                    default:
                        System.out.println("ingresa un tipo de consumidor disponible");
                        throw new AssertionError();
                }
            }
            
            //Resumen de compra
            System.out.println("Resumen de la compra de entrada:\n"
                    + "Ubicación: " + entrada.getUbicacion()
                    + "\nNúmero asiento: " + entrada.getNumeroAsiento()
                    + "\nPrecio final: " + entrada.getPrecio());
            
            //Selección y validación para salir de submenu
            System.out.println("Ingresa 0 si deseas volver al menu");
            String opcionSeleccionada = scannerString.nextLine();
            if (opcionSeleccionada.equals("0")) {
                salirDeSubMenu = true;
            } else {
                System.out.println("opción incorrecta :(\n");
            }
        }
        return entradasVip;
    }
}
