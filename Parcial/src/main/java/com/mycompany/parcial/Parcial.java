/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Parcial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar información al usuario
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Nombre del Cargo: ");
        String nombreCargo = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();

        System.out.print("Jefe Inmediato: ");
        scanner.nextLine(); // Consumir el salto de línea
        String jefeInmediato = scanner.nextLine();

        System.out.print("Años de Experiencia: ");
        int aniosExperiencia = scanner.nextInt();

        // Crear el objeto Empleado
        Empleado empleado = new Empleado(nombre, apellido, direccion, telefono, edad, email, nombreCargo, salario, jefeInmediato, aniosExperiencia);

        // Mostrar la información del empleado
        empleado.mostrarInformacion();

        // Cerrar el scanner
        scanner.close();
    }
  }
}
