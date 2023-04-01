package ConceptImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPoolExecuterImpl {

    int maxThreads;
    Queue<Runnable> queue;
    WorkerThread[] workers;

    public static void main(String[] args){

        ThreadPoolExecuterImpl threadPoolExecuter= new ThreadPoolExecuterImpl(4);
        for(int i=0;i<100;i++){
            final  int integ=i;
            threadPoolExecuter.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task "+ integ+" is running");
                    for(int j=0;j<100000;j++){

                    }
                }
            });
        }
    }
    ThreadPoolExecuterImpl(int maxThreads){
        this.maxThreads=maxThreads;
        queue =new LinkedList<>();
        workers= new WorkerThread[maxThreads];
        for(int i=0;i<maxThreads;i++){
            workers[i]=new WorkerThread("Thread "+i);
        }
        for(WorkerThread workerThread:workers){

            workerThread.start();
        }
    }
    void submit(Runnable task){

        synchronized (queue){
            queue.add(task);
            queue.notify();
        }

    }
    private class WorkerThread extends  Thread{
        String name;
        WorkerThread(String name){
            this.name=name;
        }
        @Override
        public void run(){
            Runnable task=null;
             while(true){
                 synchronized (queue){
                     if(queue.size() ==0){
                         try {
                             queue.wait();
                         } catch (InterruptedException e) {
                             throw new RuntimeException(e);
                         }
                     }
                     task = queue.poll();


                 }
                 task.run();
             }

        }
    }


}

