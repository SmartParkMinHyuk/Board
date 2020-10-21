package project.pc.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.pc.board.model.dao.BoardDAO;

@Service("boardService")
public class BoardServicelmpl implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<Map<String, String>> boardPageList(Map<String, Integer> paging) {
		
		return boardDAO.boardPageList(paging);
	}
	
	@Override
	public int boardTotalContents() {
		
		return boardDAO.boardTotalContents();
	}
	
	@Override
	public Map<String, String> boardSelectOne(int bNo) {
		
		return boardDAO.boardSelectOne(bNo);
	}

	@Override
	public int insert(Map<String, String> boardMap) {
		
		return boardDAO.insert(boardMap);
	}

	@Override
	public int delete(int no) {
		
		return boardDAO.delete(no);
	}

	@Override
	public int update(Map<String, String> update) {
		
		return boardDAO.update(update);
	}

	@Override
	public List<Map<String, String>> search(HashMap<String, Object> pagingSearch) {
		// TODO Auto-generated method stub
		return boardDAO.search(pagingSearch);
	}

	@Override
	public int searchContents(HashMap<String, Object> pagingSearch) {
		// TODO Auto-generated method stub
		return boardDAO.searchContents(pagingSearch);
	}
	
	
	

}
