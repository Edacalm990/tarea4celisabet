/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
/*Clase ServicioPersona, que tiene un método para solicitar los datos de una persona por teclado y crear
un objeto Persona, usando el constructor parametrizado.
    private String nombre;
    private int edad;
    private String nif;
    private String sexo;
    private double peso;
    private double altura;*/
public class ServicioPersona {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre;
        int edad = 0;
        String nif;
        char sexo='X';
        double peso=0.0;
        double altura;
        boolean datoCorrecto=false;

        ClasePersona persona = new ClasePersona();
        
        System.out.println("¿Como te llamas?");
        nombre = teclado.nextLine();
        persona.setNombre(nombre);

        do {
            System.out.println("¿Cual es tu edad?");
            try {
                edad = teclado.nextInt();
                persona.getEdad();
            } catch (NumberFormatException e) {
                System.out.println("""
                                   %s: El dato introducido no es correcto debe ser un número entero entre 0 y 130
                                   """.formatted(e));
            }
        } while (edad < 0 || edad > 130);

        do {
            System.out.println("¿Cual es tu sexo?");
            try {
                sexo=teclado.next().charAt(0);
                datoCorrecto=true;
                persona.setSexo(sexo);
            } catch (Exception e) {
                System.out.println("""
                                   %s: El dato introducido no es correcto debe ser un caracter 
                                   """.formatted(e));
            }
        } while (!datoCorrecto);
        
        do {
            System.out.println("¿Cual es tu peso?");
            try {
                peso=teclado.nextDouble();
                persona.setPeso(peso);
            } catch (Exception e) {
                System.out.println("""
                                   %s: El dato introducido no es correcto debe ser un número entre 0 y 300
                                   """.formatted(e));
            }
        } while (peso<0 || peso>300);
        

    }

}
