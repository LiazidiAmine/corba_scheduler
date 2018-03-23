package scheduler;


/**
* scheduler/SchedulerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from treatment_scheduler.idl
* Friday, March 23, 2018 7:22:16 PM CET
*/

abstract public class SchedulerHelper
{
  private static String  _id = "IDL:scheduler/Scheduler:1.0";

  public static void insert (org.omg.CORBA.Any a, scheduler.Scheduler that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scheduler.Scheduler extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (scheduler.SchedulerHelper.id (), "Scheduler");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scheduler.Scheduler read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_SchedulerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scheduler.Scheduler value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static scheduler.Scheduler narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scheduler.Scheduler)
      return (scheduler.Scheduler)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scheduler._SchedulerStub stub = new scheduler._SchedulerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static scheduler.Scheduler unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scheduler.Scheduler)
      return (scheduler.Scheduler)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scheduler._SchedulerStub stub = new scheduler._SchedulerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}