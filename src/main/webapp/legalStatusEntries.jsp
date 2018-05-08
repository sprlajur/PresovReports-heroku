<%-- 
    Document   : legalStatusEntries
    Created on : Apr 29, 2018, 3:36:52 PM
    Author     : sprlajur
--%>

<%@page import="constants.RequestAttributeNames"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page import="rpo.RPOOneStringEntry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        List<RPOOneStringEntry> legalStatusEntries = ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getLegalStatusEntries();
        boolean isAnyEntryFinished = legalStatusEntries == null ? false : legalStatusEntries.stream().filter(ea -> ea.getEffectiveTo() != null).findAny().isPresent();
    %>
    <body>
        <table class="companytable">
            <caption>Právne stavy</caption>
            <tr>
                <th>Názov</th>
                <th>Platný od</th>
                    <% if (isAnyEntryFinished) {%>
                <th>Platný do</th>
                    <%}%>
            </tr>
            <%
                if (legalStatusEntries != null) {
                    for (int i = 0; i < legalStatusEntries.size(); i++) {
                        RPOOneStringEntry de = legalStatusEntries.get(i);
            %>
            <tr>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getBody())%></td>
                <td><%= TableDataFormatter.dateFormatter(de.getEffectiveFrom())%></td>
                <% if (isAnyEntryFinished) {%>                    
                <td><%= TableDataFormatter.dateFormatter(de.getEffectiveTo())%></td>
                <%} %>
            </tr>
            <% }
                }
            %>
        </table>
    </body>
</html>
