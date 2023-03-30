package Parcial1;

import javax.swing.JOptionPane;

public class Proceso {
    private String [][] vuelo;
    public Proceso(){
        this.vuelo=new String [75][4];
        
    } 
    public void reserva(){
        String seccion, id, silla;
        int  posi, pasajero;
        id=JOptionPane.showInputDialog("Digite su identificación: ");
        pasajero=Integer.parseInt(JOptionPane.showInputDialog("¿Cuantons pasajeros van a ser?"));
        if (pasajero>1) {
            for (int i = 0; i < pasajero; i++) {
                JOptionPane.showMessageDialog(null, "PASAJERO "+(i+1));
                seccion=JOptionPane.showInputDialog("¿En que seccion desea reservar su asiento?  A|B|C|D").toUpperCase();
                silla=(JOptionPane.showInputDialog("Elija el numero de silla que desea"));
                posi=this.buscador(seccion,silla);
                if (posi!=-1) {
                    if (this.vuelo[posi][3].equals("*")){
                        this.vuelo[posi][2]= id;
                        this.vuelo[posi][3]= "R";
                        JOptionPane.showMessageDialog(null, "El asiento que ha reservado es: "+seccion+silla);
                    }
                else{
                    JOptionPane.showMessageDialog(null, "El asiento no esta disponible");
                }
            }  
        }
        }else{
            seccion=JOptionPane.showInputDialog("¿En que seccion desea reservar su asiento?  A|B|C|D").toUpperCase();
            silla=(JOptionPane.showInputDialog("Elija el numero de silla que desea"));
            posi=this.buscador(seccion,silla);
            if (posi!=-1) {
                if (this.vuelo[posi][3].equals("*")){
                this.vuelo[posi][2]= id;
                this.vuelo[posi][3]= "R";
               }
                else{
                    JOptionPane.showMessageDialog(null, "El asiento no esta disponible");
                }
            }
        }  
    }
    public void compra(){
        int x, pos, npasa;
        float a=40000, b= 35000, c= 30000, d= 25000, e=20000, tot;
        String seccion, silla;
        String id;
        id=JOptionPane.showInputDialog("Digite su identificacion: ");
        x=Integer.parseInt(JOptionPane.showInputDialog("¿Tiene una reserva?  1. SI | 2. NO"));
        if (x == 1) {
            pos=this.buscador(id, id);
            if (this.vuelo[pos][2].equals(id)) {
                
            }
        }
        if(x==2){
            npasa=Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos pasajeros son?"));
            for (int i = 0; i < npasa; i++) {
                seccion=JOptionPane.showInputDialog("Ingrese la seccion donde desea comprar su asiento A|B|C|D").toUpperCase();
                silla=JOptionPane.showInputDialog("Ingrese el numero de silla: ");
                pos=this.buscador(seccion,silla);
                if (pos!=-1) {
                    if (this.vuelo[pos][3].equals("*")){
                    this.vuelo[pos][2]= id;
                    this.vuelo[pos][3]= "C";
                    JOptionPane.showMessageDialog(null, "El asiento que ha reservado es: "+seccion+silla);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El asiento no esta disponible");
                }
                } 
            }
        }
    }
    public void cancelarReserva(){
    
    }
    public void verEstado(){
        int cont=1, cont2=1, cont3=1, cont4=1, cont5=1;
        for (int i = 0; i < 75; i++) {
            this.vuelo[i][0]= "A";
            this.vuelo[i][1]= String.valueOf(cont);
            this.vuelo[i][2]= "*";
            this.vuelo[i][3]= "*";
            cont++;
            if (i>=15 & i<30) {
                this.vuelo[i][0]= "B";
                this.vuelo[i][1]= String.valueOf(cont2);
                this.vuelo[i][2]= "*";
                this.vuelo[i][3]= "*";    
                cont2++;
            }
            if (i>=30 & i<45) {
                this.vuelo[i][0]= "C";
                this.vuelo[i][1]= String.valueOf(cont3);
                this.vuelo[i][2]= "*";
                this.vuelo[i][3]= "*";
                cont3++;
            }
            if (i>=45 & i<60) {
                this.vuelo[i][0]= "D";
                this.vuelo[i][1]= String.valueOf(cont4);
                this.vuelo[i][2]= "*";
                this.vuelo[i][3]= "*";
                cont4++;
            }
            if(i>=60){
                this.vuelo[i][0]= "E";
                this.vuelo[i][1]= String.valueOf(cont5);
                this.vuelo[i][2]= "*";
                this.vuelo[i][3]= "*";
                cont5++;
            }
        }
        for (int i = 0; i < 75; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(this.vuelo[i][j]+"\t");
            }
            System.out.print("\n");
        }
        System.out.println("========================================");
        
    }
    private int buscador(String sec, String sil){
        int pos=-1;
        for (int i = 0; i < 75; i++) {
            if (this.vuelo[i][0].equals(sec) & this.vuelo[i][1].equals(sil)){
                    pos=i;
                    break;                
                }
            }
        return pos;
    }
        
    }
    

