//menu(compra, venta, inventarip, valor del inventario (con el 25% de ganancia por producto), precio de compra, existencias
package PracticaExamen1;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class menu {
    private Proceso pocha;
    Scanner s = new Scanner(System.in);
    public static void main (String[]args){
        new menu();
    }
    public menu(){
        this.pocha=null;
        this.menu();
    }
    private void menu(){
        boolean insdat=false;
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "///OPCIONES///\n1. Compra\n2. Venta\n3. Valor del inventario\n4. SALIR"));
            switch(opc){
                case 1:
                    insdat=true;
                    this.insertarDatos();
                    break;
                case 2:
                    if(insdat){
                        this.pocha.venta();
                    }
                    else{
                        JOptionPane.showConfirmDialog(null, "No hay inventario");
                    }  
                    break;
                case 3:
                    if(insdat){
                        this.pocha.mostrarInvetario();
                        this.pocha.valorInventario();
                    }
                    else{
                        JOptionPane.showConfirmDialog(null, "No hay inventario");
                    }
                    break;
                case 0:
                    JOptionPane.showConfirmDialog(null, "No hay inventario");
                    break;
            }
        
        }
        while(opc != 0);
    }
     public void insertarDatos(){
        String [] prod;
        float [] precio;
        int [] cantidad;
        int [] codigo;
        int m,s=0,opc=0, h, cont=0;
        codigo=new int [10];
        precio=new float[10];
        cantidad=new int[10];
        prod=new String [10];
        m=Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos productos va a ingresar al inventario?"));
         for (int i = 0; i < m; i++) {
            prod[i]=(JOptionPane.showInputDialog(null, "Inserte el nombre del producto "+(i+1)+" a ingresar")); 
            codigo[i]= (int)(Math.random()*4000+100);
            precio[i]=Float.parseFloat(JOptionPane.showInputDialog(null, "Inserte el precio del producto a ingresar"));
            cantidad[i]=Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte la cantidad de productos de "+prod[i]+" comprados"));
            cont++;
            JOptionPane.showConfirmDialog(null, "El prodcuto ingresados es el siguiente: ");
            System.out.println("\tcodigo\tProductoCantidad\tprecio");
            System.out.println((i+1)+".\t"+codigo[i]+"\t"+prod[i]+"\t"+cantidad[i]+"\t"+precio[i]);
            s=Integer.parseInt(JOptionPane.showInputDialog(null, "1. Correcto\n2. Incorrecto"));     
            if(s==2){
                for (int j = 0; j < 1; j++) {
                    opc=Integer.parseInt(JOptionPane.showInputDialog(null, "Elija el dato que quedo erroneo?\n1. Producto\n2. Precio\n3. Cantidad\n4. Volver a insertar producto"));
                    switch (opc){
                        case 1:
                            prod[i]=null;
                            prod[i]=(JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto"));
                            JOptionPane.showConfirmDialog(null, "El dato ingresado fue: "+prod[i]);
                   
                        case 2:
                           precio[i]=0;
                           precio[i]=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese eñ nuevo precio del producto"));
                           JOptionPane.showConfirmDialog(null, "El nuevo precio ingresado fue: "+precio[i]);
                        
                        case 3:
                           cantidad[i]=0;
                           cantidad[i]=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad"));
                           JOptionPane.showConfirmDialog(null, "La nueva cantidad ingresada fue: "+cantidad[i]);
                           
                        case 4:
                            i--;
                    }
                }
            }   
        }
        this.pocha=new Proceso();
        this.pocha.setDatos(prod,codigo,precio,cantidad);
   }
}
