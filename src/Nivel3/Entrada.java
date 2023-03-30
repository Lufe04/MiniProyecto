package Nivel3;
import javax.swing.*;
import java.util.Arrays;
public class Entrada {
        private Estadistica pepito;

    //metodos
    public static void main(String[] args){
        new Entrada();
    }
    public Entrada(){
        this.pepito=null;
        this.menu();
    }
    public void menu(){
            int opcion;
            boolean configuro=false;

            do
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Capturar datos \n"+
                        "2. Ver lista original \n"+
                        "3. Ver lista ordenada \n"+
                        "4. Ver mayor \n"+
                        "5. Ver menor \n"+
                        "6. Ver xMayores \n"+
                        "7. Ver xMenores \n"+
                        "8. Ver promedio \n"+
                        "9. Ver desviación \n"+
                        "0. SALIR \n"));

                switch (opcion)
                {
                    case 1:
                        configuro=true;
                        this.capturaDatos();
                        break;
                    case 2:
                        if (configuro)
                            this.pepito.muestraOriginales();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                        break;

                    case 3:
                        if (configuro)
                            this.pepito.muestraOrdenados();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                        break;
                    case 4:
                        if (configuro)
                            this.pepito.mayor();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                        break;
                    case 5:
                        if (configuro)
                            this.pepito.menor();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                        break;
                    case 6:
                        if (configuro)
                            this.pepito.xMayores();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                        break;
                    case 7:
                        if (configuro)
                            this.pepito.xMenores();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                        break;
                    case 8:
                        if (configuro)
                            this.pepito.promedio();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                        break;
                    case 9:
                        if (configuro)
                            this.pepito.desviacion();
                        else
                            JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
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

    private void capturaDatos(){
        int n;
        float[] datos;
        n=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos datos son: "));
        datos=new float[n];
        for(int i=0;i<datos.length;i++)
        {
            datos[i]=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato "+(i+1)));
        }

        this.pepito=new Estadistica();
        this.pepito.setDatos(datos);

    }
}
