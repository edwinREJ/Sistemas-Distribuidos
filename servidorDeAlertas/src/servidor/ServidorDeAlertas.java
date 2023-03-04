package servidor;

import servidor.utilidades.UtilidadesConsola;
import sop_corba.GestionNotificaciones;
import utilidades.UtilidadesRegistroC;
import utilidades.UtilidadesRegistroS;

/**
 *
 * @author Edwin R. Espinosa Jimenez.
 */
public class ServidorDeAlertas {

    private static GestionNotificaciones objNotificaciones;
    
    public static void main(String[] args) {
      
        try {
            String[] vectorDatosLocalizarNS = new String[4];//almacena la información para localizar el ns
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vectorDatosLocalizarNS[1] = UtilidadesConsola.leerCadena();
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vectorDatosLocalizarNS[3] = UtilidadesConsola.leerCadena();
            
            objNotificaciones = UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS, "objNotificaciones");
            
            GesPacienteImpl objRemotoPaciente = new GesPacienteImpl(objNotificaciones);
            
      
            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoPaciente,"idObjetoRemoto");
       
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
        
    }
    
    
}
