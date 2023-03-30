//automatizar el proceso para una maquina que toma tres numeros enteros diferentes
//en cualquier orden y, halla y muestra el mayor de ellos. Resolverlo con anidamiento
package RepasoPrimeraSemana;
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int max=0;
        int[] num = new int[3];
        for (int i=0;i<num.length;i++) {
            System.out.println("Elemento " + (i+1));
            num[i] = s.nextInt();            
            if(max<num[i]){
                max=num[i];
            }           
        }
        System.out.println("El numero máximo es: "+max);
    }
}
    