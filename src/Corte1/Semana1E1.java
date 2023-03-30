//el cociente de dos numero
package Corte1;
import javax.swing.JOptionPane;

public class Semana1E1 {
    //variables de case: no hay porque solo hay variables locales
    public static void main(String[] args) {
        new Semana1E1(); //creación de objeto, no tiene nombre porque no lo tengo que llamar en nungun lado
    }
    
    public Semana1E1(){
        this.suma();//llama el metodo
    }
    private void suma(){ 
        float a,b,c;
        b = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato 1: "));
        c = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato 2: "));
        a = b+c;    
        JOptionPane.showMessageDialog(null, "El resultado es: "+a);
    }
}
