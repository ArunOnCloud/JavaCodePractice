package lld.parkinglot;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Floor {
    private String floorId;
    private List<Spot> spotList;


    List<Spot> getFreeSpots(){
        List<Spot> freeSpot=new LinkedList<>();
        return freeSpot;
    }



}
