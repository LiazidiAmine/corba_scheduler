package Calculator;


/**
* Calculator/Invalid_req.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculator.idl
* Monday, April 2, 2018 2:56:55 PM CEST
*/

public final class Invalid_req extends org.omg.CORBA.UserException
{
  public String error_msg = null;

  public Invalid_req ()
  {
    super(Invalid_reqHelper.id());
  } // ctor

  public Invalid_req (String _error_msg)
  {
    super(Invalid_reqHelper.id());
    error_msg = _error_msg;
  } // ctor


  public Invalid_req (String $reason, String _error_msg)
  {
    super(Invalid_reqHelper.id() + "  " + $reason);
    error_msg = _error_msg;
  } // ctor

} // class Invalid_req