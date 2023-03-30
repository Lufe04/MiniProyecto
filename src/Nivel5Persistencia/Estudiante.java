package Nivel5Persistencia;

import Corte2Agenda.*;

public class Estudiante {//representar a un estudiante en el sistema. 
    //atributos
    private String codigo;
    private String nombre;
    private char genero;
    private int edad;
    private float [] notas;
    //metodos

    public Estudiante() {
        this.codigo = " ";
        this.nombre = " ";
        this.genero = '.';
        this.edad = 0;
        this.notas = new float [3];
    }

    public Estudiante(String codigo, String nombre, char genero, int edad, float[] notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.notas = notas;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public char getGenero() {
        return this.genero;
    }

    public int getEdad() {
        return this.edad;
    }

    public float[] getNotas() {
        return this.notas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }
    public String toString(){
        String lasNotas= "";
        for (int i = 0; i < 3; i++) {
            if (i!=2) {
                lasNotas+=this.notas[i]+",";
            }else{
                lasNotas+=this.notas[i];
            } 
        }
        return this.codigo+","+ this.nombre+","+this.genero+","+this.edad+","+lasNotas;
    }
}
