package project.pc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.common.config.MsgConstants;
import project.common.exception.BizException;
import project.pc.dao.LoginDao;

@Service
@Transactional
public class LoginServiceImpl implements LoginService 
{
	@Autowired LoginDao dao;

	@Override
	public String getUserNickname(String user_id, String user_pwd) throws BizException 
	{
		try 
		{
			return dao.getUserNickname(user_id, user_pwd);
		} 
		catch (Exception e) 
		{
			throw new BizException(MsgConstants.LOGIN_SYSTEM, MsgConstants.GETUSERNICKNAME_ERROR_SERVICE + "/" + e.getMessage());
		}
		
	}
}