package Program;

import java.util.ArrayList;
import java.util.Scanner;

public class Crud {

    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);

        boolean repetir = true;
        int contadorId = 0;
        ArrayList<POJO> jugador = new ArrayList<>();

        while (repetir) {
            System.out.println("-----Menu de opciones-----");
            System.out.println("1- Agregar jugador");
            System.out.println("2- Eliminar jugador");
            System.out.println("3- Buscar un jugador");
            System.out.println("4- Editar datos de un jugador");
            System.out.println("5- Listar jugadores");
            System.out.println("6- Salir del programa\n");

            System.out.print("Ingrese la opcion deseada: ");
            int opcion = entrada.nextInt();

            entrada.nextLine(); //Este fue utiliza como solución a un buffer de entrada que se genera con \n
            //Solución a este problema encontrada con chatgpt

            switch (opcion) {

                case 1 -> {
                    contadorId += 1;
                    System.out.println("\n----- CREAR UN JUGADOR -----");

                    System.out.println("-Ingrese nombre del jugador:");
                    String nombre = entrada.nextLine();

                    System.out.println("\n-Ingrese email del jugador:");
                    String email = entrada.nextLine();

                    System.out.println("\n-Ingrese sexo del jugador:");
                    String sexo = entrada.nextLine();

                    POJO j1 = new POJO(String.valueOf(contadorId), nombre, email, sexo);

                    System.out.println("\nJugador creado con exito...");
                    System.out.println("SU ID ES: " + contadorId + "\n");
                    jugador.add(j1);
                }

                case 2 -> {
                    System.out.println("\n----- ELIMINAR JUGADOR -----");
                    System.out.print("-Ingrese el ID: ");
                    String id = entrada.nextLine();
                    int encontrado = 0;

                    for (int i = 0; i < jugador.size(); i++) {
                        if (jugador.get(i).getId().equals(id)) {                                
                            encontrado = +1;
                            
                            System.out.print("\nESTA SEGURO DE ELIMINAR ESTE JUGADOR(Y/N): ");
                            String decision=entrada.nextLine();
                            
                            if ("y".equals(decision) || "Y".equals(decision)) {
                                jugador.remove(i);

                                
                                System.out.println("\n--- JUGADOR ELIMINADO CON EXITO ---\n");
                            }                           
                        }
                    }
                    if (encontrado == 0) {
                        System.out.println("\n---- JUGADOR NO SE ENCUENTRA EN LA LISTA ----\n");
                    }
                }

                case 3 -> {
                    System.out.println("\n----- BUSCAR UN JUGADOR -----");
                    System.out.print("-Ingrese el ID: ");
                    String id = entrada.nextLine();
                    int encontrado = 0;

                    for (int i = 0; i < jugador.size(); i++) {
                        if (jugador.get(i).getId().equals(id)) {
                            System.out.println("\nID: " + jugador.get(i).getId());
                            System.out.println("NOMBRE: " + jugador.get(i).getNombre());
                            System.out.println("EMAIL: " + jugador.get(i).getEmail());
                            System.out.println("SEXO: " + jugador.get(i).getSexo() + "\n");

                            encontrado = +1;
                        }
                    }

                    if (encontrado == 0) {
                        System.out.println("\n---- JUGADOR NO SE ENCUENTRA EN LA LISTA ----\n");
                    }
                }

                case 4 -> {
                    System.out.println("\n----- EDITAR JUGADOR -----");
                    System.out.print("-Ingrese el ID: ");
                    String id = entrada.nextLine();
                    int encontrado = 0;

                    for (int i = 0; i < jugador.size(); i++) {
                        if (jugador.get(i).getId().equals(id)) {                            
                            POJO editarJugador = jugador.get(i);
                            
                            System.out.println("\n*SI NO DESEA EDITAR ESE DATO SOLO OPRIMA ENTER*\n");
                            
                            System.out.print("NOMBRE: ");
                            String dato= entrada.nextLine();
                            if (dato.isEmpty()) {
                                
                            }
                            else{
                                editarJugador.setNombre(dato);
                            }
                            
                            
                            System.out.print("EMAIL: ");
                            dato= entrada.nextLine();
                            if (dato.isEmpty()) {
                                
                            }
                            else{
                                editarJugador.setEmail(dato);
                            }
                            
                            System.out.print("SEXO: ");
                            dato= entrada.nextLine();
                            if (dato.isEmpty()) {
                                
                            }
                            else{
                                editarJugador.setSexo(dato);
                            }
                            
                            System.out.println("\n--- JUGADOR EDITADO CON EXITO ----");
                            System.out.println("ID: "+jugador.get(i).getId());
                            System.out.println("NOMBRE: "+jugador.get(i).getNombre());
                            System.out.println("EMAIL: "+jugador.get(i).getEmail());
                            System.out.println("SEXO: "+jugador.get(i).getSexo()+"\n");
                            
                            encontrado = +1;
                        }
                    }

                    if (encontrado == 0) {
                        System.out.println("\n---- JUGADOR NO SE ENCUENTRA EN LA LISTA ----\n");
                    }
                
                }

                case 5 -> {

                    if (jugador.isEmpty()) {
                        System.out.println("\n---- No hay ningun jugador registrado. ----\n");
                    } else {
                        System.out.println("\n----- LISTA DE JUGADORES -----\n");
                        for (int i = 0; i < jugador.size(); i++) {
                            System.out.println("Jugador #" + (i + 1) + " " + jugador.get(i).getNombre() + "\n");
                        }
                    }
                }

                case 6 -> {
                    System.out.println("Estas fuera del menu");
                    repetir = false;
                }

                default ->
                    System.out.println("La opcion no es valida\n");
            }//Switch
        }//While
    }//Main
} //clase
