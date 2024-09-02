/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial;

/**
 *
 * @author Usuario
 */
public class Empleado extends Persona {
    private String nombreCargo;      
    private double salario;          
    private String jefeInmediato;    
    private int aniosExperiencia;     
    private String cargo;            

    public Empleado(String nombre, String apellido, String direccion, String telefono, int edad, String email, 
                    String nombreCargo, double salario, String jefeInmediato, int aniosExperiencia) {
        super(nombre, apellido, direccion, telefono, edad, email);
        this.nombreCargo = nombreCargo;
        this.salario = salario;
        this.jefeInmediato = jefeInmediato;
        this.aniosExperiencia = aniosExperiencia;
        this.cargo = calcularCargo(); // Calcular el cargo al crear el objeto
    }

   
    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
        this.cargo = calcularCargo(); 
    }

    public String getJefeInmediato() {
        return jefeInmediato;
    }

    public void setJefeInmediato(String jefeInmediato) {
        this.jefeInmediato = jefeInmediato;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
        this.cargo = calcularCargo(); // Recalcular el cargo si los años de experiencia cambian
    }

   
    private String calcularCargo() {
        int edad = getEdad(); 

        if (salario >= 5000000 && aniosExperiencia >= 5 && edad >= 25 && edad <= 45) {
            return "Senior";
        } else if (salario >= 900000 && salario <= 1200000 && aniosExperiencia >= 1 && aniosExperiencia <= 2 && edad >= 18 && edad <= 22) {
            return "Junior";
        } else {
            return "No determinado";
        }
    }

    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); 
        System.out.println("Nombre del Cargo: " + nombreCargo);
        System.out.println("Salario: $" + salario);
        System.out.println("Jefe Inmediato: " + jefeInmediato);
        System.out.println("Años de Experiencia: " + aniosExperiencia);
        System.out.println("Cargo Calculado: " + cargo); 
    }
}
