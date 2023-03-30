package MiniProyecto;

import Nivel5Persistencia.Estudiante;
import javax.swing.JOptionPane;

public class Entrada {
       private final GestionEstudiantes gestor;
       private final GestionAsignaturas gestorsito;
       private final GestionInscripciones gestorIns;
   //metodos
   public static void main(String[] args){
        new MiniProyecto.Entrada();
    }
    public Entrada(){
        this.gestor=new GestionEstudiantes();
        this.gestorsito=new GestionAsignaturas();
        this.gestorIns = new GestionInscripciones();
        this.menuPrincipal(); 
    }
    public void menuPrincipal(){
        int opcion;
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Gestion de estudiantes \n"+
                        "2. gestion de asignaturas \n"+
                        "3. Gestion de inscripciones \n"+
                        "4. Asignar notas \n"+                        
                        "0. SALIR \n"));

                switch (opcion)
                {
                   case 1:
                        menuEstudiantes();
                        break;
                    case 2:
                        menuAsignaturas();
                        break;
                    case 3:
                        menuInscripciones();
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Chao pescaoo..!!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ese caso NO existe..!!");
                        break;
                }
            }
            while(opcion!=0);
    }
    
    public void menuEstudiantes(){
            int opcion;
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Ingresar estudiante \n"+
                        "2. Ver estudiante \n"+
                        "3. Ver todo \n"+
                        "4. Modificar estudiante \n"+ 
                        "5. Remover estudiante \n"+
                        "6. Buscar estudiante"+
                        "0. SALIR \n"));

                switch (opcion)
                {
                    case 1:
                        this.gestor.crearEstudiante();
                        break;
                    case 2:
                        this.gestor.verEstudiante();
                        break;                    
                    case 3:
                        this.gestor.verTodos();
                        break;
                    case 4:
                        menuModificaciones();
                        break;
                    case 5:
                        this.gestor.eliminarEstudiante();
                        
                        break;
                    case 6:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ese caso NO existe..!!");
                        break;
                }
            }
            while(opcion!=0);
        }
    public void menuModificaciones(){
            int opcion;
            do
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Codigo \n"+
                        "2. Nombre \n"+
                        "3. Genero \n"+
                        "4. Edad \n"+
                        "0. Regresar \n"));

                switch (opcion)
                {
                    case 1:
                        this.gestor.modificarCodigo();
                        break;
                    case 2:
                        this.gestor.modificarNombre();
                        break;
                    case 3:
                        this.gestor.modificarGenero();
                        break;
                    case 4:
                        this.gestor.modificarEdad();
                        break;
                    case 0:
                        this.menuPrincipal();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ese caso NO existe..!!");
                        break;
                }
            }
            while(opcion!=0);
    }
    public void menuAsignaturas(){
        int opcion;
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Crear asignatura \n"+
                        "2. Ver asignatura \n"+
                        "3. Eliminar asignatura \n"+
                        "4. Modificar asignatura \n"+
                        "5. Ver todas \n"+
                        "0. SALIR \n"));

                switch (opcion)
                {
                   case 1:
                        this.gestorsito.crearAsignatura();
                        break;
                    case 2:
                        this.gestorsito.verAsignatura();
                        break;
                    case 3:
                       
                        break;
                    case 4:
                        menuModificacionesAs();
                        break;
                    case 5:
                        this.gestorsito.verTodas();
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ese caso NO existe..!!");
                        break;
                }
            }
            while(opcion!=0);
    }
    public void menuModificacionesAs(){
        int opcion;
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Modificar codigo \n"+
                        "2. Modificar nombre \n"+
                        "3. Modificar numero de creditos \n"+
                        "0. SALIR \n"));

                switch (opcion)
                {
                   case 1:
                        this.gestorsito.modificarCodigoAs();
                        break;
                    case 2:
                        this.gestorsito.modificarNombreAs();
                        break;
                    case 3:
                       this.gestorsito.modificarCreditosAs();
                        break;
                    case 4:
                        menuAsignaturas();
                        break;
                    case 5:
                        this.gestorsito.verTodas();
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ese caso NO existe..!!");
                        break;
                }
            }
            while(opcion!=0);
    }
    public void menuInscripciones (){
        int opcion;
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Crear inscripcion \n"+
                        "2. ver inscripcion \n"+
                        "3. Eliminar inscripcion \n"+
                        "4. ver todas \n"+                        
                        "0. SALIR \n"));

                switch (opcion)
                {
                   case 1:
                        this.gestorIns.crearInscripcion();
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;                   
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ese caso NO existe..!!");
                        break;
                }
            }
            while(opcion!=0);
    }
    
}
