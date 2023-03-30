
package MiniProyecto;

import java.util.ArrayList;

public class Asignatura {
    private String codigo;
    private String nombre;
    private String creditos;
    private ArrayList<String> inscrip;
    //metodos

    public Asignatura(String codigo, String nombre, String creditos){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos= creditos;
    }
    
    public void anadirInscripcion (String idest){
        this.inscrip.add(idest);
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public String getCreditos(){
        return this.creditos;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String toString(){
        return this.codigo+","+ this.nombre+","+this.creditos;
    }
}

