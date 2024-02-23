package ArcessiumRoundOne;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RequestHandler {



   // ExecuterService executerService =
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    void handleRequest(String request) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(()->{
            for(int i =0;i<1000;i++){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        },"Complete");
        executorService.submit(task);
       String str= task.get();
        System.out.println(request +""+str);
    }

    public static void main(String[] args) throws Exception{
        RequestHandler requestHandler = new RequestHandler();
        for(int i=0;i<100;i++){
            requestHandler.handleRequest("Request "+i);
        }

    }


}
