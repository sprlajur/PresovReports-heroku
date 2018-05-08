<%-- 
    Document   : equityEntries
    Created on : Apr 29, 2018, 3:36:52 PM
    Author     : sprlajur
--%>

<%@page import="constants.RequestAttributeNames"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page import="rpo.RPOEquityEntry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            List<RPOEquityEntry> equityEntries = ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getEquityEntries();
            boolean isAnyEntryFinished = equityEntries.stream().filter(ea -> ea.getEffectiveTo() != null).findAny().isPresent();
        %>
        <table class="companytable">
            <caption>Základné imanie</caption>
            <tr>
                <th>Schválená výška podielu</th>
                <th>Platné od</th>
                    <% if (isAnyEntryFinished) { %>
                <th>Platné do</th>
                    <%} %>
            </tr>
            <%
                if (equityEntries != null) {
                    for (int i = 0; i < equityEntries.size(); i++) {
                        RPOEquityEntry de = equityEntries.get(i);
            %>
            <tr>
                <td><%= TableDataFormatter.priceFormatter(de.getApprovedAmount(), de.getApprovedCurrency())%></td>
                <td><%= TableDataFormatter.dateFormatter(de.getEffectiveFrom())%></td>
                <% if (isAnyEntryFinished) {%>
                <td><%= TableDataFormatter.dateFormatter(de.getEffectiveTo())%></td>
                <%}%>
            </tr>   
            <% }
                }
            %>
        </table>
    </body>
</html>
