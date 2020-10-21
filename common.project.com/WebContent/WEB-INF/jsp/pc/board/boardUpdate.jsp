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

 function fn_updateCom(){
	 
	 if(confirm("글을 수정하시겠습니까?")){
		frm.action = "/pc/board/update";
		frm.submit();
		
	 } else { 
		 alert('아니요를 선택하셨습니다.');
	 }
	 
 }
 
 function maxLengthCheck(object){
	    if (object.value.length > object.maxLength){
	      //object.maxLength : 매게변수 오브젝트의 maxlength 속성 값입니다.
	      object.value = object.value.slice(0, object.maxLength);
	    }    
	  }
 
 function fn_gotoList(){
	 
	 if(confirm("리스트로 가시겠습니까?")){
			 
			 location.href = "/pc/board/mainPage";
		  	 	
		 } else { 
			 alert('취소하셨습니다.');
		}
	  	 		
  }
 
 function fileupload()
 {
 	if(document.getElementById("file").value.length <= 0)
 	{
 		alert("파일을 선택해 주세요!");
 		return;
 	}
 	frm.action = "/pc/board/updateUpload";
 	frm.submit();
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
	
	#table{
		margin:auto;
		width:800px;
	}
	
	#left{
		float:left;
		backgorund-color:blue;
		width:40%;
	}
	#right{
		float:left;
		text-align:left;
		width:60%;
		
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
	        	<form method="post" name="frm" enctype="multipart/form-data">
				<div id="left">
						<span style="width: 15%;" >제목 </span>
						<input type="text" name="bTitle" placeholder="제목을 입력해주세요.(최대20자)" style="width:500px;height:50px" maxlength="20" oninput="maxLengthCheck(this)"
						value="${h.BTITLE}"><br>
						<span style="width: 15%;">내용 </span>
						<input type="text" name="bContent" placeholder="내용을 입력해주세요.(최대200자)" style="width:500px;height:500px" maxlength="200" oninput="maxLengthCheck(this)"
						value="${h.BCONTENT}"><br><br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=button onclick="fn_updateCom();" value="수정완료">
						&nbsp;<input type=button value="리스트로가기" onclick="fn_gotoList();">
						<input type="hidden" name="bNo" value="${h.BNO}">
				</div>
				<div id="right">			
							<input type="file" name="file" id="file" style="width:58%; border:1px solid black;"/>
							<input type="button" value="upload" onclick="fileupload();"/><br>
						<c:if test="${!empty h.IMGPATH}">
							<div style="margin-top:10px;">
								<img src=${h.IMGPATH } style="border:1px solid red;">
								<input type=hidden name=imgpath value="${h.IMGPATH}">
							</div>
						</c:if>				
				</div>
				</form>
		</div>
	</div>
	<c:import url="../../pc/bottom.jsp"/>
</body>
</html>
 