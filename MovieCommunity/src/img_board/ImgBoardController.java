package img_board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.Article;
import qa.Qa;



@Controller
public class ImgBoardController {

	
	private Service service;

	
	
	public ImgBoardController(Service service) {
		this.service = service;
	}

	@RequestMapping(value = "/Image/insert.do")
	public String insert(Img img) {
		MultipartFile file = img.getFile();
String path = "C:\\Html5work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\"+ file.getOriginalFilename();
//폴더 경로로 들어가서 'img'폴더 반드시 만들것

		img.setPath("/img/"+file.getOriginalFilename());
		File f = new File(path);
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.addImg(img);
		return "redirect:/Image/list.do";
	}


	@RequestMapping(value = "/Image/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("Image/list");
		ArrayList<Img> data = (ArrayList<Img>) service.getAll();
		mav.addObject("data", data);
		return mav;
	}

	@RequestMapping(value = "/Image/write.do")
	public ModelAndView write(ImgBoard imgBoard) {
		ModelAndView mav = new ModelAndView("Image/write");
		ArrayList<ImgBoard> data = (ArrayList<ImgBoard>) service.writeContent(imgBoard);
		mav.addObject("data", data);
		return mav;
	}
	
	//�궘�젣遺�遺� �벑濡�? 

	@RequestMapping(value = "/Image/del.do")
	public String del(@RequestParam(value = "num")int num) {
		String path= service.getPath(num);
		File file = new File(path);
		if(file.exists()){
			System.out.println(path+" �궘�젣");
			file.delete();
		}
		service.delete(num);
		
		return "redirect:/Image/list.do";
	}

	//�닔�젙 �븯�뒗 遺�遺� �궡媛� 留뚮벉 
	@RequestMapping(value = "/Image/editInsert.do")
	public ModelAndView editInsert(@RequestParam(value="num")int num) {
		String path= service.getPath(num);
		File file = new File(path);
		ModelAndView mav = new ModelAndView("Image/editInsert");
		mav.addObject("im", path);
		return  mav;
	}
	
	@RequestMapping(value = "/Image/imgedit.do")
	public String edit(Img b) {
		service.imgedit(b);
		return "redirect:/Image/list.do";
	}	
	
	@RequestMapping(value = "/Image/read.do")
	public ModelAndView read(@RequestParam(value="num")int num) {		
		Img img = service.select(num);
		ArrayList<ImgBoard> data = (ArrayList<ImgBoard>) service.getBoard(num);
		ModelAndView mav = new ModelAndView("/Image/read");	
		mav.addObject("data", data);
		mav.addObject("img", img);		
		return mav;
	}

	
}

