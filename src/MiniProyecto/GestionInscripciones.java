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
    String rutaAs;
    private void GestionInscripciones(){
        this.ruta= "./Archivos/Inscripciones.txt";
        this.rutaEst="./Archivos/Estudiantes.txt";
        this.rutaAs="../Asignaturas/Asignaturas.txt";
        
    }
    public void crearInscripcion (){
        ArrayList<Inscripciones> inscripcion = new ArrayList();
        String codeEst= this.verificarCodigoEst();
        String codeAs=this.verificarCodigoAsig();
        if(codeEst != null && codeAs!=null){
            ArrayList<Asignatura> asignatura = this.getTodosAs();
            ArrayList<Estudiante> estudiante = this.getTodosEst();
            
        }
              
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
    public ArrayList<Asignatura> getTodosAs(){
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
    
    private String verificarCodigoAsig (){
        String code = JOptionPane.showInputDialog("Ingrese el codigo de la asignatura: ");
        String codeAs = "";
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        String registro;
        try{
            file= new FileReader(this.rutaAs);
            br= new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String [] tokens = registro.split(",");
                if (tokens[0].equals(code)) {
                    codeAs= tokens[0];
                    System.out.println(codeAs);
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
        return codeAs;
     }
    
    public ArrayList<Estudiante> getTodosEst(){
        FileReader file;
        BufferedReader br;
        String registro;
        Estudiante stud=null;
        ArrayList<Estudiante> students=new ArrayList();
        try{
            file= new FileReader(this.ruta);
            br= new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String [] tokens = registro.split(",");
                for (int i = 0; i < 1; i++) {
                    stud=new Estudiante(tokens[0],tokens[1],tokens[2].charAt(0),Integer.parseInt(tokens[3]));
                    students.add(stud); 
                }    
            }    
        }
        catch(IOException ex){
            System.out.println("Falló cargando estudiante"+ex);
        }
        return students;
    }
     
    private String verificarCodigoEst (){
        String cod= JOptionPane.showInputDialog("Ingrese el codigo del estudiante a inscribir: ");
        String codeEst = " ";
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        String registro;
        try{
            file= new FileReader(this.rutaEst);
            br= new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String [] tokens = registro.split(",");
                if (tokens[0].equals(cod)) {
                    codeEst= tokens[0];
                    System.out.println(codeEst);
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
        return codeEst;
     }
}
