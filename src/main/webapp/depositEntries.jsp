<%-- 
    Document   : depositEntries
    Created on : Apr 29, 2018, 3:36:52 PM
    Author     : sprlajur
--%>

<%@page import="constants.RequestAttributeNames"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page import="rpo.RPODepositEntry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% List<RPODepositEntry> depositEntries = ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getDepositEntries();
            boolean isAnyEntryFinished = depositEntries.stream().filter(ea -> ea.getEffectiveTo() != null).findAny().isPresent();
        %>
        <table class="companytable">
            <caption>Vklady</caption>
            <tr>
                <th>Darca</th>
                <th>Suma</th>
                <th>Typ</th>
                <th>Platný od</th>
                    <% if (isAnyEntryFinished) { %>
                <th>Platný do</th>
                <%} %>
            </tr>
            <%
                if (depositEntries != null) {
                    for (int i = 0; i < depositEntries.size(); i++) {
                        RPODepositEntry de = depositEntries.get(i);
                        String depositorName = de.getFullName();
                        depositorName = depositorName == null ? de.getPersonFormattedName() : depositorName;
            %>
            <tr>
                <td><%= TableDataFormatter.dataOrEmptyString(depositorName)%></td>
                <td><%= TableDataFormatter.priceFormatter(de.getAmount(), de.getCurrency())%></td>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getType())%></td>
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
