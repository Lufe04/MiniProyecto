package Nivel2;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class OperacionesDatos7{
    //VARIABLES DE CLASE
    private float[] datos;
    private float[] copia;
    private float prom;
    
    //METODOS
        //Obligatorios
    public static void main(String[] x){
        new OperacionesDatos7();
    }
    public OperacionesDatos7(){
       this.datos=null;
       this.copia=null;//los datos se inicializan en null 
       this.prom=0;
       
       this.menu();
    }
    
        //de Servicio
    private void menu()
    {
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
                    this.configurar();
                    configuro=true;
                    this.capturaDatos();                    
                break;
                case 2:
                    if (configuro)
                        this.muestraOriginales();
                    else
                        JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");
                break;
                case 3:
                    if (configuro)
                        this.muestraOrdenados();
                    else
                        JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");                     
                break;
                case 4:
                    if (configuro)
                        this.mayor();
                    else
                        JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");                    
                break;
                case 5:
                    if (configuro)
                        this.menor();
                    else
                        JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");                     
                break;
                case 6:
                    if (configuro)
                        this.xMayores();
                    else
                        JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");                    
                break;
                case 7:
                     if (configuro)
                        this.xMenores();
                    else
                        JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");                    
                break;
                case 8:
                    if (configuro)
                        this.promedio();
                    else
                        JOptionPane.showMessageDialog(null, "Debe capturar datos primero..!!");                     
                break;
                case 9:
                    if (configuro)
                        this.desviacion();
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
    private void configurar()
    {
        //Definir estructuras de datos
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos datos son: "));
        this.datos=new float[n];
    }
    private void capturaDatos()
    {        
	//Capturar datos
        for(int i=0;i<this.datos.length;i++)
        {
            this.datos[i]=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato "+(i+1)));            
        }
        this.copia=this.datos.clone();        
        Arrays.sort(this.datos);
    }
    private void muestraOriginales()
    {
        //Mostrar datos originales
        for(int i=0;i<this.copia.length;i++)
        {
            System.out.print(this.copia[i]+" ");            
        }
        System.out.println();
    }
    private void muestraOrdenados()
    {
        //Mostrar datos ordenados
        for(int i=0;i<this.datos.length;i++)
        {
            System.out.print(this.datos[i]+" ");            
        }
        System.out.println();
    }
    private void mayor()
    {
        //Mostrar mayor dato
        JOptionPane.showMessageDialog(null,"El mayor dato es "+this.datos[this.datos.length-1]);
    }
    private void menor()
    {
        //Mostrar menor dato
        JOptionPane.showMessageDialog(null,"El menor dato es "+this.datos[0]);
    }
    private void xMayores()
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
    private void xMenores()
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
    private void promedio()
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
    private void desviacion()
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


