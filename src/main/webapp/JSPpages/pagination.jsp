<%-- 
    Document   : pagination
    Created on : May 3, 2018, 5:16:14 PM
    Author     : sprlajur
--%>

<%@page import="constants.Urls"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div style="font-size:15px">
            <div style="float:left">
                <c:if test = "${requestScope.currentPage gt 1}">
                    <a class="paginationlink" style="float: left" href="${requestScope['javax.servlet.forward.request_uri']}?pageNr=1">Prvá</a>
                    <a class="paginationlink" style="float: left" href="${requestScope['javax.servlet.forward.request_uri']}?pageNr=${requestScope.currentPage -1}">Predchádzajúca</a>
                </c:if>
            </div>
            <div style="float:right">
                <c:if test = "${requestScope.currentPage lt requestScope.lastPage}">
                    <a class="paginationlink" href="${requestScope['javax.servlet.forward.request_uri']}?pageNr=${requestScope.currentPage +1}">Ďalšia </a>
                    <a class="paginationlink" href="${requestScope['javax.servlet.forward.request_uri']}?pageNr=${requestScope.lastPage}">Posledná</a>
                </c:if>
            </div>
        </div>
    </body>
</html>
