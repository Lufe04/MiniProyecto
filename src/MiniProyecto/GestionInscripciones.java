package MiniProyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionInscripciones {
    String ruta;
    String rutaEst;
    private void GestionInscripciones(){
        this.ruta= "./Archivos/Inscripciones.txt";
        this.rutaEst="./Archivos/Estudiantes.txt";
        
    }
    public void crearInscripcion (){
            ArrayList <String> inscripciones = new ArrayList();
            String idest= this.verificarCodigoEst();
            System.out.println(idest);
            /*while (idest == null){
                idest = this.verificarCodigoEst();
            }*/
            
            /*String idasi=this.verificarCodigoEInscribirAsig(idest);
            while (idasi == null){
                idasi = this.verificarCodigoEInscribirAsig(idest);
            }  */   
        }
    private void recargArchivo (ArrayList<Asignatura> asignaturas){
        File file;
        FileWriter fr;
        PrintWriter pw;
        try{
            file=new File(this.ruta);
            fr = new FileWriter(file, true);//prepara la escritura, recibe el , el booleano true: agraga al final del archivo, false: borra el archivo e inicia de nuevo
            pw = new PrintWriter(fr);
            for(Asignatura as: asignaturas){
                pw.println(as.toString());   
            }
            pw.close();
        }
        catch (IOException ex){
            System.out.println("No se pudo crear el estudiante"+ex);
        }
     }
    public ArrayList<Asignatura> getTodos(){
        FileReader file;
        BufferedReader br;
        String registro;
        Asignatura as=null;
        ArrayList<Asignatura> asi =new ArrayList();
        try{
            file= new FileReader(this.ruta);
            br= new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String [] tokens = registro.split(",");
                for (int i = 0; i < 1; i++) {
                    as=new Asignatura(tokens[0],tokens[1],tokens[2]);
                    asi.add(as); 
                }    
            }    
        }
        catch(IOException ex){
            System.out.println("Falló cargando la asignatura"+ex);
        }
        return asi;
    }
    private String verificarCodigoAsig (String idest){
        JOptionPane.showInputDialog("Ingrese el codigo de la asignatura: ");
        return " ";
     }
    private String verificarCodigoEst (){
        String idest=JOptionPane.showInputDialog("Ingrese el codigo del estudiante: ");
        System.out.println(idest);
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        String registro;
        try{
            System.out.println("before try");
            file= new FileReader(this.rutaEst);      
            System.out.println("before t333");
            br= new BufferedReader(file);
            while((registro = br.readLine()) != null){
                System.out.println("while");
                String [] tokens = registro.split(",");
                if (tokens[0].equals(idest)) {
                    idest=tokens[0];
                    existe=true;
                    break;
                } 
            }
            if(!existe)
                JOptionPane.showMessageDialog(null, "Ese codigo no existe");
        }
        catch(IOException ex){
            System.out.println("Falló cargando estudiante"+ex);
        }
        return idest;
     }
}
