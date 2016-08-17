package qa;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class QaController {
	private QaService service;
	
	public QaController(QaService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/qa/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("qa/list");
		ArrayList<Qa> data = (ArrayList<Qa>) service.getAll();
		mav.addObject("qas", data);
		return mav;
	}
	
	@RequestMapping(value = "/qa/write.do")
	public String write(Qa b) {
		service.addQa(b);
		return "redirect:/qa/list.do";
	}

	

	@RequestMapping(value = "/qa/editForm.do")
	public ModelAndView editForm(@RequestParam(value="num")int num) {
		Qa m =service.getQa(num);
		ModelAndView mav = new ModelAndView("qa/editForm");
		mav.addObject("m", m);
			
		return  mav;
	}	
	
	@RequestMapping(value = "/qa/writeRep.do")
	public String writeQaRep(QaRep r,@RequestParam(value="num")int num) {
		service.addQaRep(r, num);
		return "redirect:/qa/read.do?num=" + num;
	}
	
	@RequestMapping(value = "/qa/read.do")
	public ModelAndView read(@RequestParam(value="num")int num) {
		ArrayList<QaRep> r = service.allQaRep(num);
		Qa a = service.getQa(num);		
		ModelAndView mav = new ModelAndView("qa/read");		
		mav.addObject("qas", a);	
		mav.addObject("qarep", r);
		return mav;
	}	
	
	@RequestMapping(value = "/qa/qaedit.do")
	public String edit(Qa b) {
		service.editQa(b);
		return "redirect:/qa/list.do";
	}
	
	@RequestMapping(value = "/qa/qadel.do")
	public String del(@RequestParam(value="num")int num) {
		service.delQa(num);
		return "redirect:/qa/list.do";
	}
	
}
