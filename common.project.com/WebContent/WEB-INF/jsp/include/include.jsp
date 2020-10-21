<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/common/tld/util.tld" prefix="u"%>

<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expries", 1L);
%>

<!DOCTYPE html>
<html>
<head>
<title>COMMON</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />

<script src="/common/js/jquery-1.8.2.js"></script>
<script src="/common/js/selectBox_script.js"></script>
<script src="/common/js/jquery.form.js"></script>
<script src="/common/js/util.js"></script>
<script type="text/javascript">
document.onkeydown = function(e) {
    var evtK = (e) ? e.which : window.event.keyCode;   
    var isCtrl = ((typeof isCtrl != 'undefined' && isCtrl) || ((e && evtK == 17) || (!e && event.ctrlKey))) ? true : false;   
  
    if ((isCtrl && evtK == 82) || evtK == 116) {   
        if (e) { evtK = 505; } else { event.keyCode = evtK = 505; }   
    }   
    if (evtK == 505) {   
    	top.body.location.reload(true);
        return false;   
    }   
}
</script>
</head>
</html>