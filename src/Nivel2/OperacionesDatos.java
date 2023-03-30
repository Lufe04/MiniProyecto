package Nivel2;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class OperacionesDatos {
       public static void main(String[] x){
        new OperacionesDatos();
    }
    public OperacionesDatos(){
        this.configurar();  // solo se llama el primer metodo porque los demas se van llamando de forma escalonada     
    }
        //de Servicio
    private void configurar(){
        float datos[];
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos datos son: "));
        datos=new float[n]; 
        this.capturaDatos( n, datos);//le manda las variables a otro metodo, poniendo argumentos
    }
    //los argumentos y parametros tienen que estar en el mismo orden o si no, no hay coincidencia de tipos
    //cuando un metodo manda argumentos a otro, se suelen cambiar la viariables ya que el metodo que recibe "crea" una nueva variable con
    //con el dato recibido. Se puede dejar el mismo nombre de variable, pero se tiene que tener en cuenta que son diferentes variables en la memoria
    private void capturaDatos(int x, float [] data){ // se le pone los parametros que tiene que recibir de otro metodo
        for(int i=0;i<x;i++){
            data[i]=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato "+(i+1)));  
        }
        this.muestraOriginales(x, data);
    }
    private void muestraOriginales(int x, float [] data){
        for(int i=0;i<x;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println();
        this.mostrarOrdenados(x,data);
    }
    private void mostrarOrdenados(int x, float [] data){
        Arrays.sort(data);
        for(int i=0;i<x;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println();
        this.mayor(x, data);
    }
    private void mayor(int x, float [] data){
        JOptionPane.showMessageDialog(null,"El mayor dato es "+data[x-1]);
        this.menor(x,data);
    }
    private void menor(int n, float []data){
        JOptionPane.showMessageDialog(null,"El menor dato es "+data[0]);
        this.xMayores(n, data);
    }
    private void xMayores(int n, float [] data){
        int x;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos mejores quiere ver: "));        
            if(x>x)
                JOptionPane.showMessageDialog(null,"Solo hay  "+x+" datos..!!");
        }
        while(x>x);
        for(int i=-x;i<x;i++){
            System.out.print(data[i]+" ");            
        }
        System.out.println(); 
        this.xMenores(x, data);
    }
    private void xMenores(int n, float [] datos){
        int x;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos peores quiere ver: "));          
            if(x>n)
                JOptionPane.showMessageDialog(null,"Solo hay  "+n+" datos..!!");
        }
        while(x>n);
        for(int i=0;i<x;i++){
            System.out.print(datos[i]+" ");            
        }
        
        System.out.println();  
        this.promedio(n,datos);
    }
    private void promedio(int n, float [] datos){
        float acum=0,prom=0;
        for(int i=0;i<n;i++){
            acum+=datos[i];            
        }
        prom=acum/n;
        JOptionPane.showMessageDialog(null,"El promedio de los datos es  "+prom);
        this.desviacion(n,datos,prom);
    }
    private void desviacion(int n, float []datos, float prom){
        float sum=0, desvi=0;
        for(int i=0;i<n;i++){
            sum=(float)(sum+Math.pow(datos[i]-prom, 2));
        }
        desvi=(float)(Math.sqrt(sum)/n);
        JOptionPane.showMessageDialog(null,"La desviación de los datos es  "+prom);
    }
    
    
}
