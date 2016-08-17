package reservation;

import java.util.ArrayList;

public interface ReservDao {
	void insert(Reservation r);
	ArrayList<Reservation> select(String userid);
}
