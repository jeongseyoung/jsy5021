package reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.Rep;
import movieInfo.Movie;

@Controller
public class ReservController {
	private ReservService service;	
	
	public ReservController(ReservService service) {		
		this.service = service;
	}

	@RequestMapping(value = "/reservation/reserv.do")
	public String reservation(Reservation r) {		
		service.addReserv(r);		
		return "reservation/form";
	}
	
	@RequestMapping(value = "/reservation/list.do")
	public ModelAndView list(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		String userid = (String) session.getAttribute("id");
		ModelAndView mav = new ModelAndView("reservation/list");
		ArrayList<Reservation> list = (ArrayList<Reservation>) service.getList(userid);
		mav.addObject("data", list);
		return mav;
	}

}
