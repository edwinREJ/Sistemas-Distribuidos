package sop_corba;


/**
* sop_corba/GestionPacientesOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from alertas.idl
* lunes 1 de agosto de 2022 01:46:00 AM CEST
*/

public interface GestionPacientesOperations 
{
  void registrarPaciente (sop_corba.GestionPacientesPackage.pacienteDTO objPacienteo, org.omg.CORBA.BooleanHolder resultado);
  boolean buscarPaciente (int numeroHabitacion, sop_corba.GestionPacientesPackage.pacienteDTOHolder objPacienteResultado);
} // interface GestionPacientesOperations
