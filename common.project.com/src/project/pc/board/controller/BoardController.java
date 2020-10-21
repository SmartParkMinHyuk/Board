package project.pc.board.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import project.common.exception.BizException;
import project.pc.board.common.pagebar;
import project.pc.board.model.service.BoardService;

@Controller
@RequestMapping("/pc/board/")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/insert")
	public String insert() {
		
		return "/pc/board/boardInsert";
	}
	
	@RequestMapping("sessiontest")	
	public String sessiontest(){
		return"/index";
	}
	
	@RequestMapping("Detail")	
	public ModelAndView goToDetail(HttpServletRequest request, HttpServletResponse response) throws BizException 
	{
		return new ModelAndView("/pc/board/boardDetail");
	}
	
	@RequestMapping("Update")	
	public ModelAndView goToUpdate(HttpServletRequest request, HttpServletResponse response) throws BizException 
	{
		return new ModelAndView("/pc/board/boardUpdate");
	}
	
	@RequestMapping("UpdateCompelete")	
	public ModelAndView goToUpateCompelete(HttpServletRequest request, HttpServletResponse response) throws BizException 
	{
		return new ModelAndView("/index");
	}
	
	
	// List 및 Page 동시처리
	@RequestMapping("/mainPage")
	public String selectBoardList(
				@RequestParam(value="cPage", required=false, defaultValue="1")
				int cPage, Model model) {
		
		// 한 페이지 당 게시글 수
		int numPerPage=15; // limit 역할
		
		int renew = (cPage-1) * numPerPage;
		
		Map<String, Integer> paging = new HashMap<>();
		paging.put("renew", renew);
		paging.put("numPerPage", numPerPage);
		
		System.out.println("cPage 값 : " + cPage);
		System.out.println("numPerPage 값 : " + numPerPage);
		
		// 1. 현재 페이지 게시글 목록 가져오기
		// VO를 안쓰는 방법
		// board객체를 통채로 받을수 없다.
		List<Map<String, String>> holist
			= boardService.boardPageList(paging);
		
		System.out.println("cPage 값 다녀왔습니다. : " + cPage);
		
		// 2. 페이지 계산을 위한 총 페이지 갯수
		int totalContents = boardService.boardTotalContents();
		
		// 3.페이지 HTML 생성
		String pageBar = pagebar.getPageBar(totalContents, cPage, numPerPage, "mainPage");
		
		model.addAttribute("holist", holist);
		model.addAttribute("totalContents", totalContents);
		model.addAttribute("numPerPage", numPerPage);
		model.addAttribute("pageBar", pageBar);
		
		System.out.println("holist : " + holist);
		
		return "/pc/board/boardList"; 
	}

	// List 페이지 더보기 처리 
		@RequestMapping("/mainPage2")
		public String selectBoardList2(
					@RequestParam(value="cPage", required=false, defaultValue="1")
					int cPage, Model model) {
			
			// 한 페이지 당 게시글 수
			int numPerPage=15; // limit 역할
			
			int renew = (cPage-1) * numPerPage;
			
			Map<String, Integer> paging = new HashMap<>();
			paging.put("renew", renew);
			paging.put("numPerPage", numPerPage);
			
			System.out.println("cPage 값 : " + cPage);
			System.out.println("numPerPage 값 : " + numPerPage);
			
			// 1. 현재 페이지 게시글 목록 가져오기
			// VO를 안쓰는 방법
			// board객체를 통채로 받을수 없다.
			List<Map<String, String>> holist
				= boardService.boardPageList(paging);
			
			System.out.println("cPage 값 다녀왔습니다. : " + cPage);
			
			// 2. 페이지 계산을 위한 총 페이지 갯수
			int totalContents = boardService.boardTotalContents();
			
			// 3.페이지 HTML 생성
			String pageBar = pagebar.getPageBar(totalContents, cPage, numPerPage, "mainPage");
			
			model.addAttribute("holist", holist);
			model.addAttribute("totalContents", totalContents);
			model.addAttribute("numPerPage", numPerPage);
			model.addAttribute("pageBar", pageBar);
			
			System.out.println("holist : " + holist);
			
			return "/pc/board/boardList2"; 
		}

		
		
		
		
		
		
		
		
		// List 페이지 더보기 처리 
		@ResponseBody
		@RequestMapping("/more")
		public void more(HttpServletRequest request, HttpServletResponse response,
							@RequestParam(value = "cPage", required=false, defaultValue="0")
							int cPage) throws IOException {
			
			System.out.println("p : " + cPage);
		
			int numPerPage = 15;
			int renew = (cPage-1) * numPerPage;
			
			System.out.println("renew" + renew); 
			System.out.println("numperpage" + numPerPage);
			 
			Map<String, Integer> paging = new HashMap<>(); 
			
			paging.put("renew", renew);
			paging.put("numPerPage", numPerPage);
			 
			List<Map<String, String>> holist = boardService.boardPageList(paging);
			
			System.out.println("holist가 무엇일까요?   " + holist);
			
			System.out.println(holist);
			
			PrintWriter out;
			
			 try {
				out = response.getWriter();

	
			 JSONObject json = new JSONObject();
			 

				json.put("holist", holist);
				
		         out.print(json);
		         out.flush();
		         out.close();
		         
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

			
		}
		
		// List 페이지 더보기 처리 
		@RequestMapping("/moresearch")
		public String moresearch(Model model,
										@RequestParam String keyword) throws IOException {
			
			System.out.println("keyword : " + keyword);
			
			
			model.addAttribute("keyword", keyword);
			
			return "/pc/board/boardList3";
		}
		
		// List 페이지 더보기 처리 
				@ResponseBody
				@RequestMapping("/moresearch2")
				public void moresearch2(HttpServletRequest request, HttpServletResponse response,
									@RequestParam(value = "cPage", required=false, defaultValue="0")int cPage, 
									@RequestParam String keyword) throws IOException {
					
					System.out.println("p : " + cPage);
					System.out.println("keywod : " + keyword);
					
					int numPerPage = 15;
					int renew = (cPage-1) * numPerPage;
					
					System.out.println("renew" + renew); 
					System.out.println("numperpage" + numPerPage);
					 
					HashMap<String, Object> pagingSearch = new HashMap<>();
					pagingSearch.put("renew", renew);
					pagingSearch.put("numPerPage", numPerPage);
					pagingSearch.put("keyword", keyword);
					
					List<Map<String, String>> holist = boardService.search(pagingSearch);
					
					System.out.println("holist : " + holist);
					
					System.out.println(holist);
					
					PrintWriter out;
					
					 try {
						out = response.getWriter();

			
					 JSONObject json = new JSONObject();
					 

						json.put("holist", holist);
						json.put("keyword", keyword);
				         out.print(json);
				         out.flush();
				         out.close();
				         
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        

					
				}
	
		
		
		
		
		
		
		
		
		
		
		
		
	//한개 선택 했을 때 Detail 페이지로 넘거어가기
	@RequestMapping("/select")
	public String hospotBoardSelectOne(@RequestParam int no, Model model) {
		
		System.out.println("no : "+  no);
		
		Map<String, String> h = boardService.boardSelectOne(no);
		
		System.out.println("h : " + h);
		
		model.addAttribute("h", h);
		
		return "/pc/board/boardDetail";
	}
	
	// 글 삽입하기
	@RequestMapping("/boardInsert")
	public String boardInsert(@RequestParam String bTitle,
							  @RequestParam String bContent, 
							  @RequestParam(defaultValue=" ") String imgpath, Model model, HttpSession session) throws Exception {
		
		System.out.println(session.getAttribute("USER_NICKNAME"));
		
		String nicname = String.valueOf(session.getAttribute("USER_NICKNAME"));
		
		Map<String, String> boardMap = new HashMap<>();
		boardMap.put("bTitle", bTitle);
		boardMap.put("bContent", bContent);
		boardMap.put("nicname", nicname);
		boardMap.put("imgpath", imgpath);
		
		int result;	
		
		 try {
			
		result = boardService.insert(boardMap);
		
		} catch(Exception e) {
			
			throw new Exception("게시물 등록 오류!");		
		}
		
		// List 갱신 및 알람창 설정
	      String loc = "/pc/board/mainPage";
	      String msg = "";
	      
	      if(result > 0) {
	         msg = "게시글 등록 성공!";
	         loc = "/pc/board/mainPage";
	         
	      } else {
	         msg = "게시글 등록 실패!";
	      }
	      
	      model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/hotmsg";
	
	}
	
	@RequestMapping("/Delete")
	public String delete(@RequestParam int no, Model model) throws Exception {
		
		int result;	
		
		System.out.println("no값이 잘들어가나요?" + no);
		
		try {
			
		result = boardService.delete(no);
		
		} catch(Exception e) {
			
			throw new Exception("게시물 등록 오류!");		
		}
		
		System.out.println("result 값이 잘들어가나요?" + result);
		// List 갱신 및 알람창 설정
	      String loc = "/pc/board/mainPage";
	      String msg = "";
	      
	      if(result > 0) {
	         msg = "게시글이 삭제 되었습니다.";
	         loc = "/pc/board/mainPage";
	         
	      } else {
	         msg = "게시글 삭제 실패!";
	      }
	      
	      model.addAttribute("loc", loc).addAttribute("msg", msg);
	      
		return "common/hotmsg";
	}
	
	@RequestMapping("/updateView")
	public String updateView(@RequestParam int no, Model model) throws Exception {
		
		System.out.println("updateView no값이 잘들어가나요?" + no);
			
		Map<String, String> h = boardService.boardSelectOne(no);
		
		System.out.println("h : " + h);
		
		model.addAttribute("h", h);
		
		return "/pc/board/boardUpdate";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String bTitle,
					     @RequestParam String bContent, 
					     @RequestParam String bNo,
					     @RequestParam(defaultValue=" ") String imgpath, Model model) throws Exception {
		
		
		
		Map<String, String> update = new HashMap<>();
		update.put("bTitle", bTitle);
		update.put("bContent", bContent);
		update.put("bNo", bNo);
		update.put("imgpath", imgpath);
		
		System.out.println("들어갈때 한글이 깨지나요 ? " + update);
		
		int result;	
		
		try {
			
		result = boardService.update(update);
		
		} catch(Exception e) {
			
			throw new Exception("게시물 등록 오류!");		
		}
		
		// List 갱신 및 알람창 설정
	      String loc = "/pc/board/mainPage";
	      String msg = "";
	      
	      if(result > 0) {
	         msg = "게시글 수정 성공!";
	         loc = "/pc/board/mainPage";
	         
	      } else {
	         msg = "게시글 등록 실패!";
	      }
	      
	      model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/hotmsg";
	
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam String keyword,
						@RequestParam(value="cPage", required=false, defaultValue="1")
						int cPage, Model model){
		
		// 한 페이지 당 게시글 수
		int numPerPage = 15; // Limit 역할
			
		System.out.println("2   :" + keyword);
		
		int renew = (cPage-1) * numPerPage;
		
		HashMap<String, Object> pagingSearch = new HashMap<>();
		pagingSearch.put("renew", renew);
		pagingSearch.put("numPerPage", numPerPage);
		pagingSearch.put("keyword", keyword);
		
		List<Map<String, String>> holist = boardService.search(pagingSearch);
		
		System.out.println("holist : " + holist);
		
		// 2. 페이지 계산을 위한 총 페이지 갯수
		int totalContents = boardService.searchContents(pagingSearch);
		System.out.println("총페이지 갯수 : " + totalContents);
		
		// 3. 페이지 HTML 생성
		String pageBar = pagebar.getPageBar(totalContents, cPage, numPerPage, "search");
		
		String search = "search"; 
		model.addAttribute("holist", holist);
		model.addAttribute("totalContents", totalContents);
		model.addAttribute("numPerPage", numPerPage);
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("keyword", keyword);
		model.addAttribute("url", search);
		
		return "/pc/board/boardList";
		
	}
	
	@RequestMapping("/upload")
	public String fileupload(HttpSession session, Model model,
							@RequestParam(value="file", required = false) MultipartFile[] file,
							@RequestParam String bTitle, @RequestParam String bContent) {
		
		System.out.println( file + "은 받나요?");
		
		// 파일 저장 경로 설정
		String savePath = session.getServletContext().getRealPath("/image/boardimg");
		System.out.println("savePath : " + savePath);
		
		// 폴더의 유무 확인
		File fileAlive = new File(savePath);
		System.out.println("폴더가 있나요?" + fileAlive.exists());
		
		// 만약 존재하지 않는 다면, 폴더를 만듭니다
		if(fileAlive.exists() == false) fileAlive.mkdirs();
		
		String renamedName = "";
		
		// MultiartFile 사용하여 파일 업로드를 하겠습니다.
			for(MultipartFile f : file) {
				
				System.out.println("MuitpartFile : " + f);
				
				if(!f.isEmpty()) {
						// 원본이름 가져오기
						String originName = f.getOriginalFilename();
						System.out.println("원본 파일 : "+ originName);
						String ext = originName.substring(originName.lastIndexOf(".")+1);
						System.out.println("짜른 파일 : "+ ext);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
						System.out.println("sdf : "+ sdf);
						
						int rndNum = (int)(Math.random() * 1000);
						
						// 서버에서 저장 후 관리할 파일명
						renamedName = sdf.format(new Date()) + "_" + rndNum + "." + ext;
						System.out.println("renamedName : " + renamedName);
						
						// 실제 파일을 지정한 파일명으로 변환하여 데이터를 저장한다.
						try {
							f.transferTo(new File(savePath + "/" + renamedName));
							System.out.println("f :" + f);
							System.out.println("savePath :" + savePath);
							
						} catch (IllegalStateException | IOException e) {
							
				               e.printStackTrace();
				        }
					}	
				}
			
			model.addAttribute("imagepath", "http://192.168.0.245:8080/image/boardimg/" + renamedName);
			model.addAttribute("bTitle", bTitle);
			model.addAttribute("bContent", bContent);
			
		
		
		return "/pc/board/boardInsert";
	}
	
	@RequestMapping("/updateUpload")
	public String updateUploadFileupload(HttpSession session, Model model,
							@RequestParam(value="file", required = false) MultipartFile[] file,
							@RequestParam String bTitle, @RequestParam String bContent, @RequestParam String bNo) {
		
		System.out.println( file + "은 받나요?");
		
		// 파일 저장 경로 설정
		String savePath = session.getServletContext().getRealPath("/image/boardimg");
		System.out.println("savePath : " + savePath);
		
		// 폴더의 유무 확인
		File fileAlive = new File(savePath);
		System.out.println("폴더가 있나요?" + fileAlive.exists());
		
		// 만약 존재하지 않는 다면, 폴더를 만듭니다
		if(fileAlive.exists() == false) fileAlive.mkdirs();
		
		String renamedName = "";
		
		// MultiartFile 사용하여 파일 업로드를 하겠습니다.
			for(MultipartFile f : file) {
				
				System.out.println("MuitpartFile : " + f);
				
				if(!f.isEmpty()) {
						// 원본이름 가져오기
						String originName = f.getOriginalFilename();
						System.out.println("원본 파일 : "+ originName);
						String ext = originName.substring(originName.lastIndexOf(".")+1);
						System.out.println("짜른 파일 : "+ ext);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
						System.out.println("sdf : "+ sdf);
						
						int rndNum = (int)(Math.random() * 1000);
						
						// 서버에서 저장 후 관리할 파일명
						renamedName = sdf.format(new Date()) + "_" + rndNum + "." + ext;
						System.out.println("renamedName : " + renamedName);
						
						// 실제 파일을 지정한 파일명으로 변환하여 데이터를 저장한다.
						try {
							f.transferTo(new File(savePath + "/" + renamedName));
							System.out.println("f :" + f);
							System.out.println("savePath :" + savePath);
							
						} catch (IllegalStateException | IOException e) {
							
				               e.printStackTrace();
				        }
					}	
				}
			
			Map<String, String> h = new HashMap<>();
			h.put("BTITLE",bTitle);
			h.put("BCONTENT", bContent);
			h.put("BNO", bNo);
			h.put("IMGPATH", "http://192.168.0.245:8080/image/boardimg/" + renamedName);
			
			model.addAttribute("h", h);
		
			
		
		
		return "/pc/board/boardUpdate";
	}
	
	
	

}
