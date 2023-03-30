
package PracticaExamen1;
import javax.swing.JOptionPane;
public class Tienda {
    //variables de clase
    private String[][] inventario;// solamente se definen las variables
    int nProductos;
    public Tienda(){// se encarga de poner un valor inicial a las variables 
        this.inventario=new String [10][4];
        this.nProductos=0;
    }
    public void compra(){
        String id, producto;
        int cantidad, posi;
        float pCompra;
        
        producto=JOptionPane.showInputDialog("Digite el producto: ").toUpperCase();
        posi=verificarExistencia(producto);
        this.verificarExistencia(producto);
        cantidad=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad: " ));
        if (posi==-1) {
            id = "PR" + (int)(10+Math.random()*90);
            pCompra=Float.parseFloat(JOptionPane.showInputDialog("Digite el precio por unidad: "));
            this.inventario[this.nProductos][0]=id;
            this.inventario[this.nProductos][1]=producto;
            this.inventario[this.nProductos][3]=String.valueOf(cantidad);
            this.inventario[this.nProductos][2]=String.valueOf(pCompra);
            this.nProductos++;
        }
        else{
            this.inventario[posi][3]= String.valueOf(Integer.parseInt(this.inventario[posi][3])+cantidad);
        }      
    }
    
    public void venta(){
       String lista= "Escriba el producto que desea.. Digite Cero para salir \n \n", quiero;
       int cantidad, pos, respuesta;
       float total=0;
        for (int i = 0; i < this.nProductos; i++) {
            if(!this.inventario[i][3].equals("0")){
            lista+= this.inventario[i][1]+" "+(Float.parseFloat(this.inventario[i][2])*1.25) +"\n"; 
            }
        }
        do{
            quiero=JOptionPane.showInputDialog(lista).toUpperCase();
            if (true) {
                pos=this.verificarExistencia(quiero);
                cantidad=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad: " ));
                
                if(cantidad <= (Integer.parseInt(this.inventario[pos][3]))){
                total+=cantidad * Float.parseFloat(this.inventario[pos][2])*1.25;
                this.inventario[pos][3]= String.valueOf(Integer.parseInt(this.inventario[pos][3])-cantidad);
                }
                else{
                    respuesta=Integer.parseInt(JOptionPane.showInputDialog("Solo tengo: "+this.inventario[pos][3]+" quiere llevarlos? 1. SI | 2. NO"));
                    if(respuesta == 1){
                        total+=Integer.parseInt(this.inventario[pos][3])*Float.parseFloat(this.inventario[pos][2])*1.25;
                        this.inventario[pos][3]="0";
                    }
                    
                }    
            }
        }
        while(!quiero.equals(0));
        if (total>0) {
            JOptionPane.showMessageDialog(null, "Listo... Su cuenta es: "+total);
        }
    }
    
    public void verInventario(){
        for (int i = 0; i < this.nProductos; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(this.inventario[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("========================================");
        
    }   
    public void precioInventario(){
        float total=0;
        for (int i = 0; i < this.nProductos; i++) {
            total+=(Integer.parseInt(this.inventario[i][3])*Float.parseFloat(this.inventario[i][2]));
        }
        total*=1.25;
        JOptionPane.showMessageDialog(null,"EL precio actual del inventario es: "+total );
    }
    private int verificarExistencia(String produ){
        int pos=-1; //posicion que no existe en el inventario, si lo devuelve es que no encontro el prodcuto en ele inventario
        for (int i = 0; i < this.nProductos; i++) {
            if (this.inventario[i][1].equals(produ)) {
                pos=i;
                break;                
            }
        }
        return pos;
    }
}

