package reservation;

public class Reservation {
	private int num;
	private String movie;
	private String userid;
	private String theater;
	private String reservday;
	private String running;
	private String people;
	private String seat;
	private String pay;
	
	public Reservation() {		
	}

	public Reservation(int num, String movie, String userid, String theater, String reservday, String running, String people,
			String seat, String pay) {
		this.num = num;
		this.movie = movie;
		this.userid = userid;
		this.theater = theater;
		this.reservday = reservday;
		this.running = running;
		this.people = people;
		this.seat = seat;
		this.pay = pay;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getReservday() {
		return reservday;
	}

	public void setReservday(String reservday) {
		this.reservday = reservday;
	}

	public String getRunning() {
		return running;
	}

	public void setRunning(String running) {
		this.running = running;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "Reservation [num=" + num + ", movie=" + movie + ", userid=" + userid + ", theater=" + theater + ", reservday="
				+ reservday + ", running=" + running + ", people=" + people + ", seat=" + seat + ", pay=" + pay + "]";
	}	
	
}
