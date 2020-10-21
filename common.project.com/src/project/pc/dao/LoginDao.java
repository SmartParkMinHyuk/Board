package project.pc.dao;

import project.common.exception.BizException;

public interface LoginDao {
	public String getUserNickname(String user_id, String user_pwd) throws BizException;
}
