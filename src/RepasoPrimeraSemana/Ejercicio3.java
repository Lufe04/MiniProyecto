//hallar, decir cuantos y mostrar todos los numeros primos que haya en un intervalo a,b
package RepasoPrimeraSemana;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Ejercicio3 {
    public static void main(String[] args) {
        int a, b, p=0;  
        a = Integer.parseInt(JOptionPane.showInputDialog("Inserte el primer numero positivo del intervalo"));
        b = Integer.parseInt(JOptionPane.showInputDialog("Inserte el segundo numero positivo del intervalo"));  
        ArrayList<Integer> prim = new ArrayList<>();
        if (a>0 && b>a){
            for (int i = a; i <= b; i++) {
                int y=0;
                for (int j = 1; j <= i; j++) {
                    if(i%j == 0){ 
                        y++;
                    } 
                }
                if ( y == 2) {
                    p++;
                    prim.add(i);
                }
            } 
        }
        System.out.println("Los numero primos en el intervalo "+a+" - "+b+" son: ");
        for (int i = 0; i < p; i++) {
            System.out.println(prim.get(i));
        }
        System.out.println("La cantidad de numeros primos es: "+p);
    }
}
                        
               
               
                
            
        
    


