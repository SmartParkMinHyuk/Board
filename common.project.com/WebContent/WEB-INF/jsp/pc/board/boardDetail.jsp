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
 
 function fn_gotoList(){
	 
 if(confirm("리스트로 가시겠습니까?")){
		 
		 location.href = "/pc/board/mainPage";
	  	 	
	 } else { 
		 alert('취소하셨습니다.');
	}
  	 		
    }
 
 function fn_updateView(){
	 
	 if(confirm("글을 수정하시겠습니까?")){
		 
		 location.href = "/pc/board/updateView?no=${h.BNO}";
	  	 	
	 } else { 
		 alert('취소하셨습니다.');
	}

	 
	
		
}
 
 function fn_Delete(){
	 
	 if(confirm("글을 삭제하시겠습니까?")){
		 
		 location.href = "/pc/board/Delete?no=${h.BNO}";
	  	 	
	 } else { 
		 alert('취소하셨습니다.');
	}
		
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
	
	
</style>
</head>
<body>
	<c:import url="../../pc/top.jsp"/>
	<div style="height: 700px;">
		<div class='left-box'>
			<c:import url="../../pc/left.jsp"/>
		</div>
		<div class='right-box'>
	        <div id="table">
				<div class="row">
				작성자&nbsp;:&nbsp;${h.NICNAME}<br>
				작성일자&nbsp;:&nbsp;<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${h.BDATE}" /><br><br>
				제목&nbsp;:&nbsp;${h.BTITLE}<br>
				내용&nbsp;:&nbsp;${h.BCONTENT}<br>
				<c:if test="${!empty h.IMGPATH}">
					<div style="margin-top:10px;">
						<img src=${h.IMGPATH} style="border:1px solid red;">
					</div>
				</c:if>			
				</div>
				<br>
			</div>
			<div style="float:left; width:50%;">
				<c:if test="${USER_NICKNAME eq h.NICNAME}">
					<input type=button value="삭제하기" onclick="fn_Delete();">
					<input type=button value="수정하기" onclick="fn_updateView();">
				</c:if>
				<input type=button value="리스트로가기" onclick="fn_gotoList();">
			</div>
		</div>
	</div>
	<c:import url="../../pc/bottom.jsp"/>
</body>
</html>
 