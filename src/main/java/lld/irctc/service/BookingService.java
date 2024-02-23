package lld.irctc.service;

import lld.irctc.dto.TrainEntity;
import lld.irctc.repo.BookingRepo;

import java.util.Date;

public class BookingService {

    SeatAvailabilityService seatAvailabilityService;
    BookingRepo bookingRepo;
    String bookseat(String requestId, String customerId, String trainId, Date date){

        try{
            seatAvailabilityService.lockSeat(date,trainId);
            String bookingId = bookingRepo.createBooking(date,trainId,customerId);
            seatAvailabilityService.decrementSeatAvailabilityCount(date,trainId);
            return bookingId;
        } catch (Exception exception){

        }

        //seatAvailabilityService.

    return "";
    }
}
