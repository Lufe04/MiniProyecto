//se introduce un cono solido dentro un cilindro cuya base tiene el mismo diametro 
//de la base del cono y su misma altura. Automatice un proceso que calcule el volumen del espacio
//que queda libre dentro del cilindro. 
package RepasoPrimeraSemana;
import java.lang.Math;
import javax.swing.JOptionPane;

public class Ejercicio1 {
    public static void main(String[] args) {
        double h, r, vcil, vcono, vlibre;
        h = Double.parseDouble(JOptionPane.showInputDialog( "Ingrese la altura del cilindro"));
        r = Double.parseDouble(JOptionPane.showInputDialog( "Ingrese el radio del cilindro"));
        vcil = ((Math.PI)*(Math.pow(r, 2))*h);
        vcono = ((Math.PI)*(Math.pow(r, 2))*h)/3;
        vlibre = (vcil-vcono);
        System.out.println("El volumne libre que queda en el cilindo es de: "+vlibre);
    }
}
