package scheduler;

import java.util.ArrayList;

public class SchedulerImpl extends SchedulerPOA {

    private ArrayList<Request> req_list = new ArrayList<>();

    @Override
    public Request get(short index) {
        return req_list.get(index);
    }

    @Override
    public boolean post(Request req) {
        return req_list.add(req);
    }

    @Override
    public void del(short index) {
        req_list.remove(index);
    }

    @Override
    public boolean check_req(Request req) throws invalid_req {
        if (req.interface_req_name == null && req.object_req_name == null && req.op_req == null) {
            throw new invalid_req("L’objet, l’interface, la méthode demandée ne sont pas connus.");
        }
        return true;
    }
}
