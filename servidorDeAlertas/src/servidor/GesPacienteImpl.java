package servidor;

import java.util.ArrayList;
import org.omg.CORBA.BooleanHolder;
import sop_corba.GestionNotificaciones;
import sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO;
import sop_corba.GestionPacientesOperations;
import sop_corba.GestionPacientesPackage.pacienteDTO;
import sop_corba.GestionPacientesPackage.pacienteDTOHolder;


/**
 *
 * @author Edwin Espinosa Y Fabian Marin
 */
public class GesPacienteImpl implements GestionPacientesOperations{
    
  private ArrayList<pacienteDTO> pacientes;
  GestionNotificaciones ref;
  
  public GesPacienteImpl(GestionNotificaciones objNotificaciones){
    pacientes = new ArrayList();
    ref = objNotificaciones; 
  }

    @Override
    public void registrarPaciente(pacienteDTO objPacienteo, BooleanHolder resultado) {

        int ban=0;
        resultado.value = false;
        System.out.println("Registrando personal...........");
        if(!pacientes.contains(objPacienteo))
        {
            pacientes.add(objPacienteo);
            ban = 1;
            resultado.value = true;
        }
        ClsMensajeNotificacionDTO objMensaje = new ClsMensajeNotificacionDTO(objPacienteo.nombre,
        objPacienteo.apellido, objPacienteo.numeroHabitacion , ban);
        ref.notificaarRegistro(objMensaje);
    }

    @Override
    public boolean buscarPaciente(int numeroHabitacion, pacienteDTOHolder objPacienteResultado) {

        System.out.println("Consultando personal..........");
       
        for(pacienteDTO objPaciente : pacientes){
            if(objPaciente.numeroHabitacion == numeroHabitacion){
                objPacienteResultado.value = objPaciente;
                return true;
            }
        }
        objPacienteResultado.value = new pacienteDTO(" ", " ", -1, -1);
        return false;
        
    }
    
}
