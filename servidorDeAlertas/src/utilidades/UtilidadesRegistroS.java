package utilidades;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import servidor.GesPacienteImpl;
import sop_corba.GestionPacientes;
import sop_corba.GestionPacientesPOATie;

public class UtilidadesRegistroS
{
	public static void registrarObjetoRemoto(String[] vectorDatosNS, GesPacienteImpl objRemoto,String idObjetoRemoto) throws ServantNotActive, WrongPolicy, org.omg.CORBA.ORBPackage.InvalidName, AdapterInactive, InvalidName, NotFound, CannotProceed
        {            

        try {
            // crea e iniciia el ORB
            ORB orb = ORB.init(vectorDatosNS, null);

            // obtiene la referencia del rootpoa & activate el POAManager
            POA rootpoa
                    = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            //convref.setORB(orb); 
            //*** crea un tie, con el servant como delegado***
            GestionPacientesPOATie gptie = new GestionPacientesPOATie(objRemoto);

            //*** Obtener la referencia para el tie
            GestionPacientes reftie = gptie._this(orb);

            // obtiene la base del contexto de nombrado
            org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
            // Usa NamingContextExt el cual es parte de la especificacion 
            // Naming Service (INS).
            NamingContextExt ncref = NamingContextExtHelper.narrow(objref);

            // *** Realiza el binding de la referencia de objeto en el N_S ***
            String name = "idObjetoRemoto";
            NameComponent path[] = ncref.to_name(name);
            ncref.rebind(path, reftie);
            System.out.println("El Servidor GestionPacientes esta listo y esperando ...");
            // esperan por las invocaciones desde los clientes
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("Servidor: Saliendo ...");

    }
}
	

