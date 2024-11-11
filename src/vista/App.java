package vista;

import entidad.Paciente;

public class App {

    public static void main(String[] args) {
        Paciente paciente = null;

        int opcion;

        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    //Se ingresan datos del paciente
                    paciente = crearPaciente();
                    break;
                case 2:
                    //Se muestran los datos
                    if(paciente == null){
                        System.out.println("No hay datos, por favor ingresarlos");
                        System.out.println();
                    }else {
                        mostrarInfoPaciente(paciente);
                    }
                    break;
                case 3:
                    //Calcular mes de menor peso
                    if(paciente == null){
                        System.out.println("No hay datos, por favor ingresarlos");
                    }else {
                        System.out.println("El mes de menor peso es: " + paciente.menorPesoMensual());
                    }

                    System.out.println();
                    break;
                case 4:
                    //Comparacion de X peso
                    if(paciente == null){
                        System.out.println("No hay datos, por favor ingresarlos");
                        System.out.println();
                    }else {
                        System.out.print("Ingresar Peso: ");
                        int xKilos = Leer.datoInt();

                        if(paciente.menosDeXKilos(xKilos) == null) {
                            System.out.println("No se encontraron pesos menores a " + xKilos);
                        }else {
                            int[] mesesMenorPeso = paciente.menosDeXKilos(xKilos);

                            System.out.println("Estos son los meses de menor peso a " + xKilos + " :");

                            for(int i=0; i<mesesMenorPeso.length;i++) {
                                System.out.println("Mes: " + mesesMenorPeso[i]);
                            }
                        }
                    }

                    System.out.println();
                    break;
                case 5:
                    //Calcular condicion de un mes
                    if(paciente == null){
                        System.out.println("No hay datos, por favor ingresarlos");
                        System.out.println();
                    }else {
                        System.out.print("Ingresar Mes: ");
                        int mesX = Leer.datoInt();

                        System.out.print("Ingresar Estatura: ");
                        double estPaciente = Leer.datoDouble();

                        double indice = paciente.indiceMasaCorporal(mesX,estPaciente);
                        System.out.println("El indice de masa corporal es: " + indice);
                        System.out.println("La condición del paciente es: " + paciente.pesoMesX(indice));
                    }

                    System.out.println();
                    break;
            }

        } while(opcion!=6);
    }

    public static int menu(){
        System.out.println("*** Sistema de Control de Peso ***");
        System.out.println("==================================");
        System.out.println("1.\tIngresar datos del paciente");
        System.out.println("2.\tMostrar datos del paciente");
        System.out.println("3.\tMostrar el mes con menor peso");
        System.out.println("4.\tIngresar peso de comparación por mes");
        System.out.println("5.\tMostrar condición de un mes");
        System.out.println("6.\tSalir");
        System.out.println("==================================");
        System.out.println("Favor ingrese una opción para continuar: ");
        return Leer.datoInt();
    }

    public static Paciente crearPaciente(){
        System.out.println("Por favor ingrese el dni");
        String dni = Leer.dato();
        System.out.println("Por favor ingrese el nombre");
        String nombre = Leer.dato();
        System.out.println("Por favor ingrese la edad");
        int edad = Leer.datoInt();
        System.out.println("Por favor ingrese el sexo");
        char sexo = Leer.datoChar();

        return new Paciente(dni,nombre,edad,sexo);
    }

    public static void mostrarInfoPaciente(Paciente paciente) {
        System.out.println("Datos de Paciente:");
        System.out.println("DNI: " + paciente.getDni());
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Edad: " + paciente.getEdad());
        System.out.println("Sexo: " + paciente.getSexo());

        for(int i=0; i<paciente.getPesoMensual().length;i++) {
            System.out.println("El Peso del mes: " + (i+1) + " es: " + paciente.getPesoMensual()[i] + " Kg");
        }

        System.out.println();
    }
}
