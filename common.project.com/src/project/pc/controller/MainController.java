package project.pc.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import project.common.config.MsgConstants;
import project.common.config.ServiceConfig;
import project.common.controller.CommonController;
import project.common.exception.BizException;
import project.common.util.FileUtil;
import project.common.util.WebUtil;

@Controller
@RequestMapping("/pc/main/")
public class MainController extends CommonController 
{

	@Autowired ServiceConfig serviceConfig;
	
	/**
	 * MYFEED
	 * VER 1.0
	 * 처음 실행되는 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws BizException
	 */
	@RequestMapping("frame")	
	public ModelAndView frame(HttpServletRequest request, HttpServletResponse response) throws BizException
	{
		return new ModelAndView("/pc/frame");
	}
	
	@RequestMapping("top")	
	public ModelAndView top(HttpServletRequest request, HttpServletResponse response) throws BizException
	{		
		return new ModelAndView("/pc/top");
	}
	
	@RequestMapping("left")	
	public ModelAndView left(HttpServletRequest request, HttpServletResponse response) throws BizException
	{		
		return new ModelAndView("/pc/left");
	}
	
	@RequestMapping("bottom")	
	public ModelAndView bottom(HttpServletRequest request, HttpServletResponse response) throws BizException
	{		
		return new ModelAndView("/pc/bottom");
	}
	
	@RequestMapping("main")	
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws BizException
	{		
		return new ModelAndView("/pc/main/main");
	}
	
	@RequestMapping("upload")
	public ModelAndView upload(MultipartHttpServletRequest request, HttpServletResponse response) throws BizException
	{		
		MultipartFile file = request.getFile("file");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/pc/picture/pictureList");
		if(file.isEmpty() == false)
		{
			String userid = (String)request.getSession().getAttribute("USER_ID");
			String fileName = file.getOriginalFilename();
			String ext = fileName.substring(fileName.lastIndexOf("."));
			fileName = UUID.randomUUID().toString() + ext;
			if(userid != null)
			{
				try
				{
					String filePath = serviceConfig.getNasPath() + "\\" + serviceConfig.getOriginalImagePath().replace("/", "\\")
							+ userid + "\\" + WebUtil.getDate();
					File f = new File(filePath);
					if(f.exists() == false)
					{
						f.mkdirs();
					}
					f = null;
					
					f = new File(filePath + "\\" + fileName);
					file.transferTo(f);
					f = null;
					
					String thumb_path = serviceConfig.getNasPath() + "\\" + serviceConfig.getThumbnailImagePath().replace("/", "\\") 
							+ userid + "\\" + WebUtil.getDate();
					f = new File(thumb_path);			
					if(f.exists() == false)
					{
						f.mkdirs();
					}
					f = null;
     		
					FileUtil.createThumbnail(filePath + "\\" + fileName, thumb_path + "\\" + fileName, 280);
					
					String imagePath = "/" + serviceConfig.getThumbnailImagePath() + userid + "/" + WebUtil.getDate() + "/" + fileName;

					mav.addObject("imagepath", imagePath);
				}
				catch(Exception e) 
				{
					throw new BizException(MsgConstants.MAIN_SYSTEM, MsgConstants.UPLOAD_ERROR + "/" + e.getMessage());
				}
			}
		}
		
		return mav;
	}
}