package project.pc.mobile.picture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pc/picture/")
public class PictureController {
	
	@RequestMapping("pictureMain")
	public String pictureMainFirst() {
			
		return "/pc/picture/pictureList";
			
	}
	
	@RequestMapping("pictureInsert")
	public String insertPicture() {
			
		return "/pc/picture/pictureInsert";
			
	}

}
