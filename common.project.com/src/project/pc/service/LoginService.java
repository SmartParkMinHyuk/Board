package project.pc.service;

import project.common.exception.BizException;

public interface LoginService {
	public String getUserNickname(String user_id, String user_pwd) throws BizException;
}
