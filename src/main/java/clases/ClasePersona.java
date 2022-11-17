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
    final private String NIF = generaNIF(); // para que no se pueda modificar se pone un final
    private char sexo;
    private double peso;
    private double altura;
    private float IMC;
    private String rangoIMC;

    public ClasePersona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = filtrarSexo(sexo) ? sexo : 'O';
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = (filtrarSexo(sexo) ? sexo : 'O');
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

    public String getNif() {
        return NIF;
    }

    public String getNIF() {
        return NIF;
    }
   

    @Override
    public String toString() {
        return "ClasePersona{" + "nombre=" + nombre + ", edad=" + edad + ", nif=" + NIF + ", sexo=" + sexo
                + ", peso=" + peso + ", altura=" + altura + '}';
    }

    private boolean filtrarSexo(char sexo) {
        boolean resultado = switch (sexo) {
            case 'H' ->
                true;
            case 'M' ->
                true;
            default ->
                false;
        };
        return resultado;
    }

    private String generaNIF() {
        Random random = new Random();
        int numeros = random.nextInt(99999999) + 00000001;
        int posicion = numeros % 23;
        final String[] LETRAS = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        String letra = LETRAS[posicion];
        return numeros + letra;
    }

    public boolean esMayorEdad() {
        return this.edad >= 18;
    }

    public float calcularIMC() {
        // IMC = Peso (kg) / altura (m)2
        this.IMC=(float) (this.peso / (Math.pow(this.altura, 2)));
        return IMC;
    }

    public void darLike(ClaseSerie serie) {
        serie.darLike();
    }

    public String rangoIMC() {
        String rangoIMC = "";
        if (this.IMC < 18.5) {
            rangoIMC = "Bajo de peso";
        } else if (this.IMC >= 18.5 && this.IMC < 25) {
            rangoIMC = "Peso Noramal";
        } else if (this.IMC >= 25 && this.IMC < 30) {
            rangoIMC = "Sobrepeso";
        } else if (this.IMC >= 30) {
            rangoIMC = "Obesidad";
        }
        return rangoIMC;
    }
}
