package ConceptImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPoolExecuterImpl {

    int maxThreads;
    Queue<Runnable> queue;
    WorkerThread[] workers;

    ThreadPoolExecuterImpl(int maxThreads){
        this.maxThreads=maxThreads;
        queue =new LinkedList<>();
        workers= new WorkerThread[maxThreads];
        for(WorkerThread workerThread:workers){
            workerThread.start();
        }
    }
    void submit(Runnable task){

        synchronized (queue){
            queue.add(task);
            queue.notifyAll();
        }

    }
    class WorkerThread extends  Thread{
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
                     }else{
                         task = queue.poll();
                     }

                 }
                 task.run();
             }
        }
    }


}

