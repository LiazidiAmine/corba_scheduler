package scheduler;

import org.omg.CORBA.ORB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SchedulerClient {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);

            BufferedReader fileReader = null;
            fileReader = new BufferedReader(new FileReader("ObjectRef"));


            String stringIOR = fileReader.readLine();
            fileReader.close();

            org.omg.CORBA.Object reference = orb.string_to_object(stringIOR);

            Scheduler schedulerProxy = SchedulerHelper.narrow(reference);

            Request req_post = new Request("object", "interface", "operation", null);

            schedulerProxy.post(req_post);

            Request req_receive = schedulerProxy.get((short) 0);
            System.out.println("object name : " + req_receive.object_req_name);
            System.out.println("interface name : " + req_receive.interface_req_name);
            System.out.println("operation name : " + req_receive.op_req);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
