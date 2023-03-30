//Una maquina toma un numero, si es primo, calculo y muestra su factorial; si no es primo, pero es par muestra la suma
//de sus divisores impares y si no es primo, pero es impar, muestra la suma de ese numero
//de terminos de la sucesión de fibonacci.
package RepasoPrimeraSemana;
import javax.swing.JOptionPane;
public class Ejercicio5 {
     public static void main(String[] args) {
        int h, fact=1;
        boolean esPrimo = true;
        h = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero"));
        for (int i = 2; i < h; i++) {
            if(h%i == 0){
               esPrimo = false;         
            }
        }
        if (esPrimo == true) {              
            for (int i = 1; i <= h; i++) {
                fact = fact*i;
            }
            System.out.println("El factorial del número es: "+fact);
        }
        if (esPrimo == false) {
            int cont = 0;
            if (h%2 == 0) {//si no es primo, pero es par muestra la suma de sus divisores impares
                for (int i = 1; i <= h; i++) {
                    if (h%i == 0 && i%2 != 0) {
                        cont=cont+i; 
                    }
                } 
                System.out.println("La suma de los divisores impares que digito es: "+cont);
            }
            if(h%2 != 0){ //si no es primo, pero es impar, muestra la suma de ese numero de terminos de la sucesión de fibonacci.   
                int a=0, b=1, cont2=0,d=0;
                for (int j = 1; j <= h; j++) {
                    cont2=cont2+b;
                    d = a+ b;
                    a = b;
                    b = d;
                }
                System.out.println("La suma de los numeros fibonacci hasta la posición "+h+" son: "+cont2);
            }                 
        }
    }
}

