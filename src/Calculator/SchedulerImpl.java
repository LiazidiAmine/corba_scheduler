package Calculator;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class SchedulerImpl extends SchedulerPOA{
    private class StructClient {
        private final Request req;
        private final long num_client;

        public StructClient(Request req, long num_client) {
            this.req = req;
            this.num_client = num_client;
        }
    }
    private List<StructClient> req_list = new ArrayList<>();
    private ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    private ClientImpl client = new ClientImpl();

    @Override
    public boolean post(Request req, int num_client) {
        return req_list.add(new StructClient(req, num_client));
    }

    @Override
    public void del(int request_id, int num_client) {
        req_list = req_list.stream().filter(x -> (x.num_client != num_client && request_id != x.req.request_number)).collect(Collectors.toList());
    }

    @Override
    public boolean check_req(Request req) throws Invalid_req {
        if (req.interface_request_name == null && req.request_object_name == null && req.operation_name == null) {
            throw new Invalid_req("L’objet, l’interface, la méthode demandée ne sont pas connus.");
        }
        return true;
    }

    public void start() {
        req_list.forEach(x -> {
            Future future = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.out.print("Task interrupted");
                        e.printStackTrace();
                    }
                }
            });
            try {
                String result = String.valueOf(future.get());
                client.callback(result, x.req.request_number);
            }catch(InterruptedException e){
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });
    }

}
