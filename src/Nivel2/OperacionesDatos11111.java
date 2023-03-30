package Nivel2;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class OperacionesDatos11111 {
    
    private float [] datos;
    private float prom;
       public static void main(String[] x){
        new OperacionesDatos11111();
    }
    public OperacionesDatos11111(){
        this.datos = null;
        this.prom=0;
        this.menu();
        
    }
        //de Servicio
        private void menu(){
        int opc;
        do{
            opc=Integer.parseInt(JOptionPane.showInputDialog(null, "Elija una opción"
                + "\n1. Añadir un dato"
                + "\n2. Mostrar datos originales"
                + "\n3. Mostrar datos ordenados"
                + "\n4. Mostrar numero mayor"
                + "\n5. Mostrar numero menor\n"
                + "6. Mostrar los x mejores\n"
                + "7. Mostrar los x peores\n"
                + "8. Mostrar el promedio\n"
                + "9. Mostrar la desviacion estandar\n"
                + "0. SALIR"));
        
            switch(opc){
            case 1:
                this.configurar();
                this.capturaDatos();
                break;
            case 2:
                this.muestraOriginales();
                break;
            case 3:
                this.mostrarOrdenados();
                break;
            case 4:
                this.mayor( );
                break;
            case 5:
                this.menor();
                break;
            case 6:
                this.xMayores();
                break;
            case 7:
                this.xMenores();
                break;
            case 8:
                this.promedio();
                break;
            case 9:
                this.desviacion();
                break;           
            }
        }
        while(opc!=0);
                
    }
    private void configurar(){
        float datos[];
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos datos son: "));
        this.datos=new float[n]; //le manda las variables a otro metodo, poniendo argumentos
    }
    //los argumentos y parametros tienen que estar en el mismo orden o si no, no hay coincidencia de tipos
    //cuando un metodo manda argumentos a otro, se suelen cambiar la viariables ya que el metodo que recibe "crea" una nueva variable con
    //con el dato recibido. Se puede dejar el mismo nombre de variable, pero se tiene que tener en cuenta que son diferentes variables en la memoria
    private void capturaDatos(){ // se le pone los parametros que tiene que recibir de otro metodo
        for(int i=0;i<this.datos.length;i++){// se coloca el this en la variable para mostrar que es una variable de clase
            this.datos[i]=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato "+(i+1)));  
        }
    }
    private void muestraOriginales(){
        for(int i=0;i<this.datos.length;i++){
            System.out.print(this.datos[i]+" ");            
        }
        System.out.println();
        
    }
    private void mostrarOrdenados(){
        Arrays.sort(this.datos);
        for(int i=0;i<this.datos.length;i++){
            System.out.print(this.datos[i]+" ");            
        }
        System.out.println();
    }
    private void mayor(){
        JOptionPane.showMessageDialog(null,"El mayor dato es "+this.datos[this.datos.length-1]);
        
    }
    private void menor(){
        JOptionPane.showMessageDialog(null,"El menor dato es "+this.datos[0]);
        
    }
    private void xMayores(){
        int x=0;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos mejores quiere ver: "));        
            if(x>x)
                JOptionPane.showMessageDialog(null,"Solo hay  "+x+" datos..!!");
        }
        while(x>this.datos.length);
        for(int i=this.datos.length-x ; i<this.datos.length ; i++){
            System.out.print(this.datos[i]+" ");            
        }
        System.out.println(); 
    }
    private void xMenores(){
        int x;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos peores quiere ver: "));          
            if(x>this.datos.length)
                JOptionPane.showMessageDialog(null,"Solo hay  "+this.datos.length+" datos..!!");
        }
        while(x>this.datos.length);
        for(int i=0;i<x;i++){
            System.out.print(this.datos[i]+" ");            
        }
        
        System.out.println();  
        
    }
    private void promedio(){
        float acum=0;
        for(int i=0;i<this.datos.length;i++){
            acum+=this.datos[i];            
        }
        this.prom=acum/this.datos.length;
        JOptionPane.showMessageDialog(null,"El promedio de los datos es  "+this.prom);
    }
    private void desviacion(){
        float sum=0, desvi;
        for(int i=0;i<this.datos.length;i++){
            sum=(float)(sum+Math.pow(this.datos[i]-this.prom, 2));
        }
        desvi=(float)(Math.sqrt(sum)/this.datos.length);
        JOptionPane.showMessageDialog(null,"La desviación de los datos es  "+this.prom);
    }
    
    
}
