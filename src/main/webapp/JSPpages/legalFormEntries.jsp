<%-- 
    Document   : legalFormEntries
    Created on : Apr 29, 2018, 3:36:52 PM
    Author     : sprlajur
--%>

<%@page import="constants.RequestAttributeNames"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page import="rpo.RPOOneStringEntry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            List<RPOOneStringEntry> legalFormEntries = ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getLegalForms();
            boolean isAnyEntryFinished = legalFormEntries.stream().filter(ea -> ea.getEffectiveTo() != null).findAny().isPresent();
        %>
        <table class="companytable">
            <caption>Právne formy</caption>
            <tr>
                <th>Názov</th>
                    <% if (isAnyEntryFinished) { %>
                <th>Platný do</th>
                    <%} %>
            </tr>
            <%

                if (legalFormEntries != null) {
                    for (int i = 0; i < legalFormEntries.size(); i++) {
                        RPOOneStringEntry de = legalFormEntries.get(i);
            %>
            <tr>
                <td><%= TableDataFormatter.dataOrEmptyString(de.getBody())%></td>
                <td>Platné od:<%= TableDataFormatter.dateFormatter(de.getEffectiveFrom())%></td>
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
