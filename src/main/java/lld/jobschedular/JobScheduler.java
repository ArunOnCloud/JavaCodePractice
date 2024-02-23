package lld.jobschedular;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class JobScheduler {


    public static void main(String[] args) {
        JobScheduler jobScheduler = new JobScheduler(4);

        for(int i=0;i<1000;i++){
            final int  taksId = i;
            jobScheduler.submit(()->{
                System.out.println("taks "+taksId+" Running");
                for(int j=0;j<10;j++){
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("taks "+taksId+" Finished");
            });
        }
    }


    Map<String,String> jobStatus=new HashMap<>();


    Queue<Job> queue = new LinkedList<>();
    Object lock = new Object();
    AtomicInteger counter = new AtomicInteger();

    public JobScheduler(int threadCount){
        if(threadCount <=0){
            throw  new RuntimeException("count should be greater than 1");
        }
        WorkerThread[] threads = new WorkerThread[threadCount];

        for(int i=0;i<threadCount ;i++){
            threads[i] = new WorkerThread("thread_"+i);
            threads[i].start();
        }
    }

    public String submit(Runnable runnable){
        Integer count = counter.incrementAndGet();
        String jobId = "job_"+count;
        Job job = new Job(jobId,runnable);
        synchronized (lock){
            jobStatus.put(job.jobId,"SUBMITTED");
            queue.add(job);
            lock.notifyAll();
        }
        return jobId;
    }

    public String getStatus(String id){
        return jobStatus.get(id);
    }

    class WorkerThread extends  Thread{

        String name;
        WorkerThread(String name){
            this.name = name;
        }

        public void run(){

            while(true){

                Job job = null;

                synchronized (lock){

                    if(queue.size() == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        job = queue.poll();
                        lock.notifyAll();
                    }

//                    if(queue.size() >0){
//                        job= queue.poll();
//                        lock.notifyAll();
//                    }else{
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
                }
                if( job != null){
                    jobStatus.put(job.jobId,"STARTED");
                    job.runnable.run();;
                    jobStatus.put(job.jobId,"FINISHED");
                    job = null;
                }
            }
        }


    }




}

class Job{
    String jobId;

    Runnable runnable;

    Job(String jobId,Runnable runnable){
        this.jobId =jobId;
        this.runnable = runnable;

    }


}
