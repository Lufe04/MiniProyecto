package Parcial1;

import PracticaExamen1.Tienda;
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
            Proceso pocha = new Proceso();
            do
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Hacer reserva \n"+
                        "2. Hacer compra \n"+
                        "3. Cancelar reserva \n"+
                        "4. Ver estado \n"+                        
                        "0. SALIR \n"));

                switch (opcion)
                {
                    case 1:
                        pocha.reserva();
                        break;
                    case 2:
                        pocha.compra();
                        break;
                    case 3:
                        pocha.cancelarReserva();
                        break;
                    case 4:
                        pocha.verEstado();
                        break;
                    case 0:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione un opcion validaA");
                        break;
                }
            }
            while(opcion!=0);
        }

}
