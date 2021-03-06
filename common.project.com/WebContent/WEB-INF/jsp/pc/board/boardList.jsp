﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/include.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">	

var id = <%=(String)session.getAttribute("USER_ID")%>


if (id == null){
	 location.href ="/pc/login/login"
}

 function fn_Insert(){
	 if(confirm("글을 작성하시겠습니까?")){
  	 	location.href = "/pc/board/insert"	
	 } else { 
		 alert('리스트로 이동합니다.');
	}
};

function fn_search(){
	
	var keyword = document.getElementById("keyword");
	
	console.log(keyword.value);
	
	if( !keyword.value || keyword.value== " "){
		alert('검색어를 적지 않으셨습니다.');
		return;
	} 
	
	if(confirm(keyword.value + "를 검색하시겠습니까?")){
		
		search.action = "/pc/board/search";
		search.submit();
	 } else { 
		 alert('취소를 선택하셨습니다.');
	} 
}

function fn_gotoList(){
	 if(confirm("리스트로 가시겠습니까?")){
		location.href = "/pc/board/mainPage";
	} else { 
			 alert('취소하셨습니다.');
	}
	  	 		
}

function fn_paging(cPage,numPerPage){
	
	var page = "${search}?cPage="+cPage+"&keyword=${keyword}";
	
	location.href=page;
}

function onEnterSubmit()
{ 
	var keyCode = window.event.keyCode; 
	if(keyCode==13) fn_search();
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
	
	#table {display: table; width: 80%;}
	.row {display: table-row;}
	.cell {display: table-cell; padding: 3px; border-bottom: 1px solid #DDD;}
	.col1 { width: 10%;}
	.col2 {width: 60%;}
	.col3 {width: 10%;}
	.col4 {width: 15%;}
	.col5 {width: 5%;}
	
	ul {
	    list-style:none;
	    margin:0;
	    padding:0;
	    display: table; 
	    margin: auto; 
	    padding:0;
	}
	
	li {
	    margin: 0 0 0 0;
	    padding: 0 0 0 0;
	    border : 0;
	    float: left;
	    margin-left:20px;
	}
	
	.pageBar{
   		width:1400px; 
   		float:left; 
   		margin:0 auto; 
   		text-align:center;
	}
	
	.title{
		font-weight: bold; 
		font-style: italic;
		font-size: 2.0em;
		line-height: 1.0em;
		font-family: 돋움체;
		color: green;
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
			<br>
			<div class='title' onclick="fn_gotoList();" >
				게시판
			</div>
			<br>
			<form name="search" method='post'>
			<div>
				<select class="custom-select" id="searchCondition" name="searchCondition" style="height:30px; width:80px;">
				  <option value="btitle">제목</option>
				</select>
				<input type="search" id="keyword" name="keyword" style="height:30px; width:500px;" placeholder="검색어를 입력해보세요!" onkeydown="onEnterSubmit()">
				<input type=button onclick="fn_search();" value="검색하기" style="height:30px; width:70px;">
			</div>
			</form>
			<br>
	        <div id="table">
				<div class="row" style="background-color: lightgray;">
					<span class="cell col1">번호</span>
					<span class="cell col2">제목</span>
					<span class="cell col3">글쓴이</span>
					<span class="cell col4">작성일자</span>
					<span class="cell col5">조회수</span>
				</div>
				<c:forEach items="${holist}" var="h">
				<div class="row" id="delete">
					<span class="cell col1">${h.BNO}</span>
					<a class="cell col2" href=<c:url value='${pageContext.request.contextPath}/pc/board/select?no=${h.BNO}'/>>${h.BTITLE}</a>			 
					<span class="cell col3">${h.NICNAME}</span>
					<span class="cell col4">
					<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${h.BDATE}" />
					</span>
					<span class="cell col5">${h.CON}</span>
				</div>
				</c:forEach>
				<br>
			</div> 
			<div class="pageDiv">
	            <div class="pageBar">  
	              <ul>
	          		 <c:out value="${pageBar}" escapeXml="ture"/>
	              </ul>
	            </div>
            </div>
			<div style="float:right; width:24%;">
				<input type=button value="글쓰기" onclick="fn_Insert();">
			</div>
		</div>
	</div>
	<c:import url="../../pc/bottom.jsp"/>
	
</body>
</html>
 