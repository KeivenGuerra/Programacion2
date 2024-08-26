/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.menu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Biblioteca
 */
public class Menu {

    private static ArrayList<String> personas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Crear persona");
        System.out.println("2. Eliminar persona");
        System.out.println("3. Listar personas");
        System.out.println("4. Buscar persona");
        System.out.println("5. Salir");
        
        System.out.print("Seleccione una opción (1-5): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  

        switch (opcion) {
            case 1:
                crearPersona();
                break;
            case 2:
                eliminarPersona();
                break;
            case 3:
                listarPersonas();
                break;
            case 4:
                buscarPersona();
                break;
            case 5:
                System.out.println("Saliendo del programa.");
                return;  
            default:
                System.out.println("Opción no válida. Por favor, elija una opción del 1 al 5.");
                mostrarMenu();  
        }
    }

    private static void crearPersona() {
        System.out.print("Ingrese el nombre de la persona a agregar: ");
        String nombre = scanner.nextLine();
        personas.add(nombre);
        System.out.println("Lista actual de personas: " + personas);
        mostrarMenu();  
    }

    private static void eliminarPersona() {
        if (personas.isEmpty()) {
            System.out.println("La lista está vacía. No hay personas para eliminar.");
            mostrarMenu();  
            return;
        }

        System.out.println("Lista actual de personas: " + personas);
        System.out.print("Ingrese el índice de la persona a eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); 

        if (indice >= 0 && indice < personas.size()) {
            String eliminado = personas.remove(indice);
            System.out.println("Persona '" + eliminado + "' eliminada.");
        } else {
            System.out.println("Índice no válido.");
        }
        mostrarMenu();  
    }

    private static void listarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Lista actual de personas: " + personas);
        }
    }

    private static void buscarPersona() {
        if (personas.isEmpty()) {
            System.out.println("La lista está vacía.");
            mostrarMenu();  
            return;
        }

        System.out.print("Ingrese el nombre de la persona a buscar: ");
        String buscarNombre = scanner.nextLine();

        if (personas.contains(buscarNombre)) {
            System.out.println("La persona '" + buscarNombre + "' fue encontrada.");
        } else {
            System.out.println("La persona '" + buscarNombre + "' no fue encontrada.");
        }
        mostrarMenu();  
    }
}