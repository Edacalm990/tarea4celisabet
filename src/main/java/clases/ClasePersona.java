/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class ClasePersona {
    private String nombre;
    private int edad;
    private String nif;
    private String sexo;
    private double peso;
    private double altura;
    
    Random random=new Random();

   
    public ClasePersona(String nombre, int edad, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.nif = generaNIF();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public ClasePersona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = filtrarSexo(sexo);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getNif() {
        return nif;
    }

    @Override
    public String toString() {
        return "ClasePersona{" + "nombre=" + nombre + ", edad=" + edad + ", nif=" + nif + ", sexo=" + sexo +
                ", peso=" + peso + ", altura=" + altura + ", random=" + random + '}';
    }
    
    private boolean filtrarSexo(char sexo) {
        boolean resultado= switch(sexo) {
            case 'H' -> true;
            case 'M' -> true;    
            default -> false;
        };
    return resultado;
    }
    
    private String generaNIF() {
    int numeros=random.nextInt(99999999)+00000001;
    int posicion= numeros%23;
    final String [] LETRAS = {"T","R","W","A","G", "M", "Y", "F", "P", "D", "X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
    String letra=LETRAS[posicion];
    return numeros+letra;
    }

    public boolean esMayorEdad(int edad) {
    return edad>=18;
    }
    
    public double calcularIMC(double peso, double altura){
     // IMC = Peso (kg) / altura (m)2
    return peso/(Math.pow(altura, 2));
    }
}
