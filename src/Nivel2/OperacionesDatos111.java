package Nivel2;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class OperacionesDatos111 {
       public static void main(String[] x){
        new OperacionesDatos111();
    }
    public OperacionesDatos111(){
        this.manejador();
        
    }
        //de Servicio
    private void manejador(){
        float datos [] = this.configurar();  
        this.capturaDatos(datos); 
        this.muestraOriginales(datos);
        this.mostrarOrdenados(datos);
        this.mayor( datos);
        this.menor(datos);
        this.xMayores(datos);
        this.xMenores(datos);
        float prom = this.promedio(datos);
        this.desviacion(datos,prom);
    }
    private float [] configurar(){
        float datos[];
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos datos son: "));
        datos=new float[n]; //le manda las variables a otro metodo, poniendo argumentos
        return datos;
    }
    //los argumentos y parametros tienen que estar en el mismo orden o si no, no hay coincidencia de tipos
    //cuando un metodo manda argumentos a otro, se suelen cambiar la viariables ya que el metodo que recibe "crea" una nueva variable con
    //con el dato recibido. Se puede dejar el mismo nombre de variable, pero se tiene que tener en cuenta que son diferentes variables en la memoria
    private void capturaDatos(float [] data){ // se le pone los parametros que tiene que recibir de otro metodo
        for(int i=0;i<data.length;i++){
            data[i]=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato "+(i+1)));  
        }
    }
    private void muestraOriginales( float [] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println();
        
    }
    private void mostrarOrdenados(float [] data){
        Arrays.sort(data);
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println();
    }
    private void mayor( float [] data){
        JOptionPane.showMessageDialog(null,"El mayor dato es "+data[data.length-1]);
        
    }
    private void menor( float []data){
        JOptionPane.showMessageDialog(null,"El menor dato es "+data[0]);
        
    }
    private void xMayores(float [] data){
        int x=0;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos mejores quiere ver: "));        
            if(x>x)
                JOptionPane.showMessageDialog(null,"Solo hay  "+x+" datos..!!");
        }
        while(x>data.length);
        for(int i=data.length-x ; i<data.length ; i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println(); 
    }
    private void xMenores( float [] datos){
        int x;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos peores quiere ver: "));          
            if(x>datos.length)
                JOptionPane.showMessageDialog(null,"Solo hay  "+datos.length+" datos..!!");
        }
        while(x>datos.length);
        for(int i=0;i<x;i++){
            System.out.print(datos[i]+" ");            
        }
        
        System.out.println();  
        
    }
    private float promedio( float [] datos){
        float acum=0,prom;
        for(int i=0;i<datos.length;i++){
            acum+=datos[i];            
        }
        prom=acum/datos.length;
        JOptionPane.showMessageDialog(null,"El promedio de los datos es  "+prom);
        return prom;
    }
    private void desviacion( float []datos, float prom){
        float sum=0, desvi;
        for(int i=0;i<datos.length;i++){
            sum=(float)(sum+Math.pow(datos[i]-prom, 2));
        }
        desvi=(float)(Math.sqrt(sum)/datos.length);
        JOptionPane.showMessageDialog(null,"La desviación de los datos es  "+prom);
    }
    
    
}
