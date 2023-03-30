//Se deben capturar n notas en un arreglo para sacar algunas estadisticas. nos podemos equivocar las veces que queramos 
//digitando una nota, si nos equivocamos el sistema nos emite un mensaje. Se debe mostrar el arreglo con las como fueron 
//capturadas y tambien ordenadas de menor a mayor.
package RepasoPrimeraSemana;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Ejercicio4 {
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
        int n, opc;
        double nota;
        System.out.println("Cuantas notas va a digitar?");  
        n=s.nextInt(); 
        ArrayList<Double> not = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Digite la nota "+(i+1));
            nota=s.nextDouble();
            if (nota>0 && nota<= 5) {
                System.out.println("La nota que acaba de digitar es: "+nota+"\nSi es incorrecto digite 1, si es correcto digite 2");
                opc = s.nextInt();
                if (opc == 1) {
                    System.out.println("Digite la nota nuevamente: ");
                    nota=s.nextDouble();    
                    not.add(nota);                   
                }
                else if( opc == 2){
                    not.add(nota);
                }
            }
            else{ 
                System.out.println("La nota que ha ingresado es invalida");
                i--;
            }            
        }
        System.out.println("\nLas notas ingresadas fueron:");
        for (int i = 0; i < n; i++) {
            System.out.println(not.get(i));
        }
        ArrayList<Integer> notorg = (ArrayList<Integer>) not.clone();
        Collections.sort(notorg);
        System.out.println("Las notas ordenadas de menor a mayor son: "+notorg);
    }
}      

