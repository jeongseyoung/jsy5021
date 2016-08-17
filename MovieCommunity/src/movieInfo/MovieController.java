package movieInfo;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.Article;
import board.BoardService;
import board.Rep;

@Controller
public class MovieController {
	private MovieService service;

	public MovieController(MovieService service) {
		this.service = service;
	}

	@RequestMapping(value = "movieInfo/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("movieInfo/list");
		ArrayList<Movie> data = (ArrayList<Movie>) service.getAll();
		mav.addObject("Movie", data);
		return mav;
	}
	
	@RequestMapping(value = "movieInfo/write.do")
	public String write(Movie b) {
		service.addMovie(b);
		return "redirect:/movieInfo/list.do";
	}

	@RequestMapping(value = "movieInfo/editForm.do")
	public ModelAndView editForm(@RequestParam(value="num")int num) {
		Movie m =service.getMovie(num);
		ModelAndView mav = new ModelAndView("movieInfo/editForm");
		mav.addObject("m", m);
			
		return  mav;
	}
	
	@RequestMapping(value = "movieInfo/movieread.do")
	public ModelAndView read(@RequestParam(value="num")int num) {
		Movie a = service.getMovie(num);
		ModelAndView mav = new ModelAndView("movieInfo/read");		
		mav.addObject("Movie", a);
		return mav;
	}	
	
	
	@RequestMapping(value = "movieInfo/movieedit.do")
	public String edit(Movie m) {
		service.editMovie(m);
		return "redirect:/movieInfo/list.do";
	}
	
	
	@RequestMapping(value = "movieInfo/moviedel.do")
	public String del(@RequestParam(value="num")int num) {
		service.delMovie(num);
		return "redirect:/movieInfo/list.do";
	}
}
