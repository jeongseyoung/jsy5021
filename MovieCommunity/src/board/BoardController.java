package board;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {
	private BoardService service;

	public BoardController(BoardService service) {
		this.service = service;
	}

	@RequestMapping(value = "/board/list.do")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value="nowPage")int num) {
		//ModelAndView mav = new ModelAndView("board/list");		
		int nowPage= num;
		
		if(nowPage==0){
			nowPage=1;
		}		
		
		
		ModelAndView mav = new ModelAndView();
		/*ArrayList<Article> data = (ArrayList<Article>) service.getAll();
		mav.addObject("articles", data);*/
		
		try{			
			Listitem vo = service.getContentList(nowPage);
			mav.addObject("listvo", vo);
			mav.setViewName("board/list");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/board/write.do")
	public String write(Article b) {
		service.addArticle(b);
		return "redirect:/board/list.do?nowPage=" + 0;
	}
	
	@RequestMapping(value = "/board/writeRep.do")
	public String writeRep(Rep r,@RequestParam(value="num")int num) {
		service.addRep(r, num);
		return "redirect:/board/read.do?num=" + num;
	}	

	@RequestMapping(value = "/board/editForm.do")
	public ModelAndView editForm(@RequestParam(value="num")int num) {
		Article m =service.getArticle(num);
		ModelAndView mav = new ModelAndView("board/editForm");
		mav.addObject("m", m);
			
		return  mav;
	}	
	
	@RequestMapping(value = "/board/read.do")
	public ModelAndView read(@RequestParam(value="num")int num) {
		ArrayList<Rep> r = service.allRep(num);
		Article a = service.getArticle(num);
		ModelAndView mav = new ModelAndView("/board/read");		
		mav.addObject("articles", a);
		mav.addObject("rep", r);
		return mav;
	}
	
	@RequestMapping(value = "/board/boardedit.do")
	public String edit(Article b) {
		service.editArticle(b);
		return "redirect:/board/list.do?nowPage="+0;
	}
	
	@RequestMapping(value = "/board/boarddel.do")
	public String del(@RequestParam(value="num")int num) {
		service.delArticle(num);
		return "redirect:/board/list.do?nowPage="+0;
	}
}




