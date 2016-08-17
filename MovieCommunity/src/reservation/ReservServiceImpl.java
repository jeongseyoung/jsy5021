package reservation;

import java.util.ArrayList;

public class ReservServiceImpl implements ReservService{
	private ReservDao dao;
	
	public ReservServiceImpl(ReservDao dao) {		
		this.dao = dao;
	}

	@Override
	public void addReserv(Reservation r) {
		// TODO Auto-generated method stub
		dao.insert(r);
	}

	@Override
	public ArrayList<Reservation> getList(String userid) {
		// TODO Auto-generated method stub
		return dao.select(userid);
	}

}
