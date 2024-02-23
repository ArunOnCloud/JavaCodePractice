package lld.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    Map<Item,Integer> itemCounts=new HashMap<>();
    Map<String,Integer> itemPricePerUnit= new HashMap<>();

    void selectItem(String itemId){

    }
    void payPrice( int amount){
    System.out.println("paying price");
    }

    void dispenseItem(){
        System.out.println("dispensing item");
    }

    void addItem(){

    }

}
