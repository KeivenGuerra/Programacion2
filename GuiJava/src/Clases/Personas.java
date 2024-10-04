/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class Personas {
      private String nombre;
    private String apellido;
    private String direccion;
    private int edad;

   
    public Personas(String nombre, String apellido, String direccion, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public List<String> almacenarDatos() {
        List<String> listaDatos = new ArrayList<>();
        listaDatos.add("Nombre: " + this.nombre);
        listaDatos.add("Apellido: " + this.apellido);
        listaDatos.add("Dirección: " + this.direccion);
        listaDatos.add("Edad: " + this.edad);
        return listaDatos;
    }
}
    

