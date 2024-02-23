import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class UnravelLru<K,V> {



    Map<K,CacheNode> map=new HashMap<>();
    int capacity;

    UnravelLru(int capacity){
        this.capacity = capacity;
    }

    CacheNode head;
    CacheNode tail;




    public void put(K key,V value){
        CacheNode cacheNode = map.get(key);
        if( cacheNode != null){
            cacheNode.val= value;
        }else {
            cacheNode = new CacheNode(key,value);
            map.put(key,cacheNode);
            if( head == null ){
                head = cacheNode;
                tail = cacheNode;
            }
        }
        readjust(cacheNode);
        if( map.size() > capacity){
            evictEntry();
        }

    }

    void evictEntry(){

        CacheNode lastNode= tail;
        CacheNode prev = tail.prev;
        if(prev != null){
            prev.next = null;
            tail= prev;
            K key = (K)lastNode.key;
            map.remove(key);
        }


    }
    void readjust(CacheNode node){
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        if(head != node){
            node.prev = null;
            node.next = head;
            head.prev= node;
            head = node;
            if(prev != null){
                prev.next= next;
            }
            if( next != null){
                next.prev= prev;
            }
        }
    }

    public  V get(K key){

        CacheNode cacheNode = map.get(key);
        if(cacheNode != null){
            V val = (V)cacheNode.val;
            readjust(cacheNode);
            return val;
        }else{
            throw  new RuntimeException("Value is not present");
        }
    }
}
class CacheNode<K,V>{
    K key;
    V val;
    CacheNode next;
    CacheNode prev;

    CacheNode(K k,V v){
        this.key= k;

        this.val= v;
    }
}
