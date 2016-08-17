package reservation;

import java.util.ArrayList;

public interface ReservService {
	void addReserv(Reservation r);
	ArrayList<Reservation> getList(String userid);
}
