package scheduler;

/**
* scheduler/invalid_reqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from treatment_scheduler.idl
* Friday, March 23, 2018 7:22:16 PM CET
*/

public final class invalid_reqHolder implements org.omg.CORBA.portable.Streamable
{
  public scheduler.invalid_req value = null;

  public invalid_reqHolder ()
  {
  }

  public invalid_reqHolder (scheduler.invalid_req initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scheduler.invalid_reqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scheduler.invalid_reqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scheduler.invalid_reqHelper.type ();
  }

}