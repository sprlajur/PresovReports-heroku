<%-- 
    Document   : shareEntries
    Created on : Apr 29, 2018, 3:36:52 PM
    Author     : sprlajur
--%>

<%@page import="constants.RequestAttributeNames"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page import="rpo.RPOShareEntry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            List<RPOShareEntry> shareEntries = ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getShareEntries();
            boolean isAnyEntryFinished = shareEntries.stream().filter(ea -> ea.getEffectiveTo() != null).findAny().isPresent();
        %>

    <body>
        <table class="companytable">
            <caption>Akcie</caption>
            <tr>
                <th>Cena akcie</th>
                <th>Počet akcií</th>
                <th>Popis prevoditeľnosti akcií</th>
                <th>Podoba akcie</th>
                <th>Forma akcie</th>
                <th>Platný od</th>
                    <% if (isAnyEntryFinished) { %>
                <th>Platný do</th>
                    <%} %>
            </tr>
            <%
                if (shareEntries != null) {
                    for (int i = 0; i < shareEntries.size(); i++) {
                        RPOShareEntry de = shareEntries.get(i);
            %>
            <tr>
                <td class="price_cell"><%= TableDataFormatter.priceFormatter(de.getPrice(), de.getCurrency())%></td>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getAmount())%></td>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getTransferDescription())%></td>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getType())%></td>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getForm())%></td>
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
