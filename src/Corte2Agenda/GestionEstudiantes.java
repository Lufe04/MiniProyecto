package Corte2Agenda;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class GestionEstudiantes {//se encarga de las operaciones CRUD, administrar coleccion de estudiantes
    //variables de clase
    private ArrayList<Estudiante> misEstudiantes;
    //metodos
    public GestionEstudiantes(){
        this.misEstudiantes = new ArrayList();
    }
    public void agregarEstudiante(){
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
        Estudiante stud = new Estudiante (cod, nom, gen, age,nota);
        this.misEstudiantes.add(stud);
        JOptionPane.showMessageDialog(null,"El estudiante ha sido creado con exito"); 
    }
    public void buscarEstudiante(){
        String code;
        boolean existe = false;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: this.misEstudiantes) {
            if (stud.getCodigo().equals(code)) {
                System.out.println(stud);
                System.out.println("==========================================================");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
    public void verTodos(){
        for (Estudiante stud: this.misEstudiantes) {
            System.out.println(stud);
            System.out.println("==========================================================");
        }
    }
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
    public void modificarCodigo(){
        String code, newcode;
        int posi;
        boolean existe = false;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: this.misEstudiantes) {
            if (stud.getCodigo().equals(code)) {
                newcode=JOptionPane.showInputDialog("Inserte el nuevo codigo del estudiante: ");
                posi=this.misEstudiantes.indexOf(stud);
                stud.setCodigo(newcode);
                existe = true;
                JOptionPane.showMessageDialog(null, "El codigo del estudiante ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
    public void modificarNombre(){
        String nname, code;
        boolean existe = false;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: this.misEstudiantes) {
            if (stud.getCodigo().equals(code)) {
                nname=JOptionPane.showInputDialog("Inserte el nuevo nombre del estudiante: ");
                stud.setNombre(nname);
                existe = true;
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
        char gen;
        boolean existe = false;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: this.misEstudiantes) {
            if (stud.getCodigo().equals(code)) {
                gen=JOptionPane.showInputDialog("Inserte el nuevo genero del estudiante: ").charAt(0);
                stud.setGenero(gen);
                existe = true;
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
        int ed;
        boolean existe = false;
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: this.misEstudiantes) {
            if (stud.getCodigo().equals(code)) {
                ed=Integer.parseInt(JOptionPane.showInputDialog("Inserte el nuevo genero del estudiante: "));
                stud.setEdad(ed);
                existe = true;
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
        code=JOptionPane.showInputDialog("Digite el codigo del estudiante a buscar");
        for (Estudiante stud: this.misEstudiantes) {
            if (stud.getCodigo().equals(code)) {
                nonotas=stud.getNotas();
                n=Integer.parseInt(JOptionPane.showInputDialog("Que nota desea modificar? 1, 2, 3"));
                nonotas[n-1]=Integer.parseInt(JOptionPane.showInputDialog("Digite la nueva nota"));
                stud.setNotas(nonotas);
                existe = true;
                JOptionPane.showMessageDialog(null, "La nota del estudiante ha sido modificado");
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
        }
    }
}
