<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include/include.jsp" %>
<c:choose>
	<c:when test="${session == 'nomember'}">
		<script>
			alert("잘못된 아이디/비밀번호 입니다\n다시 입력해주세요.");
		</script>
	</c:when>
	<c:when test="${session == 'logout'}">
		<script>
			alert("로그아웃 되었습니다. 감사합니다.");
			parent.location.href = "/pc/login/login";
		</script>
	</c:when>
	<c:when test="${session == 'sessionclose'}">
		<script>
			parent.location.href = "/pc/login/login";
		</script>
	</c:when>
	<c:when test="${session == 'OK'}">
		<script>
			alert("로그인 되었습니다.\n확인 후 페이지 이동합니다.");
			location.href = "/pc/index";
		</script>
	</c:when>
</c:choose>