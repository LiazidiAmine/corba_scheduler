package scheduler;


/**
* scheduler/invalid_req.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from treatment_scheduler.idl
* Friday, March 23, 2018 7:22:16 PM CET
*/

public final class invalid_req extends org.omg.CORBA.UserException
{
  public String error_msg = null;

  public invalid_req ()
  {
    super(invalid_reqHelper.id());
  } // ctor

  public invalid_req (String _error_msg)
  {
    super(invalid_reqHelper.id());
    error_msg = _error_msg;
  } // ctor


  public invalid_req (String $reason, String _error_msg)
  {
    super(invalid_reqHelper.id() + "  " + $reason);
    error_msg = _error_msg;
  } // ctor

} // class invalid_req