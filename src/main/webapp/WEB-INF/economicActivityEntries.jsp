<%-- 
    Document   : economicActivityEntries
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
        <link href="${pageContext.request.contextPath}/css/statisticsStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% List<RPOOneStringEntry> economicActivityEntries = ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getEconomicActivityEntries();
            boolean isAnyEntryFinished = economicActivityEntries.stream().filter(ea -> ea.getEffectiveTo() != null).findAny().isPresent();
            int height = economicActivityEntries.size() > 5 ? 300 : 100;
        %>
        <div class = "table-top-container" style="height: <%=(height+50)%>px; width: 600px">
            <h4>Predmety podnikania</h4>
            <div class="table-container">
                <div></div>
                <table cellspacing="0" class="statisticstable" style="height:<%=height%>px;  width: 600px;">
                    <tr>
                        <th><div style="width: 300px;">Názov</div></th>
                        <th><div style="width: 130px">Platný od</div></th>
                            <% if (isAnyEntryFinished) { %>
                        <th><div style="width: 130px">Platný do</div></th>
                            <%} %>
                    </tr>
                    <%
                        if (economicActivityEntries != null) {
                            for (int i = 0; i < economicActivityEntries.size(); i++) {
                                RPOOneStringEntry de = economicActivityEntries.get(i);
                    %>
                    <tr>
                        <td  style="width: 500px; max-width: 500px"><%= TableDataFormatter.dataOrEmptyString(de.getBody())%></td>
                        <td style="width: 150px; text-align: center"><%= TableDataFormatter.dateFormatter(de.getEffectiveFrom())%></td>
                        <% if (isAnyEntryFinished) {%>
                        <td style="width: 150px; text-align: center"><%= TableDataFormatter.dateFormatter(de.getEffectiveTo())%></td>
                        <%}%>
                    </tr>             
                    <% }
                        }
                    %>
                </table>
            </div>
        </div>
                </body>
                </html>
