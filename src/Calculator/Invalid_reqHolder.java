package Calculator;

/**
* Calculator/Invalid_reqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculator.idl
* Monday, April 2, 2018 2:56:55 PM CEST
*/

public final class Invalid_reqHolder implements org.omg.CORBA.portable.Streamable
{
  public Calculator.Invalid_req value = null;

  public Invalid_reqHolder ()
  {
  }

  public Invalid_reqHolder (Calculator.Invalid_req initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Calculator.Invalid_reqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Calculator.Invalid_reqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Calculator.Invalid_reqHelper.type ();
  }

}