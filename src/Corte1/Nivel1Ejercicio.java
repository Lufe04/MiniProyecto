//captura n datos y muestra; los datos, los datos ordenados, el mayor, el menor, el promedio,
//la desviación estandar, los x mayore y x menores
package Corte1;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
public class Nivel1Ejercicio {
    public static void main(String[] args) {
        new Nivel1Ejercicio();
    }
    public Nivel1Ejercicio(){
        this.proceso();
    }
    private void proceso(){
        float num, a, prom=0, suma=0, menor=0,mayor=0, k;
        double rango, varianza=0.0, desviacion;
        ArrayList <Float> dato = new ArrayList<>();
        num = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad de datos que va a insertar"));
        for (int i = 0; i < num; i++) {
            a = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato "+(i+1)));
            dato.add(a);            
        }
        System.out.println("Los datos que ha ingresado son: ");
        for (int i = 0; i < dato.toArray().length; i++) {
            System.out.println(dato.get(i));
        }
        Collections.sort(dato);
        System.out.println("Los datos ingresados ordenados de menor a mayor son: "+dato);
        for (int i = 0; i < dato.toArray().length; i++) {
            if(dato.get(i) > mayor){
                mayor = dato.get(i);
            }
            menor = dato.get(0);
        }
        System.out.println("El numero menor es: "+menor+"\tEl numero mayor es: "+mayor);
        for (int i = 0; i < dato.toArray().length; i++) {
            suma = suma + dato.get(i);
            prom = suma / dato.toArray().length;
        }
        System.out.println("El promedio de los datos que acaba de ingresar es: "+prom);
        for (int i = 0; i <dato.toArray().length; i++) {
            rango=Math.pow(dato.get(i)-prom, 2);
            varianza=varianza+rango;            
        }
        varianza = varianza/(num-1);
        desviacion = Math.sqrt(varianza);
        double red = Math.rint(desviacion*100)/100;
        System.out.println("La desviación es: "+red); 
        ArrayList <Float> p = new ArrayList <>();
        ArrayList <Float> m = new ArrayList <>(); 
        for (int i = 0; i < dato.toArray().length; i++) {
            if (dato.get(i)<prom){
                p.add(dato.get(i));
            }
        }
        for (int i = 0; i < dato.toArray().length; i++) {
            if (dato.get(i)>prom) {
                m.add(dato.get(i));
            }
        }
        System.out.println("Los peores datos del conjunto de datos ingresados es: ");
        for (int i = 0; i < p.toArray().length; i++) {
            System.out.println(p.get(i));
        }
        System.out.println("Los mejores datos del conjunto de datos ingresados es: ");
        for (int i = 0; i < m.toArray().length; i++) {
            System.out.println(m.get(i));
        }
    }
}


