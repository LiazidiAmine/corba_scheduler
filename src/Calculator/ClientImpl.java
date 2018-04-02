package Calculator;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.TypeCode;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClientImpl implements ClientOperations{
    static Calc calc;
    static Scheduler scheduler;
    static SchedulerImpl schedulerImpl;
    final static long num_client = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check;
        try{
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            scheduler = SchedulerHelper.narrow(ncRef.resolve_str("Scheduler"));

            do {
                check = true;
                int a,b;
                System.out.println("\n\nCalcul : \n\n"
                        + "1.Sum.\n2.Rest.\n3.Mult.\n");
                a= sc.nextInt();
                switch(a) {
                    case 1 :
                        System.out.println("Sum \n First value : ");
                        a = sc.nextInt();
                        System.out.println("Sum \n Second value : ");
                        b = sc.nextInt();
                        Request req = new Request();
                        schedulerImpl.post(req, 1);
                }

            }while(check);

            schedulerImpl.start();
        }catch(Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    @Override
    public String callback(String result, int request_id) {
        return "Result : "+result + "// request : "+request_id + " From client : "+num_client;
    }
}
