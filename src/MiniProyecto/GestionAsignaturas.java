package MiniProyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionAsignaturas {
    private String ruta;
    //metodos
    public GestionAsignaturas(){
       this.ruta= "./Asignaturas/Asignaturas.txt";
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
    public void crearAsignatura(){
        String cod, nom, cred;
        File file;
        //datos estudiante
        cod=JOptionPane.showInputDialog("Digite el codigo de la asignatura");
        this.verificarCodigo(cod);
        if (cod != null) {
            nom=JOptionPane.showInputDialog("Digite el nombre de la asignatura");
            cred=JOptionPane.showInputDialog("Digite el numero de creditos de la materia");
            //construir la asignatura
            Asignatura as = new Asignatura (cod, nom, cred);
            this.guardaAsignatura(as);
            JOptionPane.showMessageDialog(null,"La materia ha sido creada con exito"); 
        }
        else{
            JOptionPane.showConfirmDialog(null, "El codigo ingresado ya se encunetra en uso");
        }
    }
    private void guardaAsignatura(Asignatura as){
        File file;
        FileWriter fr;
        PrintWriter pw;
        try{
            file=new File(this.ruta);
            fr = new FileWriter(file, true);//prepara la escritura, recibe el , el booleano true: agraga al final del archivo, false: borra el archivo e inicia de nuevo
                pw = new PrintWriter(fr);
            pw.println(as);
            pw.close();
        }
        catch (IOException ex){
            System.out.println("No se pudo crear la materia"+ex);
        }
    }
    public void verAsignatura(){
        String code;
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        String registro;
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
                JOptionPane.showMessageDialog(null, "La asignatura no existe");
        }
        catch(IOException ex){
            System.out.println("Falló cargando la asignatura"+ex);
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
    public void verTodas(){
        ArrayList<Asignatura> asi = this.getTodos();
        for(Asignatura as: asi){
            System.out.println(asi);
        }
        System.out.println("====================================");
    }
    private void recargArchivo (ArrayList<Asignatura> asi){
        File file;
        FileWriter fr;
        PrintWriter pw;
        try{
            file=new File(this.ruta);
            fr = new FileWriter(file, false);//prepara la escritura, recibe el , el booleano true: agraga al final del archivo, false: borra el archivo e inicia de nuevo
            pw = new PrintWriter(fr);
            for(Asignatura as: asi) 
                pw.println(asi);
                pw.close();
               
        }
        catch (IOException ex){
            System.out.println("No se pudo crear la asignatura"+ex);
        }
    }
        public void modificarCodigoAs(){
        String code, newcode;
        boolean existe = false;
        ArrayList <Asignatura> asi =this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo de la materia a buscar");
        for (Asignatura as: asi) {
            if (as.getCodigo().equals(code)) {
                newcode=JOptionPane.showInputDialog("Inserte el nuevo codigo de la asignatura: ");
                as.setCodigo(newcode);
                this.recargArchivo(asi);
                JOptionPane.showMessageDialog(null, "El codigo de la asignatura ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"No se ha encontrado el codigo");
        }
    }
        public void modificarNombreAs(){
        String code, newcode;
        boolean existe = false;
        ArrayList <Asignatura> asi =this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo de la materia a buscar");
        for (Asignatura as: asi) {
            if (as.getCodigo().equals(code)) {
                newcode=JOptionPane.showInputDialog("Inserte el nuevo nombre de la asignatura: ");
                as.setNombre(newcode);
                this.recargArchivo(asi);
                JOptionPane.showMessageDialog(null, "El nombre de la asignatura ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"No se ha encontrado el codigo");
        }
    }
        public void modificarCreditosAs(){
        String code, newcode;
        boolean existe = false;
        ArrayList <Asignatura> asi =this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Asignatura as: asi) {
            if (as.getCodigo().equals(code)) {
                newcode=JOptionPane.showInputDialog("Inserte la nueva cantidad de creditos de la asignatura: ");
                as.setCreditos(newcode);
                this.recargArchivo(asi);
                JOptionPane.showMessageDialog(null, "La cantidad de creditos de la asignatura ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"No se ha encontrado el codigo");
        }
    }    
        private Asignatura verificarCodigo (String cod){
        String code;
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        String registro;
        Asignatura codi=null;
         try{
            file= new FileReader(this.ruta);
            br= new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String [] tokens = registro.split(",");
                if (tokens[0].equals(cod)) {
                    codi=new Asignatura(tokens[0],tokens[1],tokens[2]);
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
        return codi;
     }
}
