package ConceptImplementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PublisherSubscriber {

    Map<String, List<String> > topicMessage;
    Map<String, List<Runnable> > topicSubscriber;

    public static void main(String[] args)throws Exception{
        PublisherSubscriber publisherSubscriber=new PublisherSubscriber();

        publisherSubscriber.subscribe("abc", new Runnable() {
            @Override
            public void run() {
                System.out.println(" abc subscriber");
            }
        });
    }

    void subscribe(String topic,Runnable action){
        List<Runnable> list=topicSubscriber.getOrDefault(topic, new LinkedList<Runnable>() );
        list.add(action);
        topicSubscriber.put(topic,list);
    }
    void addMessage(String topic,String message) throws Exception{
        if(topicMessage.containsKey(topic)){
            topicMessage.get(topic).add(message);
            for(Runnable runnable:topicSubscriber.get(topic)){
                Thread thread=new Thread(runnable);
                thread.start();
            }
        }else{
            throw new Exception("Topic does not exist");
        }
    }




}
