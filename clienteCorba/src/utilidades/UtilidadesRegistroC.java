package utilidades;


import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import sop_corba.GestionPacientes;
import sop_corba.GestionPacientesHelper;


public class UtilidadesRegistroC
{   
    
    public static GestionPacientes obtenerObjRemoto(String[] vectorDatosNS, String idObjetoRemoto) 
    {
       
        GestionPacientes ref=null;
        try{
            ORB orb = ORB.init(vectorDatosNS, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***            
            ref = GestionPacientesHelper.narrow(ncRef.resolve_str(idObjetoRemoto));
        }
        catch(Exception e)
        {
            System.out.println("Error al localizar el objeto remoto");
        }
        
        return ref;
    }
    
}