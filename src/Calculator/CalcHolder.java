package Calculator;

/**
* Calculator/CalcHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculator.idl
* Monday, April 2, 2018 2:56:55 PM CEST
*/

public final class CalcHolder implements org.omg.CORBA.portable.Streamable
{
  public Calculator.Calc value = null;

  public CalcHolder ()
  {
  }

  public CalcHolder (Calculator.Calc initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Calculator.CalcHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Calculator.CalcHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Calculator.CalcHelper.type ();
  }

}
