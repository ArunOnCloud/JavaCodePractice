package lld.parkinglot;

import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ParkingLot {


    public static void main(String[] args) {

      ParkingLot parkingLot=new ParkingLot();
      parkingLot.setFloorList(ParkingLot.buildFloor());
      List<Spot> freeSpot=parkingLot.getFreeSpots();
      System.out.println("freeSpots size:"+freeSpot.size()+ " : "+freeSpot);
      Ticket ticket=parkingLot.assignFreeSpot(freeSpot.get(0),"vehicle_1");
      for(int i=0;i<100000;i++){

      }
      System.out.println("Ticket:"+ticket);
      int fare=parkingLot.calculateFare(ticket);
      parkingLot.makePayment(fare);
      parkingLot.freeSpot(ticket.getSpot());
      System.out.println("spot:"+ticket.getSpot().isFree());

    }
    List<Floor> floorList;
    FareRate fareRate=new FareRate();
    List<Integer> payments=new LinkedList<>();
    public List<Spot> getFreeSpots(){

        return floorList.stream()
                .flatMap((s)->s.getSpotList().stream())
                .filter((a)->a.isFree())
                .collect(Collectors.toList());
    }
    public Ticket assignFreeSpot(Spot spot,String vehicleId){
        if(spot.isFree()){
            spot.setVehicleId(vehicleId);
        }else{
          throw  new RuntimeException("Spot is already booked");
        }
        Ticket ticket=new Ticket("ticket_"+System.currentTimeMillis(),new Date(),vehicleId,spot);
        return ticket;
    }

    public int calculateFare(Ticket ticket){
        Date entryTime=ticket.getEntryTime();
        Date currentTime= new Date();
        long time= currentTime.getTime()-entryTime.getTime();
        Long hour= time/(1000L*3600);
        int intHour=hour.intValue() +1;
        return intHour* fareRate.getRate(ticket.getSpot().getSpotType());
    }
    public void makePayment(int amount){
        payments.add(amount);
    }
    public void freeSpot(Spot spot){
        spot.setFree();
    }


    static List<Floor> buildFloor(){
        List<Floor> floorList=new LinkedList<>();
        for(int i=0;i<10;i++){

            Floor floor=new Floor();
            floor.setFloorId("FLOOR_ID_"+i);
            List<Spot> spotList=new LinkedList<>();
            for(int j=0;j<100;j++){
                Spot spot=new Spot();
                spot.setSpotId("SP_ID_"+j);
                SpotType spotType;
                if(j%3 == 0){
                    spotType=SpotType.SMALL;
                }else if( j%3 ==1){
                    spotType=SpotType.MEDIUM;
                }else{
                    spotType=SpotType.LARGE;
                }
                spot.setSpotType(spotType);
                spot.setFloor(floor);
                spotList.add(spot);
            }
            floor.setSpotList(spotList);
            floorList.add(floor);
        }
        return  floorList;
    }
}
