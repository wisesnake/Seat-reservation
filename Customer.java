package seat_reservation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer extends Main{
	private String id;
	private int pwd;
	
	private boolean curBook; //예약여부
	private int bookedSeatNo;
	private int bookedCustNo;
}
