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
// clase para crear persona
public class ClasePersona {

     // las variables son privadas para que solo se puedan cambiar con el setter o pedir con el getter
    private String nombre;
    private int edad;
    final private String NIF = generaNIF(); // se genera un NIF aleatorio y se restringe con el final
    private char sexo;
    private double peso;
    private double altura;
    private float IMC;
    private String rangoIMC;

    // contructor con parametros
    public ClasePersona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = filtrarSexo(sexo) ? sexo : 'O'; // se comprueba la variable y se determina el valor
        this.peso = peso;
        this.altura = altura;
    }
    
    // constructor vacio
    public ClasePersona() {
    }

    // getter y setter sin el set de NIF 
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

    public float getIMC() {
        return IMC;
    }

    public String getRangoIMC() {
        return rangoIMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    public void setRangoIMC(String rangoIMC) {
        this.rangoIMC = rangoIMC;
    }

    
   
    // string por defecto
    @Override
    public String toString() {
        return "ClasePersona{" + "nombre=" + nombre + ", edad=" + edad + ", nif=" + NIF + ", sexo=" + sexo
                + ", peso=" + peso + ", altura=" + altura + '}';
    }
    
    // método para filtrar la variable sexo
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

    // se genera un NIF aleatorio con su letra
    private String generaNIF() {
        Random random = new Random();
        int numeros = random.nextInt(99999999) + 00000001;
        int posicion = numeros % 23;
        final String[] LETRAS = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        String letra = LETRAS[posicion];
        return numeros + letra;
    }
    
    // método publico que determina si es mayor o menor de edad
    public boolean esMayorEdad() {
        return this.edad >= 18;
    }

    // método público para calcular el IMC y almacenarla
    public float calcularIMC() {
        // IMC = Peso (kg) / altura (m)2
        this.IMC=(float) (this.peso / (Math.pow(this.altura, 2)));
        return IMC;
    }
    
    // método pública que llama a darLike de la clase serie y le añade un Like a la variable Like
    public void darLike(ClaseSerie serie) {
        serie.darLike();
    }
    
    // método público para determinar el estado del IMC
    public String rangoIMC() {
        String rangoIMC = "";
        if (this.IMC < 18.5) {
            rangoIMC = "Bajo de peso";
        } else if (this.IMC >= 18.5 && this.IMC < 25) {
            rangoIMC = "Peso Normal";
        } else if (this.IMC >= 25 && this.IMC < 30) {
            rangoIMC = "Sobrepeso";
        } else if (this.IMC >= 30) {
            rangoIMC = "Obesidad";
        }
        return rangoIMC;
    }
}
