package Nivel5Persistencia;

import javax.swing.JOptionPane;

public class Entrada {//soporta los menus, control del programa
    //variables de clase
    private final GestionEstudiantes gestor;
   //metodos
   public static void main(String[] args){
        new Entrada();
    }
    public Entrada(){
        this.gestor= new GestionEstudiantes();
        this.menuPrincipal();
    }
    public void menuPrincipal(){
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
                    case 6:
                        Estudiante stud= this.gestor.buscarEstudiante();
                        if (stud!= null){
                            System.out.println(stud);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No existe el estudiante");
                        }
                        break;
                    case 3:
                        this.gestor.verTodos();
                        break;
                    case 4:
                        menuModificaciones();
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
    public void menuModificaciones(){
            int opcion;
            do
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("=====OPCIONES======\n"+
                        "1. Codigo \n"+
                        "2. Nombre \n"+
                        "3. Genero \n"+
                        "4. Edad \n"+ 
                        "5. Nota \n"+
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
                    case 5:
                        this.gestor.modificarNotas();
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
}
