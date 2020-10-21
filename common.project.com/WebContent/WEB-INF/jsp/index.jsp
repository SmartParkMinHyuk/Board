<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/include.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<script type="text/javascript">	
 var id = <%=(String)session.getAttribute("USER_ID")%>
 
 if (id == null){
	 location.href ="/pc/login/login"
 }

	  
</script>
<style>
	.left-box {
	 
	  float: left;
	  width: 10%;
	}
	.right-box {
	  float: right;
	  width: 90%;
	}
	
	#table {display: table; width: 100%;}
	.row {display: table-row;}
	.cell {display: table-cell; padding: 3px; border-bottom: 1px solid #DDD;}
	.col1 { width: 10%;}
	.col2 {width: 60%;}
	.col3 {width: 10%;}
	.col4 {width: 10%;}
	.col5 {width: 10%;}
	
	
</style>
</head>
<body>
	<c:import url="pc/top.jsp"/>
	<div style="height: 700px;">
		<div class='left-box'>
			<c:import url="pc/left.jsp"/>
		</div>
		<div class='right-box'>
	        <div id="table">
				<div>
					<a class="cell col2" href=<c:url value='${pageContext.request.contextPath}/pc/board/mainPage'/>> 페이징게시판으로 이동..</a><br>		
					<a class="cell col2" href=<c:url value='${pageContext.request.contextPath}/pc/board/mainPage2'/>> ajax게시판으로 이동..</a><br>		 
				</div>
			</div>
		</div>
	</div>
	<c:import url="pc/bottom.jsp"/>
</body>
</html>
 