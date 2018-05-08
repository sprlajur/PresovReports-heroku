<%-- 
    Document   : addressEntries
    Created on : Apr 29, 2018, 3:36:52 PM
    Author     : sprlajur
--%>

<%@page import="rpo.RPOLegalPerson"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="rpo.RPOAddressEntry"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            List<RPOAddressEntry> addressEntries = ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getAddressEntries();
            boolean isAnyEntryFinished = addressEntries.stream().filter(ea -> ea.getEffectiveTo() != null).findAny().isPresent();
        %>
        <table class="companytable">
            <caption>Adresy</caption>
            <tr>
                <th>Adresa</th>
                <th>Platná od</th>
                    <% if (isAnyEntryFinished) { %>
                <th>Platná do</th>
                    <%} %>
            </tr>
            <%            if (addressEntries != null) {
                    for (int i = 0; i < addressEntries.size(); i++) {
                        RPOAddressEntry de = addressEntries.get(i);
            %>
            <tr>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getFormattedAddress())%></td>
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
