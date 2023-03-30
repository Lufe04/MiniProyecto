package MiniProyecto;
public class Estudiante {
     //atributos
    private String codigo;
    private String nombre;
    private char genero;
    private int edad;
    //metodos

    public Estudiante() {
        this.codigo = " ";
        this.nombre = " ";
        this.genero = '.';
        this.edad = 0;
    }

    public Estudiante(String codigo, String nombre, char genero, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
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
    public String toString(){
        return this.codigo+","+ this.nombre+","+this.genero+","+this.edad;
    }
}


