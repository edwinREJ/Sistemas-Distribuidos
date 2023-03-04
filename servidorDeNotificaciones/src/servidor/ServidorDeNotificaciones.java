package servidor;

import sop_corba.GestionNotificaciones;
import utilidades.UtilidadesConsola;
import utilidades.UtilidadesRegistroS;
/**
 *
 * @author Edwin
 */
public class ServidorDeNotificaciones {

    
    public static void main(String[] args) {
       
        try 
        {
          String[] vectorDatosLocalizarNS = new String[4];//almacena la información para localizar el ns
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vectorDatosLocalizarNS[1] = UtilidadesConsola.leerCadena();
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vectorDatosLocalizarNS[3] = UtilidadesConsola.leerCadena();
            
            GestionNotificacionesImpl objRemotoNotificaciones = new GestionNotificacionesImpl();
      
            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoNotificaciones,"objNotificaciones");
      
            
        }    
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
        
    }
    
}
