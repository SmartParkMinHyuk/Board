<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="/WEB-INF/jsp/include/include.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<script type="text/javascript">
function fileupload()
{
	if(document.getElementById("file").value.length <= 0)
	{
		alert("파일을 선택해 주세요!");
		return;
	}
	frm.action = "/pc/main/upload";
	frm.submit();
}


</script>

</head>
<body>
MAIN1 CONTENT
	<form name="frm" method="post" enctype="multipart/form-data">
		<div style="width:50%; margin-top:10px;">
			파일 첨부 : <input type="file" name="file" id="file" style="width:80%; border:1px solid red;"/>
			<input type="button" value="upload" onclick="fileupload();"/>
		</div>
	</form>
	<c:if test="${!empty imagepath}">
		<div style="margin-top:10px;">
			<img src=${imagepath } style="border:1px solid red;">
		</div>
	</c:if>
	
	
	
		
</body>
</html>
 