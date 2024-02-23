import java.util.HashMap;
import java.util.Map;

public class SearsInterview {


    /*
    design cache

    LRU
    data st
    1) have capacity
      if exceed capacity remo


      c = 3
      1,6
      2,7
      3,9
      4,10

      2,7
      3,9
      4,10

      get 1 value 6
      4,10
      int this case 2 should be removed


      LRUCache(int capacity)


     */

    public static void main(String[] args) {
//        LRUCache lruCache=new LRUCache(3);
//        lruCache.put(1,6);
//        lruCache.put(2,7);
//        lruCache.put(3,9);
//        lruCache.put(4,10);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
//        System.out.println("map:"+lruCache.map);
//        lruCache.put(19,30);
//        System.out.println("map:"+lruCache.map);
//        System.out.println(lruCache.get(4));
//        System.out.println("map:"+lruCache.map);
//        LRUCache lruCache=new LRUCache(2);
//        lruCache.put(2,10);
//        lruCache.put(1,7);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3,9);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4,12);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));

        LRUCache lruCache=new LRUCache(1);
        System.out.println(lruCache.get(23));
        lruCache.put(12,19);
        lruCache.put(15,23);
        System.out.println(lruCache.get(12));
        lruCache.put(1,9);
        lruCache.put(4,6);
        lruCache.put(5,2);
        System.out.println(lruCache.get(15));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(5));






    }
}

class LRUCache{

    Map<Integer,Node> map= new HashMap<>();
    int capacity=0;
    Node head;
    Node tail;

    LRUCache(int capacity){
        this.capacity=capacity;
    }

    int get(int key){

        if(map.containsKey(key)){
            int value= map.get(key).value;
            handleBalancing(map.get(key));
            return value;
        }

        return -1;
        //throw new Exception("key does not exist");
    }



    void put(int key,int value){
        if(map.containsKey(key)){

            Node node= map.get(key);
            node.value=value;
            handleBalancing(node);

        }else{
            Node node= new Node(key,value);
            map.put(key,node);
            if( head == null){
                head=node;
                tail=node;
            }else{
                tail.right=node;
                node.left=tail;
                tail=node;
            }

        }

        if(map.size() >capacity){
            Node node= head;
            head= node.right;
            int key1=node.key;
            head.left=null;
            node.right= null;
            map.remove(key1);
        }

    }

    private void handleBalancing(Node node) {
        if(head == tail){
          //  handleTail(node);
        }else
        if(node == head){
            handleHead(node);
        }else if( node == tail){
            handleTail(node);
        }else{
            handleMiddle(node);
        }
    }

    void handleMiddle(Node node){
        Node left=node.left;
        Node right=node.right;
        node.left=tail;
        node.right=null;
        left.right=right;
        right.left=left;

    }
    void handleHead(Node node){

        Node right=node.right;
        tail.right=node;
        node.left= tail;
        head=right;
        head.left=null;
        node.right= null;
        tail=node;
    }

    void handleTail(Node node){
        //Node left=node.left;
        tail.right = node;
        node.left =tail;
        tail=node;

    }


}
class Node {
    int key;
    int value;
    Node left;
    Node right;

    Node(int key,int value){
        this.key=key;
        this.value = value;
    }
}


