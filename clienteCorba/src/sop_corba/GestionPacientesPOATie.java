package sop_corba;


/**
* sop_corba/GestionPacientesPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from alertas.idl
* lunes 1 de agosto de 2022 01:46:00 AM CEST
*/

public class GestionPacientesPOATie extends GestionPacientesPOA
{

  // Constructors

  public GestionPacientesPOATie ( sop_corba.GestionPacientesOperations delegate ) {
      this._impl = delegate;
  }
  public GestionPacientesPOATie ( sop_corba.GestionPacientesOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public sop_corba.GestionPacientesOperations _delegate() {
      return this._impl;
  }
  public void _delegate (sop_corba.GestionPacientesOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void registrarPaciente (sop_corba.GestionPacientesPackage.pacienteDTO objPacienteo, org.omg.CORBA.BooleanHolder resultado)
  {
    _impl.registrarPaciente(objPacienteo, resultado);
  } // registrarPaciente

  public boolean buscarPaciente (int numeroHabitacion, sop_corba.GestionPacientesPackage.pacienteDTOHolder objPacienteResultado)
  {
    return _impl.buscarPaciente(numeroHabitacion, objPacienteResultado);
  } // buscarPaciente

  private sop_corba.GestionPacientesOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionPacientesPOATie
