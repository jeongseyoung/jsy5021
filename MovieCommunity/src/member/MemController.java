package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import member.Member;
import member.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {
	Service service;

	public void setService(Service service) {
		this.service = service;
	}

	
	@RequestMapping(value = "member/form.do")
	public String form() {
		return  "member/form";
	}

	@RequestMapping(value = "/member/insert.do")
	public String insert(Member m) {
		service.join(m);
		return  "member/login";
	}	

	@RequestMapping(value = "/member/login.do")
	public ModelAndView login(Member m, HttpSession session,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		boolean str = service.login(m.getId(), m.getPwd());
		
		if(str){
			session = req.getSession();
			session.setAttribute("id", m.getId());
			mav.setViewName("member/main");			
		}else{
			mav.addObject("member", str);
			mav.setViewName("member/login");			
		}
		return mav;
	}

	@RequestMapping(value = "/member/logout.do")
	public String logout(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "member/login";
	}

	@RequestMapping(value = "/member/editMember.do")
	public ModelAndView editForm(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		Member m = service.getMember(id);
		ModelAndView mav = new ModelAndView("member/editForm");
		mav.addObject("m", m);
		return mav;
	}

	@RequestMapping(value = "/member/edit.do")
	public String edit(Member m, HttpSession session, HttpServletRequest req) {
		service.editMember(m);
		session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "member/login";
	}

	@RequestMapping(value = "/member/del.do")
	public String del(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		return "redirect:/member/logout.do";
	}

}
