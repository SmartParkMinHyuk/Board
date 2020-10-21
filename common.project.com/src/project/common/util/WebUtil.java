package project.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import project.common.controller.CommonController;

public class WebUtil extends CommonController {

	/**
	 * LIST Total value 구하기 
	 * @param totalSize
	 * @param pageSize
	 * @return
	 */
	public static int makeTotalPage(int totalSize, int pageSize) {
		if(totalSize == 0) return 0;
	
		return (totalSize - 1) / pageSize + 1;
	}
	
	/**
	 * LIST Paging 처리
	 * @param pagingSize
	 * @param pageNum
	 * @param totalListCount
	 * @param listViewSize
	 * @param pagingURL
	 * @return
	 */
	public static HashMap<String, Object> makePagingDataMap(int pagingSize, String pageNum, String totalListCount, int listViewSize, String pagingURL) {

		// 페이징에 필요한 데이터 Start.
		HashMap<String, Object> pagingValues = new HashMap<String, Object>();
		pagingValues.put("pagingSize", pagingSize);
		pagingValues.put("startPageNum", (Integer.parseInt(pageNum)/pagingSize) * pagingSize);
		pagingValues.put("pageNum", pageNum);
		pagingValues.put("totalPageSize", makeTotalPage(Integer.parseInt(totalListCount), listViewSize));
		pagingValues.put("totalListCount", totalListCount);
		pagingValues.put("pagingURL", pagingURL);
		
		return pagingValues;
	}

	
	/**
	 * 사이트 공통 정보
	 * @param domainURL
	 * @param nasImageURL
	 * @return
	 */
	public static HashMap<String, Object> makePublicDataMap(String domainURL, String nasInfo, HttpServletRequest request) {

		HttpSession session = request.getSession(true);			
		Object USER_ID = session.getAttribute("USER_ID");
		
		// 공통 프로퍼티 정보
		HashMap<String, Object> publicValues = new HashMap<String, Object>();
		publicValues.put("domainURL", domainURL);
		publicValues.put("nasInfo", nasInfo);
		publicValues.put("USER_ID", USER_ID);
		publicValues.put("boardCode", request.getParameter("boardCode"));

		return publicValues;
	}
	
	/*
	 * date 정보
	 */
	public static String getDate()
	{
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
		String str = dayTime.format(new Date(time));
		return str;
	}
	
	/*
	 * date 정보
	 */
	public static String getDateTime()
	{
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = dayTime.format(new Date(time));
		return str;
	}
}
