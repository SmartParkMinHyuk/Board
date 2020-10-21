<%@include file="/WEB-INF/jsp/include/include.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>LogIn</title>
<script type="text/javascript">
function loginfn()
{
	var userid = document.getElementById('user_id').value;
	if(userid.length <= 0)
	{
		alert("아이디를 입력해 주세요");
		return;
	}
	var passwd = document.getElementById('user_pwd').value;
	if(passwd.length <= 0)
	{
		alert("비번을 입력해 주세요");
		return;
	}
	frm.action = "/pc/login/submit";
	frm.submit();
}

function onEnterSubmit()
{ 
	var keyCode = window.event.keyCode; 
	if(keyCode==13) loginfn();
} 
</script>
</head>

<body style="background-image: url('/image/login/bg_sm_login.jpg');">
	<div style="width: 830px; height: 677px; margin: 0 auto; margin-top: 300px;" align="center">
		<form method="post" name="frm">
			<div style="width: 462px; height: 676px; float: center;">
				<div style="width: 462px; height: 278px; margin-top: 100px; background-image: url('/image/login/img_sm_loginbox.png');">
					<div style="width: 460px; height: 278px; float: left;">
						<div style="width: 460px; height: 81px;">
						</div>
						<div style="width: 460px; height: 46px; margin-bottom: 12px;">
							<input type="text" tabindex=1 name="user_id" id="user_id" maxlength="30" placeholder="ID"  style="width: 400px; height: 36px; border-radius: 20px; padding-left: 20px; margin: 0 auto; border: none;"/>
						</div>
						<div style="width: 460px; height: 46px; margin-bottom: 21px;">
							<input type="password" tabindex=2 name="user_pwd" id="user_pwd" maxlength="30" placeholder="PASSWORD" style="width: 400px; height: 36px; border-radius: 20px; padding-left: 20px; margin: 0 auto; border: none;" onkeydown="onEnterSubmit()"/>
						</div>
						<div style="width: 460px; height: 52px;">
							<span>
								<img src="/image/login/btn_login_n.png" style="cursor: pointer;" onclick="loginfn()" onmouseover="this.src='/image/login/btn_login_p.png'" onmouseout="this.src='/image/login/btn_login_n.png'"/>
							</span>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
<%@ include file="/WEB-INF/jsp/pc/login/session.jsp" %>
</body>
</html>