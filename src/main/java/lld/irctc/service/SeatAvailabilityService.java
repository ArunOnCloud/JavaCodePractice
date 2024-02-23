package lld.irctc.service;

import lld.irctc.dto.TrainEntity;

import java.util.Date;
import java.util.List;

public class SeatAvailabilityService {

    List<TrainEntity> getAvailableSeats(Date date){
      return null;
    }
    void lockSeat(Date date,String trainId){

    }
    void unlockSeat(Date date,String trainId){

    }

    void decrementSeatAvailabilityCount(Date date,String trainId){

    }
    void incrementSeatAvailabilityCount(Date date,String trainId){

    }
}
