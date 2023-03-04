package vista;

import org.omg.CORBA.BooleanHolder;
import sop_corba.GestionPacientes;
import sop_corba.GestionPacientesPackage.pacienteDTO;
import sop_corba.GestionPacientesPackage.pacienteDTOHolder;

import utilidades.UtilidadesConsola;

/**
 *
 * @author Edwin
 */
public class Menu {
    
     private final GestionPacientes objRemoto;
    
    public Menu(GestionPacientes objRemoto)
    {
        this.objRemoto=objRemoto;
    }
    
      public void ejecutarMenuPrincipal()
    {
        int opcion = 0;
        do
        {
            System.out.println("=========Menu========");
            System.out.println("1. Registrar Personal");	
            System.out.println("2. Consultar Personal");	
            System.out.println("3. Salir");
            System.out.println("=====================");

            opcion = UtilidadesConsola.leerEntero();

            switch(opcion)
            {
                case 1:
                        Opcion1();
                        break;
                case 2:
                        Opcion2();
                        break;
                case 3:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcion != 3);
    }
    
     private void Opcion1() 
    {
   
        BooleanHolder resp = new BooleanHolder();
        System.out.println("Ingrese el nombre: ");
        String nombre = UtilidadesConsola.leerCadena();
        System.out.println("Ingrese el apellido: ");
        String apellido = UtilidadesConsola.leerCadena();
        System.out.println("Ingrese el numero de habitacion: ");
        int num_habitacion = UtilidadesConsola.leerEntero();
        System.out.println("Ingrese la edad: ");
        int edad = UtilidadesConsola.leerEntero();
        
        System.out.println("");

        pacienteDTO objPersonal = new pacienteDTO(nombre, apellido, num_habitacion, edad);

        objRemoto.registrarPaciente(objPersonal, resp);

        if (resp.value) {
            System.out.println("El paciente ha sido registrado");
        } else {
            System.out.println("El paciente no pudo ser registrado");
        }
    }  
     
    private void Opcion2() 
    { 
      
        pacienteDTOHolder pac = new pacienteDTOHolder();
        System.out.println("Ingrese el numero de la habitacion: ");
        int id = UtilidadesConsola.leerEntero();
        boolean consulta = objRemoto.buscarPaciente(id, pac);

        if (consulta) {
            
            String nombre = pac.value.nombre;
            String apellido = pac.value.apellido;
            int num_habitacion = pac.value.numeroHabitacion;
            int edad = pac.value.edad;
           
            System.out.println("Datos del paciente");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Numero de habitacion: " + num_habitacion);
            System.out.println("Edad: " + edad);
            
        } else {
            System.out.println("Paciente no encontrado");
        }
    } 
}
