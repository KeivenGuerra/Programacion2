/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package personaevaluar;
import java.util.Scanner;
/**
 *
 * @author Sala de Sistemas
 */
public class PersonaEvaluar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Ingrese su sexo (Masculino/Femenino): ");
        String sexo = scanner.nextLine();
        
        if (edad >= 18) {
            System.out.println(nombre + " " + apellido + " es mayor de edad.");
        } else {
            System.out.println(nombre + " " + apellido + " es menor de edad.");
        }
        
        if (sexo.equalsIgnoreCase("Masculino")) {
            System.out.println(nombre + " es un Hombre.");
        } else if (sexo.equalsIgnoreCase("Femenino")) {
            System.out.println(nombre + " es una Mujer.");
        } else {
            System.out.println("Sexo no reconocido.");
        }
       
        scanner.close();
    }
}
    
    

