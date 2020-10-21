package project.pc.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface BoardService {
	
	List<Map<String, String>> boardPageList(Map<String, Integer> paging);
	
	int boardTotalContents();
	
	Map<String, String> boardSelectOne(int bNo);

	int insert(Map<String, String> boardMap);

	int delete(int no);

	int update(Map<String, String> update);

	List<Map<String, String>> search(HashMap<String, Object> pagingSearch);

	int searchContents(HashMap<String, Object> pagingSearch);


	

}
