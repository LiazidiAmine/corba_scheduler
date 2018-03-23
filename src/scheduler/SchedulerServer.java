package scheduler;

import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SchedulerServer {
    public static void main(String args[]) {
        try {

            ORB orb = ORB.init(args, null);

            POA rootPOA = null;

            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));


            SchedulerImpl scheduler = new SchedulerImpl();

            byte[] servantId = rootPOA.activate_object(scheduler);

            String reference = orb.object_to_string(rootPOA.id_to_reference(servantId));

            PrintWriter file = new PrintWriter("ObjectRef");
            file.println(reference);
            file.close();

            rootPOA.the_POAManager().activate();

            orb.run();

        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (WrongPolicy wrongPolicy) {
            wrongPolicy.printStackTrace();
        } catch (AdapterInactive adapterInactive) {
            adapterInactive.printStackTrace();
        } catch (ServantAlreadyActive servantAlreadyActive) {
            servantAlreadyActive.printStackTrace();
        } catch (ObjectNotActive objectNotActive) {
            objectNotActive.printStackTrace();
        }
    }
}
