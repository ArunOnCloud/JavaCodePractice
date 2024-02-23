package lld.parkinglot;

import java.util.*;

public class ParkingLotImpl {

    SpotManagement spotManagement;
    PriceManagement priceManagement;

    ParkingLotImpl(SpotManagement spotManagement,PriceManagement priceManagement){
        this.spotManagement = spotManagement;
        this.priceManagement = priceManagement;
    }

    public static void main(String[] args) throws Exception{
        SpotManagement spotManagement1 = new SpotManagement();
        String small = "SMALL";
        String medium = "MEDIUM";
        String large = "LARGE";
        spotManagement1.addSpot(new ParkingSpot(small));
        spotManagement1.addSpot(new ParkingSpot(small));
        spotManagement1.addSpot(new ParkingSpot(medium));
        spotManagement1.addSpot(new ParkingSpot(medium));
        spotManagement1.addSpot(new ParkingSpot(large));
        spotManagement1.addSpot(new ParkingSpot(large));
        PriceManagement priceManagement1 = new PriceManagement();
        priceManagement1.addRate(small,100);
        priceManagement1.addRate(medium,200);
        priceManagement1.addRate(large,300);
        ParkingLotImpl parkingLot = new ParkingLotImpl(spotManagement1,priceManagement1);
        List<ParkingSpot> parkingSpotList = parkingLot.getAvailableSpot(small);
        System.out.println(parkingLot.getAvailableSpot(small));
        ParkingTicket parkingTicket = parkingLot.bookSpot(parkingSpotList.get(0),new Vehicle(5000));
        Thread.sleep(3000);
        System.out.println("Parking ticket:"+ parkingTicket.ticketId+ " : spot:"+parkingTicket.parkingSpot);
        PaymentInstrument paymentInstrument = new PaymentInstrument();
        parkingLot.exitVehicle(parkingTicket,paymentInstrument);



    }
    List<ParkingSpot> getAvailableSpot(String type){

        return spotManagement.getAvailableSpots(type);
    }
    ParkingTicket bookSpot(ParkingSpot spot,Vehicle vehicle){
        if(spot.isOccupied == false){
            spot.isOccupied = true;
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.ticketId = UUID.randomUUID().toString();
        parkingTicket.vehicle = vehicle;
        parkingTicket.entryTime = new Date();
        parkingTicket.parkingSpot = spot;
        return parkingTicket;
    }
    void exitVehicle(ParkingTicket parkingTicket,PaymentInstrument paymentIntrument){
        int price = priceManagement.getPrice(parkingTicket);
        paymentIntrument.chargeAmount(price);
        spotManagement.freeSpot(parkingTicket.parkingSpot);

    }
}

class PriceManagement{

    Map<String,Integer> flatRateOfSpotPerHour = new HashMap<>();
    void addRate(String spotType,int price){
        flatRateOfSpotPerHour.put(spotType,price);
    }
    int getRate(String spotType){
        return flatRateOfSpotPerHour.get(spotType);
    }
    int getPrice(ParkingTicket parkingTicket){
        Date date = new Date();
        int hour =calculateHour(parkingTicket.entryTime,date);
        return getRate(parkingTicket.parkingSpot.type)* hour;

    }
    private int calculateHour(Date start,Date end){
        long time = end.getTime() - start.getTime();
        long seconds = time/1000L;
        Long hour = seconds/3600L ;
        if(seconds%3600L != 0){
            hour++;
        }
        return hour.intValue();
    }
}
class  PaymentInstrument{


    void chargeAmount(int amount){
        System.out.println("charged Amount:"+ amount);
    }
}
class  ParkingTicket{
    String ticketId;

    Date entryTime;
    Vehicle vehicle;

    ParkingSpot parkingSpot;

}
class  Vehicle{
    int rcNumber;
    Vehicle(int rc){
        this.rcNumber = rc;
    }

}


class SpotManagement{
       Map<String, List<ParkingSpot>> spots = new HashMap<>();


       void addSpot(ParkingSpot parkingSpot){
           List<ParkingSpot> parkingSpots = spots.getOrDefault(parkingSpot.type,new ArrayList<>());
           parkingSpots.add(parkingSpot);
           spots.put(parkingSpot.type,parkingSpots);
       }
       List<ParkingSpot> getAvailableSpots(String type){
           List<ParkingSpot> availableSpots = new ArrayList<>();
           List<ParkingSpot>  spotList = spots.getOrDefault(type,new ArrayList<>());
           for(ParkingSpot parkingSpot:spotList){
               if(!parkingSpot.isOccupied ){
                   availableSpots.add(parkingSpot);
               }
           }
           return availableSpots;
       }
       void freeSpot(ParkingSpot parkingSpot){
           parkingSpot.isOccupied = false;
       }

}
class  ParkingSpot{
    String id;
    boolean isOccupied;
    String type;
    ParkingSpot(String type){
        id = UUID.randomUUID().toString();
        this.type = type;
    }
}

