package Calculator;

import org.omg.CORBA.ORB;

public class CalcImpl extends CalcPOA{
    private ORB orb;

    public void setOrb(ORB orb){
        this.orb = orb;
    }

    @Override
    public float sum(float x, float y) {
        return x+y;
    }

    @Override
    public float rest(float x, float y) {
        return x-y;
    }

    @Override
    public float multi(float x, float y) {
        return x*y;
    }

    @Override
    public float div(float x, float y) {
        return x / y;
    }

    @Override
    public void stop() {
        orb.shutdown(true);
    }
}
