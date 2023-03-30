package Nivel2;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class OperacionesDatos1 {
       public static void main(String[] x){
        new OperacionesDatos1();
    }
    public OperacionesDatos1(){
        this.configurar();  // solo se llama el primer metodo porque los demas se van llamando de forma escalonada     
    }
        //de Servicio
    private void configurar(){
        float datos[];
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos datos son: "));
        datos=new float[n]; 
        this.capturaDatos(datos);//le manda las variables a otro metodo, poniendo argumentos
    }
    //los argumentos y parametros tienen que estar en el mismo orden o si no, no hay coincidencia de tipos
    //cuando un metodo manda argumentos a otro, se suelen cambiar la viariables ya que el metodo que recibe "crea" una nueva variable con
    //con el dato recibido. Se puede dejar el mismo nombre de variable, pero se tiene que tener en cuenta que son diferentes variables en la memoria
    private void capturaDatos(float [] data){ // se le pone los parametros que tiene que recibir de otro metodo
        for(int i=0;i<data.length;i++){
            data[i]=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato "+(i+1)));  
        }
        this.muestraOriginales( data);
    }
    private void muestraOriginales( float [] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println();
        this.mostrarOrdenados(data);
    }
    private void mostrarOrdenados(float [] data){
        Arrays.sort(data);
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println();
        this.mayor( data);
    }
    private void mayor( float [] data){
        JOptionPane.showMessageDialog(null,"El mayor dato es "+data[data.length-1]);
        this.menor(data);
    }
    private void menor( float []data){
        JOptionPane.showMessageDialog(null,"El menor dato es "+data[0]);
        this.xMayores(data);
    }
    private void xMayores(float [] data){
        int x=0;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos mejores quiere ver: "));        
            if(x>data.length)
                JOptionPane.showMessageDialog(null,"Solo hay  "+x+" datos..!!");
        }
        while(x>data.length);
        for(int i= data.length - x;i< data.length;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println(); 
        this.xMenores(data);
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
        this.promedio(datos);
    }
    private void promedio( float [] datos){
        float acum=0,prom=0;
        for(int i=0;i<datos.length;i++){
            acum+=datos[i];            
        }
        prom=acum/datos.length;
        JOptionPane.showMessageDialog(null,"El promedio de los datos es  "+prom);
        this.desviacion(datos,prom);
    }
    private void desviacion( float []datos, float prom){
        float sum=0, desvi=0;
        for(int i=0;i<datos.length;i++){
            sum=(float)(sum+Math.pow(datos[i]-prom, 2));
        }
        desvi=(float)(Math.sqrt(sum)/datos.length);
        JOptionPane.showMessageDialog(null,"La desviación de los datos es  "+prom);
    }
    
    
}
