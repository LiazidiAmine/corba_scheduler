package scheduler;


/**
* scheduler/RequestHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from treatment_scheduler.idl
* Friday, March 23, 2018 7:22:16 PM CET
*/

abstract public class RequestHelper
{
  private static String  _id = "IDL:scheduler/Request:1.0";

  public static void insert (org.omg.CORBA.Any a, scheduler.Request that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scheduler.Request extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "object_req_name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "interface_req_name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "op_req",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_any);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "req_params",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (scheduler.RequestHelper.id (), "Request", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scheduler.Request read (org.omg.CORBA.portable.InputStream istream)
  {
    scheduler.Request value = new scheduler.Request ();
    value.object_req_name = istream.read_string ();
    value.interface_req_name = istream.read_string ();
    value.op_req = istream.read_string ();
    int _len0 = istream.read_long ();
    value.req_params = new org.omg.CORBA.Any[_len0];
    for (int _o1 = 0;_o1 < value.req_params.length; ++_o1)
      value.req_params[_o1] = istream.read_any ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scheduler.Request value)
  {
    ostream.write_string (value.object_req_name);
    ostream.write_string (value.interface_req_name);
    ostream.write_string (value.op_req);
    ostream.write_long (value.req_params.length);
    for (int _i0 = 0;_i0 < value.req_params.length; ++_i0)
      ostream.write_any (value.req_params[_i0]);
  }

}