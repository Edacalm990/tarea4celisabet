/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author elisabet
 */
public class Prueba {
    public static void main(String[] args) {
        // se crea un objeto ClasePersona llamado persona 1 haciendo uso del servicioPersona (pide los parametros por teclado)
        ClasePersona persona1=ServicioPersona.persona();
        // se crea un objeto ClasePersona llamado persona 2 vacio
        ClasePersona persona2=new ClasePersona();
        
        // mostramos el contenido del objeto
        System.out.println(persona1);
        System.out.println(persona2);
        
        // comprobamos si persona1 y persona2 son mayores de edad
        boolean persona1MayorEdad=persona1.esMayorEdad();
        boolean persona2MayorEdad=persona2.esMayorEdad();
        
        // lo mostramos accediendo a los datos a través de un get
        System.out.println("""
                           %s es mayor de Edad? %b
                           %s es mayor de Edad? %b
                           """.formatted(
                                   persona1.getNombre(), persona1MayorEdad, 
                                   persona2.getNombre(), persona2MayorEdad));
        
        // mostrar el IMC y en que rango se encuentra con el método get
        System.out.println("""
                           %s tiene un IMC de %f y tiene "%s"
                           %s tiene un IMC de %f y tiene "%s"
                           """.formatted(persona1.getNombre(), persona1.getIMC(), persona1.getRangoIMC(),
                                   persona2.getNombre(), persona2.getIMC(), persona2.getRangoIMC()));
        
        // creando una serie
        ClaseSerie simpson=new ClaseSerie("Los Simpson", "Comedia", "Familia americana", "FOX", 26, 1000);
        // mostrando la serie
        System.out.println(simpson);
        // persona1 usa el método darLike de la ClasePersona que a su vez llama al método darLike de la ClaseSerie
        persona1.darLike(simpson);
        // muestra la serie con el like añadido
        System.out.println(simpson);
        
    }
    
}
