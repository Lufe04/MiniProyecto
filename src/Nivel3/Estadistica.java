package Nivel3;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Estadistica {
    //variables de clase
    private float [] datos;
    private float [] copia;
    private float prom;
    //metodos, no tiene metodo main, porque se va a comunicar con el main de entrada

    public Estadistica(){
        this.datos=null;//los arreglos se inicializan en null
        this.copia=null;
        this.prom=0;
    }
    public Estadistica(float [] datos){
        this.datos=datos;
        this.copia=this.datos.clone();
        this.prom=0;
    }
    public void setDatos(float [] datos){//metodo modificador que accede a los datos del rray de la case entrada
        this.datos=datos;//la variable de clase que necesito igual a la variable que estoy recibiendo
        this.copia=this.datos.clone();
        Arrays.sort(this.datos);
    }
    public void muestraOriginales()
    {
        //Mostrar datos originales
        for(int i=0;i<this.copia.length;i++)
        {
            System.out.print(this.copia[i]+" ");            
        }
        System.out.println();
    }
    public void muestraOrdenados()
    {
        //Mostrar datos ordenados
        for(int i=0;i<this.datos.length;i++)
        {
            System.out.print(this.datos[i]+" ");            
        }
        System.out.println();
    }
    public void mayor()
    {
        //Mostrar mayor dato
        JOptionPane.showMessageDialog(null,"El mayor dato es "+this.datos[this.datos.length-1]);
    }
    public void menor()
    {
        //Mostrar menor dato
        JOptionPane.showMessageDialog(null,"El menor dato es "+this.datos[0]);
    }
    public void xMayores()
    {
        //Mostrar x mejores datos
        int x;
        do
        {
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos mejores quiere ver: "));        
            if(x>this.datos.length)
                JOptionPane.showMessageDialog(null,"Solo hay  "+this.datos.length+" datos..!!");
        }
        while(x>this.datos.length);
        for(int i=this.datos.length-x;i<this.datos.length;i++)
        {
            System.out.print(this.datos[i]+" ");            
        }
        System.out.println();  
    }
    public void xMenores()
    {
        //Mostrar x peores datos
        int x;
        do
        {
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos peores quiere ver: "));          
            if(x>this.datos.length)
                JOptionPane.showMessageDialog(null,"Solo hay  "+this.datos.length+" datos..!!");
        }
        while(x>this.datos.length);
        for(int i=0;i<x;i++)
        {
            System.out.print(this.datos[i]+" ");            
        }
        
    }
    public void promedio()
    {          
        //Mostrar promedio
        float acum=0;
        for(int i=0;i<this.datos.length;i++)
        {
            acum+=this.datos[i];            
        }
        this.prom=acum/this.datos.length;
        JOptionPane.showMessageDialog(null,"El promedio de los datos es  "+this.prom);
    }
    public void desviacion()
    {
        //Mostrar desviación
        float sum=0,desvi;
        for(int i=0;i<this.datos.length;i++)
        {
            sum=(float)(sum+Math.pow(this.datos[i]-this.prom, 2));
        }
        desvi=(float)(Math.sqrt(sum)/this.datos.length);
        JOptionPane.showMessageDialog(null,"La desviación de los datos es  "+desvi);
    } 
}
