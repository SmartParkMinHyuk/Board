package project.pc.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.common.config.MsgConstants;
import project.common.exception.BizException;

@Repository
public class LoginDaoImpl implements LoginDao 
{

	@Autowired private SqlSessionTemplate masterSqlSessionTemplate;
	
	@Override
	public String getUserNickname(String user_id, String user_pwd) throws BizException
	{
		HashMap<String, Object> paramMap = null;

		try
		{
			paramMap = new HashMap<>();
			paramMap.put("id", user_id);
			paramMap.put("pwd", user_pwd);
			return masterSqlSessionTemplate.selectOne("logIn.getUserNickname", paramMap);
		} 
		catch(Exception e) 
		{
			throw new BizException(MsgConstants.LOGIN_SYSTEM, MsgConstants.GETUSERNICKNAME_ERROR_DAO + "/" + e.getMessage());
		}
		finally
		{
			if (paramMap != null)
			{
				paramMap.clear();
				paramMap = null;
			}
		}
	}
}
