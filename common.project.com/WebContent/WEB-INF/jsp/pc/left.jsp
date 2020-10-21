<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="http://cdn.nitrome.com/favicon.ico" />
<link rel="stylesheet" type="text/css" href="/common/css/poi.css">
<script src="/common/js/util.js"></script>
<script type="text/javascript">
function changeLeft(value) {
	document.getElementById("tbl_1").style.display = "none";

	if (value == "1") {
		document.getElementById("tbl_1").style.display = "";
	}
}

function move(value) {
	parent.frame_move(value);
}
</script>
</head>
<body style="padding: 15px;">
	<table style="width: 210; border: 0; margin: 0; padding: 0; border-spacing: 0; background-color: #FFFFFF;" id="tbl_1">
		<tr>
			<td><B>MAIN1</B></td>
		</tr>
		<tr>
			<td height="5"></td>
		</tr>
		<tr>
			<td style="cursor: pointer;" onclick="move(1);">MAIN1 SUB</td>
		</tr>
	</table>
</body>
</html>
