/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
// clase ServicioPersona que será la encargada de pedir los datos por Scanner y crear el objeto ClasePersona
public class ServicioPersona {
    
    public static Scanner teclado = new Scanner(System.in);
    
    public static ClasePersona persona() {

        ClasePersona persona = new ClasePersona();
        
        // realiza todos los sets llamando al método correspondiente
        persona.setNombre(pedirNombre());
        persona.setSexo(pedirSexo());
        persona.setEdad(pedirEdad());
        persona.setPeso(pedirPeso());
        persona.setAltura(pedirAltura());
        // en este caso no hay que llamar a ningún método se la clase Serivicio sino a un método de la propia clase
        persona.setIMC(persona.calcularIMC());
        persona.setRangoIMC(persona.rangoIMC());
        // devuelve el objeto persona
        return persona;
    }

    // pide el nombre
    private static String pedirNombre() {
        System.out.println("¿Como te llamas?");
        return teclado.nextLine();
    }

    // pide un sexo y selecciona el primer carcater y lo transforma en un char ya que no hay un next especifico para char
    private static char pedirSexo() {
        System.out.println("¿Cual es tu sexo?");
        return teclado.next().toUpperCase().charAt(0);
    }

    // se pide la edad y solo se pasa el parámetro si se ajusta a algo real
    private static int pedirEdad() {
        int edad = -1;
        do {
            System.out.println("¿Cual es tu edad?");
            try {
                edad = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("""
                                   %s: El dato introducido no es correcto debe ser un número entero entre 0 y 130
                                   """.formatted(e));
                teclado.nextLine();
            }
            if (edad < 0 || edad > 130) {
                System.out.println("La edad debe estar comprendida entre 0 y 130");
            }
        } while (edad < 0 || edad > 130);
        return edad;
    }
    
    // se pide eld y solo se pasa el parámetro si se ajusta a algo real
    private static double pedirPeso() {
        double peso = 0;
        do {
            System.out.println("¿Cual es tu peso?");
            try {
                peso = teclado.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("""
                                   %s: El dato introducido no es correcto.
                                   """.formatted(e));
            }
            if (peso < 0 || peso > 300) {
                System.out.println("El peso debe estar comprendido entre 0 y 300 kg");
            }
        } while (peso < 0 || peso > 300);
        return peso;
    }

    // se pide la altura y solo se pasa el parámetro si se ajusta a algo real
    private static double pedirAltura() {
        double altura = 0;
        do {
            System.out.println("Cual es tu altura en metros");
            try {
                altura = teclado.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("""
                                   %s: El dato introducido no es correcto debe ser un número entre 0.3 y 2.5
                                   """.formatted(e));
                teclado.nextLine();
            }
            if (altura < 0.3 || altura > 2.5) {
                System.out.println("La altura debe estar comprendida entre 0.3 - 2.5");
            }
        } while (altura < 0.3 || altura > 2.5);
        return altura;
    }

}
