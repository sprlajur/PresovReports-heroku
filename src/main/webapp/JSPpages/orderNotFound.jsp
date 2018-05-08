<%-- 
    Document   : partyNotFound
    Created on : Mar 19, 2018, 8:51:49 PM
    Author     : sprlajur
--%>

<%@page import="constants.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Objednávka nenájdená</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <h3>Objednávka číslo <%=request.getParameter(UrlParameters.ORDER_DETAIL_NR_PARAMETER.getParameter())%> nebola najdená.</h3>
    </body>
</html>
