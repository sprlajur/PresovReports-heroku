<%-- 
    Document   : topMenu
    Created on : Apr 28, 2018, 10:42:43 AM
    Author     : sprlajur
--%>

<%@page import="constants.Urls"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="top_menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_CONTRACTS_URL%>">Zmluvy</a></li>
                <li><a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_GRANTS_URL%>">Dotácie</a></li>
                <li><a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_ORDERS_URL%>">Objednávky</a></li>
                <li><a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_INVOICES_URL%>">Faktúry</a></li>
                <li><a href="${pageContext.request.contextPath}<%="/" + Urls.STATISTICS%>">Štatistiky</a><li>
                <li><a href="${pageContext.request.contextPath}<%="/" + Urls.ABOUT%>">O projekte</a><li>
            </ul>
        </div>
    </body>
</html>
