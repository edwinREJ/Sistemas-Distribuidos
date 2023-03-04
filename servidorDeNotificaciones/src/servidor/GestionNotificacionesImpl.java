package servidor;

import sop_corba.GestionNotificacionesOperations;
import sop_corba.GestionNotificacionesPackage.ClsMensajeNotificacionDTO;

/**
 *
 * @author Edwin Espinosa Y Fabian Marin
 */
public class GestionNotificacionesImpl implements GestionNotificacionesOperations{

    @Override
    public void notificaarRegistro(ClsMensajeNotificacionDTO objNotificacion) {

        if(objNotificacion.estado == 1){
            System.out.println("Notificando el registro exitoso......");
            System.out.println("Nombre: "+objNotificacion.nombre);
            System.out.println("Apellido: "+objNotificacion.apellido);
            System.out.println("Numero de habitacion: "+objNotificacion.numeroHabitacion);
        }
        else{
            System.out.println("Notificando fallo en el registro.....");
            System.out.println("Nombre: "+objNotificacion.nombre);
            System.out.println("Apellido: "+objNotificacion.apellido);
            System.out.println("Numero de habitacion: "+objNotificacion.numeroHabitacion);
        }
    }
    
}
