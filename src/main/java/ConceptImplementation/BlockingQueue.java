package ConceptImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    public static void main(String[] args) throws Exception {
        BlockingQueue blockingQueue = new BlockingQueue(3);
        int maxRun=10000;
        Thread threadAdd = new Thread(()->{
            try {
                for(int i=0;i<maxRun;i++){
                     blockingQueue.add(i);
                    System.out.println("added value:"+ i);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadremove = new Thread(()->{
            try {
                for(int i=0;i<maxRun;i++){
                    int val = blockingQueue.remove();
                    System.out.println("removed value:"+ val);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        threadremove.start();
        threadAdd.start();
    }

    int capacity;
    Queue<Integer> queue;
    Object lock;
    BlockingQueue(int capacity){
        this.capacity = capacity;
        queue = new LinkedList<>();
        lock = new Object();
    }
    public void add(Integer str) throws Exception {
        while(true){
            synchronized (lock){
                if(queue.size() == capacity){
                    System.out.println("capacity is full");
                    lock.wait();
                }else{
                    queue.add(str);

                    System.out.println("added:"+str);
                    lock.notifyAll();
                    break;
                }


            }
        }


    }
    public Integer remove() throws InterruptedException {
        Integer val;
        while(true){
            synchronized (lock){
                if(queue.size() == 0){
                    System.out.println("size is zero");
                    lock.wait();
                }
                if( queue.size() >0){
                    val = queue.poll();
                    lock.notifyAll();
                    break;
                }

            }
        }

        return val;
    }
}
