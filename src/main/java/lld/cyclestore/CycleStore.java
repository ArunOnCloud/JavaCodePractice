package lld.cyclestore;

import lombok.Builder;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*

Design a cycle store
1) Owner should be able to add the cycle
2) Owner should be able to add payment
3) Owner should be able to sell cycle
4) Owner should be able to get total sale based on date
5) Owner should be able to get sale

 */
public class CycleStore {

    Inventory inventory;

    OrderManagementSystem oms;

    void addCycle(Product product){
        inventory.addProduct(product);

    }
    void sellProduct(Product product,Payment payment){
        if( inventory.containsProduct(product)){
            oms.recordSale(Sale.builder().date(new Date())
                    .amount(payment.getAmount()).
                    paymentId(payment.getTransactionId())
                    .build());

        }else{
            throw  new RuntimeException("Product already purchased");
        }
    }
    List<Sale> getTotalSale(){
     return List.of();
    }
}

class OrderManagementSystem{

    List<Sale> sales= new LinkedList<>();
    AtomicInteger atomicInteger = new AtomicInteger();

    Inventory inventory ;
    public void recordSale(Sale sale){
        sale.orderId = getUniqId();
        sales.add(sale);
       // inventory.removeProduct();

    }

    private  String getUniqId(){
        return "order_id_"+ atomicInteger.incrementAndGet();
    }


}

class  Inventory{
    List<Product> productList;

    void addProduct(Product product){
        productList.add(product);
    }
    void removeProduct(Product product){

    }
    boolean containsProduct(Product product){
        for(Product product1: productList){
            if(product1.getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }
}


@Builder
class Sale{
    String orderId;
    String amount;
    String userId;
    Date date;
    String paymentId;
    String productId;
}

interface  Payment{
    String paymentMethod();
    String getAmount();
    String getTransactionId();
}

interface Product{
    String getProductName();
    String getBuyingCost();
    String getSellingCost();
    String getId();
}
class Cycle implements Product{

    @Override
    public String getProductName() {
        return null;
    }

    @Override
    public String getBuyingCost() {
        return null;
    }

    @Override
    public String getSellingCost() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}

