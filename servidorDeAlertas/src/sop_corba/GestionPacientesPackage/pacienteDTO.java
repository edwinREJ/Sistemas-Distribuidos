package sop_corba.GestionPacientesPackage;


/**
* sop_corba/GestionPacientesPackage/pacienteDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from alertas.idl
* lunes 1 de agosto de 2022 01:46:00 AM CEST
*/

public final class pacienteDTO implements org.omg.CORBA.portable.IDLEntity
{
  public String nombre = null;
  public String apellido = null;
  public int numeroHabitacion = (int)0;
  public int edad = (int)0;

  public pacienteDTO ()
  {
  } // ctor

  public pacienteDTO (String _nombre, String _apellido, int _numeroHabitacion, int _edad)
  {
    nombre = _nombre;
    apellido = _apellido;
    numeroHabitacion = _numeroHabitacion;
    edad = _edad;
  } // ctor

} // class pacienteDTO
