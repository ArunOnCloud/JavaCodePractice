
import lombok.Builder;

import java.util.*;
/*

Implement a rate limiter that allows "x" number of requests in "y" seconds for
a customerId. Return true if request is allowed and false otherwise

Some customer may be willing to pay additional premium to purchase more credits so
that rate limit threshold can be increased.
How would you implement a solution to support a credit system

boolean rateLimit(int customerId)
 */

public class RateLimiterEpam {


    public static void main(String[] args) {
        RateLimiterEpam rateLimiterEpam = new RateLimiterEpam();

        Customer customer = new Customer();
        customer.name= "A";
        customer.customerId= "1";
        customer.requestPerSecond =2;
        rateLimiterEpam.addCustomer(customer);

        Customer customer2 = new Customer();
        customer2.name= "B";
        customer2.customerId= "2";
        customer2.requestPerSecond =200;

        rateLimiterEpam.addCustomer(customer2);


//        CustomerRequest customerRequest = CustomerRequest.builder().customerId(customer.customerId)
//                .request("Request1").timestamp(System.currentTimeMillis()).build();
        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer.customerId)
                .request("Request1")
                .timestamp(System.currentTimeMillis())
                .build()) );
        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer.customerId)
                .request("Request2")
                .timestamp(System.currentTimeMillis()+600L)
                .build()));
        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer.customerId)
                .request("Request3")
                .timestamp(System.currentTimeMillis()+600L)
                .build()));
        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer.customerId)
                .request("Request4")
                .timestamp(System.currentTimeMillis()+600L)
                .build()));

        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer2.customerId)
                .request("Request1")
                .timestamp(System.currentTimeMillis())
                .build()) );
        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer2.customerId)
                .request("Request2")
                .timestamp(System.currentTimeMillis()+600L)
                .build()));
        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer2.customerId)
                .request("Request3")
                .timestamp(System.currentTimeMillis()+600L)
                .build()));
        System.out.println(rateLimiterEpam.isAllowed(CustomerRequest.builder().customerId(customer2.customerId)
                .request("Request4")
                .timestamp(System.currentTimeMillis()+600L)
                .build()));

    }



    List<Customer> customers= new LinkedList<>();

    Map<String,Integer> customerRequestThresholdMap= new HashMap<>();
    Map<String,List<CustomerRequest>>  requestLogs= new HashMap<>();

    Map<String,RequestLogManager> customerRequestLogManager = new HashMap<>();
    public void addCustomer(Customer customer){
        customerRequestThresholdMap.put(customer.customerId,customer.requestPerSecond);
        customers.add(customer);
        customerRequestLogManager.put(customer.customerId,new RequestLogManager());
    }

    /*


    1,1
    20,2
    31,3
    35,4
     */
    boolean isAllowed(CustomerRequest request){
        // TO DO

        RequestLogManager requestLogManager= customerRequestLogManager.get(request.customerId);
        int threshold =customerRequestThresholdMap.get(request.customerId);
        long oneSecondInMillis = 1000l;
        int prevCount = requestLogManager.getCountAtTime(request.timestamp-oneSecondInMillis -1);
        int currentCount = requestLogManager.getCountAtTime(request.timestamp);
        System.out.println("current time:"+ request.timestamp);
        if( currentCount - prevCount >= threshold){
            return false;
        }else{
            requestLogManager.addRequest(request);
            return true;
        }
    }

}


class RequestLogManager{
    TreeMap<Long,CustomerRequest> requestMap= new TreeMap<>();

    TreeMap<Long,Integer> cumulativeRequestCount = new TreeMap<>();
    int cumulativeCount=0;

    Optional<CustomerRequest> getRequestBeforeTSeconds(long time){

       var request = requestMap.ceilingEntry(time);
       if(request != null){
           return  Optional.of(request.getValue());
       }
       return Optional.empty();
    }
    Integer getCountAtTime(long time){
        var entry = cumulativeRequestCount.floorEntry(time);
        if(entry == null){
            return 0;
        }else{
            return entry.getValue();
        }
    }
    void addRequest(CustomerRequest customerRequest){
        long time = customerRequest.timestamp;
        cumulativeCount++;
        cumulativeRequestCount.put(time,cumulativeCount);
    }
    void removeDataBeforeTime(long time){
       // cumulativeRequestCount.firstEntry();
    }
}


class Customer{
    String name;
    String customerId;
    int requestPerSecond;

}
@Builder
class CustomerRequest{

    String customerId;
    String request;
    long timestamp; // time in milli seconds
}
