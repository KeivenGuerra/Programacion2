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
        scanner.nextLine(); 

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Nombre del Cargo: ");
        String nombreCargo = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();

        System.out.print("Jefe Inmediato: ");
        scanner.nextLine(); 
        String jefeInmediato = scanner.nextLine();

        System.out.print("Años de Experiencia: ");
        int aniosExperiencia = scanner.nextInt();

      
        Empleado empleado = new Empleado(nombre, apellido, direccion, telefono, edad, email, nombreCargo, salario, jefeInmediato, aniosExperiencia);

        
        empleado.mostrarInformacion();

       
        scanner.close();
    }
  }
}
