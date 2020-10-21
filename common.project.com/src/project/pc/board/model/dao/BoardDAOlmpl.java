package project.pc.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("BoardDAO")
public class BoardDAOlmpl implements BoardDAO{
	
	@Autowired 
	private SqlSessionTemplate masterSqlSessionTemplate;
	
	@Override
	public List<Map<String, String>> boardPageList(Map<String, Integer> paging) {
		
		
		
		return masterSqlSessionTemplate.selectList("boardMapper.BoardPageList", paging);
	}

	@Override
	public int boardTotalContents() {
		
		return masterSqlSessionTemplate.selectOne("boardMapper.boardTotalContents");
	}

	@Override
	public Map<String, String> boardSelectOne(int bNo) {
		
		return masterSqlSessionTemplate.selectOne("boardMapper.boardSelectOne", bNo);
	}

	@Override
	public int insert(Map<String, String> boardMap) {
		// TODO Auto-generated method stub
		return masterSqlSessionTemplate.insert("boardMapper.insert", boardMap);
	}

	@Override
	public int delete(int no) {
	
		return masterSqlSessionTemplate.delete("boardMapper.delete", no);
	}

	@Override
	public int update(Map<String, String> update) {
		
		return masterSqlSessionTemplate.update("boardMapper.update", update);
	}

	@Override
	public List<Map<String, String>> search(HashMap<String, Object> pagingSearch) {
		
		
		
		return masterSqlSessionTemplate.selectList("boardMapper.list", pagingSearch);
	}

	@Override
	public int searchContents(HashMap<String, Object> pagingSearch) {
		
		return masterSqlSessionTemplate.selectOne("boardMapper.selectContents", pagingSearch);
	}
	

	
	
	
	

}
