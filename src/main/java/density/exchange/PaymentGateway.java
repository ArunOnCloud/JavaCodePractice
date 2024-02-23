package density.exchange;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class PaymentGateway {

    //List<PaymentBanks>

    Map<PaymentType, Set<PaymentBanks>> paymentTypeBankMapping = new HashMap<>();

    Set<PaymentBanks> clients=new HashSet<>();

    Map<PaymentBanks,Double> distributionMap=new HashMap<>();

    void addClient(PaymentBanks banks){
         if(!clients.contains(banks)){
             clients.add(banks);
         }
    }

    boolean removeClients(PaymentBanks bank){
        return clients.remove(bank);
    }

    boolean hasSupportedPaymentModes(PaymentBanks banks,PaymentType paymentType){
        return paymentTypeBankMapping.get(paymentType).contains(banks);
    }


     void addPaymode(PaymentType paymentType,PaymentBanks bank){
         Set<PaymentBanks> set=null;
         set=paymentTypeBankMapping.getOrDefault(paymentType,new HashSet<>());
         set.add(bank);
         paymentTypeBankMapping.put(paymentType,set);

     }
     boolean removePaymode(PaymentType paymentType,PaymentBanks bank){
        return paymentTypeBankMapping.get(paymentType).remove(bank);
     }



     void setDistribution(int percent,PaymentBanks banks){
        int n= distributionMap.size();
        //int remaining
         distributionMap.put(banks,(double)percent);
     }

     boolean makePayment(int amount,PaymentType paymentType,PaymentDetails paymentDetails) throws Exception{

        Set<PaymentBanks> paymentBanks= paymentTypeBankMapping.get(paymentType);
        if(paymentBanks == null){
            throw  new Exception("payment Type"+paymentType +" not supported");
        }

        if(validatePaymentDetails(paymentType,paymentDetails)){
            PaymentBanks paymentBanks1=getPaymentBank(paymentBanks.stream().collect(Collectors.toList()), paymentType);
            return paymentBanks1.makePayment((double) amount,paymentType);
        }
        return false;

     }

     boolean validatePaymentDetails(PaymentType paymentType,PaymentDetails paymentDetails){
        // factory for getting validator
        return true;
     }
     PaymentBanks getPaymentBank(List<PaymentBanks> banks, PaymentType paymentType){
        // distribution ,banklist, paymenttype  return payment
         //
        return banks.get(0);

     }

}


