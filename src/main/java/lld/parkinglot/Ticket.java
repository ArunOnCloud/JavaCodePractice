package lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Ticket {
    private String ticketId;
    private Date entryTime;
    private String vehicleId;
    private Spot spot;
}
