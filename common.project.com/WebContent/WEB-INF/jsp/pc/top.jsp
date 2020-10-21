<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="/common/js/util.js"></script>
<script type="text/javascript">
//로그 아웃
	function logout(){
			if(confirm("로그아웃 하시겠습니까?") != 1) return;
			location.href = "/pc/login/logout";
		}

	$(document).ready(function (){
		if( null == session.getAttribute("USER_NICKNAME") || " " == session.getAttribute("USER_NICKNAME")){
			alert("로그인이 필요합니다");
			location.href ="/pc/login/login";
		}
	})
</script>	
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<div style="width:100%;">
		<div style="width:50%; height:30px; float:left; text-align:center; margin-top: 10px; border:0px solid red;">
			<img src="/image/top/home.png" style="cursor:pointer; width:70px; height:30px;" border="0" align="middle" alt="home" onclick="move(1);" />
		</div>
		<div style="width:50%; height:30px; float:right; text-align:center; margin-top: 10px; border:0px solid black;">
			<%=session.getAttribute("USER_NICKNAME") %>님 반갑습니다.&nbsp;
			<input type="button" style="margin-bottom:10px; cursor:pointer;" value="로그아웃" onclick="logout();"></input>
		</div>
	</div>
	<div style="width:20%; height:30px; float:left; text-align:center; margin-top: 10px; border:0px solid red;">
		<span style="cursor:pointer; width:100%; font-size:12pt; line-height:1.5em" onclick="move(1);">MAIN1</span>
	</div>
	<div style="width:20%; height:30px; float:left; text-align:center; margin-top: 10px; border:0px solid red;">
		<span style="cursor:pointer; width:100%; font-size:12pt; line-height:1.5em" onclick="move(2);">MAIN2</span>
	</div>
	<div style="width:20%; height:30px; float:left; text-align:center; margin-top: 10px; border:0px solid red;">
		<span style="cursor:pointer; width:100%; font-size:12pt; line-height:1.5em" onclick="move(3);">MAIN3</span>
	</div>
	<div style="width:20%; height:30px; float:left; text-align:center; margin-top: 10px; border:0px solid red;">
		<span style="cursor:pointer; width:100%; font-size:12pt; line-height:1.5em" onclick="move(4);">MAIN4</span>
	</div>
	<div style="width:20%; height:30px; float:left; text-align:center; margin-top: 10px; border:0px solid red;">
		<span style="cursor:pointer; width:100%; font-size:12pt; line-height:1.5em" onclick="move(5);">MAIN5</span>
	</div>
	<hr width=100%>
</body>
</html>