package lld.parkinglot;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"floor"})
public class Spot {
    private String spotId;
    private SpotType spotType;
    private String vehicleId;
    private Floor floor;
    public boolean isFree(){
        return vehicleId == null || vehicleId.length() == 0 ;
    }

    public void setFree(){
        vehicleId="";
    }
    public String getVehicleId(){
        return  vehicleId;
    }
}
