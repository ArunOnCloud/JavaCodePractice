import java.util.*;

public class JSWObserver {


    public static void main(String[] args) {

        Mediator mediator=new Mediator();
        mediator.addSubcriber("createOrder",new LogService());
        mediator.produce("createOrder","firstOrder");

    }
}
class Mediator{

    String[] topics=new String[]{"createOrder","paymentDone"};
    Map<String , Set<Subscriber>> map=new HashMap<>();

    Map<String, Queue<String>> mapMessage=new HashMap<>();

    void addSubcriber(String topic,Subscriber subscriber){
        // validate topic
        Set<Subscriber> set= map.getOrDefault(topic,new HashSet<>());
        set.add(subscriber);
        map.put(topic,set);
    }
    void produce(String topic,String message){
        Queue<String> q=mapMessage.getOrDefault(topic,new LinkedList<>());
        q.add(message);
        mapMessage.put(topic,q);
        for(Subscriber subscriber: map.get(topic)){
            subscriber.notify(message);
        }

    }
//    void notifyToSubscriber(String topic){
//       for( Subscriber subscriber: )
//    }
}
interface Subscriber{
    void notify(String message);
}
class LogService implements  Subscriber{

    void receiveNotification(String message){
        System.out.println("log service:" +message);
    }
    public void notify(String message){
        receiveNotification(message);
    }



}
//class LogService implements  Subscriber{
//
//    void receiveNotification(String message){
//        System.out.println(message);
//    }
//    public void notify(String message){
//        receiveNotification(message);
//    }
//
//
//}

//class Producer{
//
//    Mediator mediator;
//
//    void pro
//
//}
