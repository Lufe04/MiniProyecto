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
    private String ruta;
    private String rutaEst;
    private String rutaAs;
    
    public void GestionInscripciones(){
        this.ruta= "./Archivos/Inscripciones.txt";
        this.rutaEst= "./Archivos/estudiantes.txt";
        this.rutaAs="./Asignaturas/Asignaturas.txt";
        this.verificArchivo();
    }
    private void verificArchivo() {
        try{
            File filex = new File(this.ruta); //revisa que la ruta este bien
            if(!filex.exists()) //si no existe el archivo
                filex.createNewFile();// lo crea, si ya esta creado pues no hace nada.  
        }
        catch (IOException ex){
            System.out.println("Problemas con la ruta");
            //ex.printStackTrace(); --> deja una ahoja de ruta de los errores que hay 
        }
    }
    public void crearInscripcion (){
       Estudiante est= this.buscarEst();
        Asignatura as=this.buscarAsig();
        if(est != null && as!=null){
            Inscripcion ins= new Inscripcion (as.getCodigo(),as.getNombre(),as.getCreditos(),est.getCodigo(),est.getNombre(),".",".",".");
            this.guardaInscripcion(ins);
        }
    }
    private void guardaInscripcion(Inscripcion ins){
        File file;
        FileWriter fr;
        PrintWriter pw;
        try{
            file=new File(this.ruta);
            fr = new FileWriter(file, true);//prepara la escritura, recibe el , el booleano true: agraga al final del archivo, false: borra el archivo e inicia de nuevo
                pw = new PrintWriter(fr);
            pw.println(ins);
            pw.close();
        }
        catch (IOException ex){
            System.out.println("No se pudo crear el estudiante"+ex);
        }
    }
    public void verIncripcion(){
        boolean existe = false;
        String code;
        FileReader file;
        BufferedReader br;
        String registro;
        int opc = Integer.parseInt(JOptionPane.showInputDialog("¿Cómo desea ver las inscripciones?\n1. Por alumno\n2. Por asignatura"));
        switch (opc){
            case 1:
                code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
                try{
                    file= new FileReader(this.ruta);
                    br= new BufferedReader(file);
                    while((registro = br.readLine()) != null){
                        String [] tokens = registro.split(",");
                        if (tokens[4].equals(code)) {
                            System.out.println(registro);
                            System.out.println("===============================================");
                            existe=true;
                            break;
                        } 
                    }
                    if(!existe)
                        JOptionPane.showMessageDialog(null, "Ese codigo no existe");
                }
                catch(IOException ex){
                    System.out.println("Falló cargando la inscripción"+ex);
                }
            case 2:
                code=JOptionPane.showInputDialog("Digite el codigo de la asignatura a buscar");
                try{
                    file= new FileReader(this.ruta);
                    br= new BufferedReader(file);
                    while((registro = br.readLine()) != null){
                        String [] tokens = registro.split(",");
                        if (tokens[0].equals(code)) {
                            System.out.println(registro);
                            System.out.println("===============================================");
                            existe=true;
                            break;
                        } 
                    }
                    if(!existe)
                        JOptionPane.showMessageDialog(null, "Ese codigo no existe");
                }
                catch(IOException ex){
                    System.out.println("Falló cargando la inscripción"+ex);
                }
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
    
    private Asignatura buscarAsig (){
        String code = JOptionPane.showInputDialog("Ingrese el codigo de la asignatura: ");
        boolean existe = false;
        Asignatura as= null;
        FileReader file;
        BufferedReader br;
        String registro;
        try{
            file= new FileReader("./Asignaturas/Asignaturas.txt");
            br= new BufferedReader(file);
            while(!existe){
               while((registro = br.readLine()) != null){
                    String [] tokens = registro.split(",");
                    if (tokens[0].equals(code)) {
                        System.out.println("entro");
                        as=new Asignatura(tokens[0],tokens[1],tokens[2]);
                        existe=true;
                        break;
                    } 
                }
            if(!existe){
                JOptionPane.showMessageDialog(null, "Ese codigo no existe");
                code = JOptionPane.showInputDialog("Ingrese el codigo de la asignatura: ");
            }
        }
        }
        catch(IOException ex){
            System.out.println("Falló cargando estudiante"+ex);
        }
        return as;
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
     
    private Estudiante buscarEst (){
        String cod= JOptionPane.showInputDialog("Ingrese el codigo del estudiante a inscribir: ");
        String codeEst="";
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        String registro;
        Estudiante stud = null;
        System.out.println("try");
        try{
            System.out.println("./Archivos/estudiantes.txt");
            System.out.println("despues try");
            file= new FileReader("./Archivos/estudiantes.txt");
            System.out.println(file);
            br= new BufferedReader(file);
            System.out.println(br);
            while((registro = br.readLine()) != null){
                String [] tokens = registro.split(",");
                if (tokens[0].equals(cod)) {
                    stud=new Estudiante(tokens[0],tokens[1],tokens[2].charAt(0),Integer.parseInt(tokens[3]));
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
        return stud;
     }
    
    /*private String verificarCodigoEst (){
        String cod= JOptionPane.showInputDialog("Ingrese el codigo del estudiante a inscribir: ");
        String codeEst="";
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
*/
}
