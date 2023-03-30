package Nivel5Persistencia;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
public class GestionEstudiantes {//se encarga de las operaciones CRUD, administrar coleccion de estudiantes
    //variables de clase
    private String ruta;
    //metodos
    public GestionEstudiantes(){
       this.ruta= "./Nivel5Persistencia/Archivos/estudiantes.txt";
       this.verificArchivo();   
    }
    private void verificArchivo() {
        try{
            File filex = new File("./Nivel5Persistencia/Archivos/estudiantes.txt"); //revisa que la ruta este bien
            if(!filex.exists()) //si no existe el archivo
                filex.createNewFile();// lo crea, si ya esta creado pues no hace nada.  
        }
        catch (IOException ex){
            System.out.println("Problemas con la ruta");
            //ex.printStackTrace(); --> deja una ahoja de ruta de los errores que hay 
        }
    }
    public void crearEstudiante(){
        String cod, nom;
        char gen;
        int age;
        float[] nota=new float[3];
        //datos estudiante
        cod=JOptionPane.showInputDialog("Digite el codigo del estudiante");
        nom=JOptionPane.showInputDialog("Digite el nombre del estudiante");
        gen=JOptionPane.showInputDialog("Digite el genero del estudiante: ").toUpperCase().charAt(0);
        age=Integer.parseInt(JOptionPane.showInputDialog("Digite la edad del estudiante: "));
        for (int i = 0; i < 3; i++) {
            nota[i]=Float.parseFloat(JOptionPane.showInputDialog("Digite la nota "+(i+1)+" del estudiante: " ));
            
        }
        //construir el estudiante
        Estudiante stud = new Estudiante (cod,nom,gen,age,nota);
        this.guardaEstudiante(stud);
        JOptionPane.showMessageDialog(null,"El estudiante ha sido creado con exito"); 
    }
    private void guardaEstudiante(Estudiante stud){
        File file;
        FileWriter fr;
        PrintWriter pw;
        try{
            file=new File(this.ruta);
            fr = new FileWriter(file, true);//prepara la escritura, recibe el , el booleano true: agraga al final del archivo, false: borra el archivo e inicia de nuevo
                pw = new PrintWriter(fr);
            pw.println(stud);
            pw.close();
        }
        catch (IOException ex){
            System.out.println("No se pudo crear el estudiante"+ex);
        }
    }  
    public void verEstudiante(){
        String code;
        boolean existe = false;
        FileReader file;
        BufferedReader br;
        String registro;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
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
            System.out.println("Falló cargando estudiante"+ex);
        }
    }
    public Estudiante buscarEstudiante(){
        String code;
        boolean existe = false;
        float [] notas = new float[3];
        FileReader file;
        BufferedReader br;
        String registro;
        Estudiante stud=null;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        try{
            file= new FileReader(this.ruta);
            br= new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String [] tokens = registro.split(",");
                if (tokens[0].equals(code)) {
                    notas[0]=Float.parseFloat(tokens[4]);
                    notas[1]=Float.parseFloat(tokens[5]);
                    notas[2]=Float.parseFloat(tokens[6]);
                    stud=new Estudiante(tokens[0],tokens[1],tokens[2].charAt(0),Integer.parseInt(tokens[3]),notas);
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
    public ArrayList<Estudiante> getTodos(){
        float [] notas = new float[3];
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
                for (int i = 0; i < 7; i++) {
                    notas[0]=Float.parseFloat(tokens[4]);
                    notas[1]=Float.parseFloat(tokens[5]);
                    notas[2]=Float.parseFloat(tokens[6]);
                    stud=new Estudiante(tokens[0],tokens[1],tokens[2].charAt(0),Integer.parseInt(tokens[3]),notas);
                    students.add(stud); 
                }    
            }    
        }
        catch(IOException ex){
            System.out.println("Falló cargando estudiante"+ex);
        }
        return students;
    }
    public void verTodos(){
        ArrayList<Estudiante> students = this.getTodos();
        for(Estudiante stud: students){
            System.out.println(stud);
        }
        System.out.println("====================================");
    }
    
    public void modificarCodigo(){
        String code, newcode;
        boolean existe = false;
        ArrayList<Estudiante> students=this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: students) {
            if (stud.getCodigo().equals(code)) {
                newcode=JOptionPane.showInputDialog("Inserte el nuevo codigo del estudiante: ");
                stud.setCodigo(newcode);
                this.recargArchivo(students);
                JOptionPane.showMessageDialog(null, "El codigo del estudiante ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
    private void recargArchivo (ArrayList<Estudiante> students){
        File file;
        FileWriter fr;
        PrintWriter pw;
        try{
            file=new File(this.ruta);
            fr = new FileWriter(file, false);//prepara la escritura, recibe el , el booleano true: agraga al final del archivo, false: borra el archivo e inicia de nuevo
            pw = new PrintWriter(fr);
            for(Estudiante stud: students) 
                pw.println(stud);
                pw.close();
               
        }
        catch (IOException ex){
            System.out.println("No se pudo crear el estudiante"+ex);
        }
    }
     public void modificarNombre(){
        String code, newcode;
        boolean existe = false;
        ArrayList<Estudiante> students=this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: students) {
            if (stud.getCodigo().equals(code)) {
                newcode=JOptionPane.showInputDialog("Inserte el nuevo nombre del estudiante: ");
                stud.setNombre(newcode);
                this.recargArchivo(students);
                JOptionPane.showMessageDialog(null, "El nombre del estudiante ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
     public void modificarGenero(){
        String code;
        char newcode;
        boolean existe = false;
        ArrayList<Estudiante> students=this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: students) {
            if (stud.getCodigo().equals(code)) {
                newcode=JOptionPane.showInputDialog("Inserte el nuevo genero del estudiante: ").toUpperCase().charAt(0);
                stud.setGenero(newcode);
                this.recargArchivo(students);
                JOptionPane.showMessageDialog(null, "El genero del estudiante ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
     public void modificarEdad(){
        String code;
        int newcode;
        boolean existe = false;
        ArrayList<Estudiante> students=this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: students) {
            if (stud.getCodigo().equals(code)) {
                newcode=Integer.parseInt(JOptionPane.showInputDialog("Inserte la nueva edad del estudiante: "));
                stud.setEdad(newcode);
                this.recargArchivo(students);
                JOptionPane.showMessageDialog(null, "La edad del estudiante ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
     public void modificarNotas(){
        String code;
        int n;
        float [] nonotas;
        boolean existe = false;
        ArrayList<Estudiante> students=this.getTodos();
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: students) {
            if (stud.getCodigo().equals(code)) {
                
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }

    /*
    
    public void removerEstudiante(){
        String code;
        boolean existe = false;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: this.misEstudiantes) {
            if (stud.getCodigo().equals(code)) {
               this.misEstudiantes.remove(stud);
               JOptionPane.showMessageDialog(null,"El estudiante ha sido removido");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
    
   
    
    
    
    private PrintWriter PrintWriter(FileWriter fr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/

    private PrintWriter PrintWriter(FileWriter fr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
