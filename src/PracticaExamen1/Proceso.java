package PracticaExamen1;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Proceso {
    private String[] prod;
    private float [] precio;
    private int [] cantidad;
    private int [] codigo;
    Scanner s = new Scanner(System.in);
    public Proceso(){
        this.cantidad=null;
        this.prod=null;
        this.precio=null;
        this.codigo=null;
        
    }
    public void setDatos(String [] prod, int [] codigo, float [] precio, int [] cantidad){
        this.cantidad=cantidad;
        this.prod=prod;
        this.codigo=codigo;
        this.precio=precio;
    }
   
    public void venta(){
        int k, b,c;
        int [] num={1,2,3,4,5,6,7,8,9,10};
        System.out.println("\tcodigo\tProducto\tCantidad\tprecio");
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1)+".\t"+this.codigo[i]+"\t"+this.prod[i]+"\t"+this.cantidad[i]+"\t"+this.precio[i]);
        }
        c=Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos productos va a veder?"));
        for (int i = 0; i < c; i++) {
            k=Integer.parseInt(JOptionPane.showInputDialog(null, "Elija el producto que va vender"));
            int y;
            b=Integer.parseInt(JOptionPane.showInputDialog(null, "El producto que ha elegido es: "+num[k-1]+"\t1. Correcto\n2. Incorrecto"));
            if(b==1){
                y=Integer.parseInt(JOptionPane.showInputDialog(null, "¿cuantos va a vender?"));
                this.cantidad[k-1]=this.cantidad[k-1]-y;
                if(this.cantidad[k-1]==0){
                   this.cantidad[k-1]=0;
                   this.precio[k-1]=0;
                   this.prod[k-1]="x";
                   this.codigo[k-1]=0;   
                }
            }
            if (b==2) {
                i--;
            }
        }    
    }
    public void mostrarInvetario(){
        System.out.println("\tcodigo\tProducto\tCantidad\tprecio");
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1)+".\t"+this.codigo[i]+"\t"+this.prod[i]+"\t"+this.cantidad[i]+"\t"+this.precio[i]);
        }
    }
    public void valorInventario(){
        double valor, acum=0;
        for (int i = 0; i < this.precio.length; i++) {
            acum=acum+this.precio[i];
        }
        valor=(acum)*(0.25);
        JOptionPane.showConfirmDialog(null, "El valor total del inventario es: \n"+valor);
    }
}
