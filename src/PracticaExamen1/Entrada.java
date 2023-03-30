
package PracticaExamen1;

import Nivel3.Entrada4;
import javax.swing.JOptionPane;

public class Entrada {
    public static void main(String[] args){
        new Entrada();
    }
    public Entrada(){
        this.menu();
    }
    public void menu(){
            int opcion;
            Tienda operador = new Tienda();
            do
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Comprar \n"+
                        "2. Venta \n"+
                        "3. Ver Inventario \n"+
                        "4. Precio inventario \n"+                        
                        "0. SALIR \n"));

                switch (opcion)
                {
                    case 1:
                        operador.compra();
                        break;
                    case 2:
                        operador.venta();
                        break;
                    case 3:
                        operador.verInventario();
                        break;
                    case 4:
                        
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Chao pescaoo..!!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ese caso NO existe..!!");
                        break;
                }
            }
            while(opcion!=0);
        }
}
