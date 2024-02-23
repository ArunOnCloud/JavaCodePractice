package lld.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class FareRate {

    Map<SpotType,Integer> fareRate=new HashMap<>();
    public FareRate(){
        fareRate.put(SpotType.SMALL,100);
        fareRate.put(SpotType.MEDIUM,150);
        fareRate.put(SpotType.LARGE,200);
    }

    public Integer getRate(SpotType spotType){
        return fareRate.get(spotType);
    }
}
