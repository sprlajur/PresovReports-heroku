<%-- 
    Document   : nameEntries
    Created on : Apr 29, 2018, 3:36:52 PM
    Author     : sprlajur
--%>

<%@page import="constants.UrlParameters"%>
<%@page import="constants.Urls"%>
<%@page import="constants.Urls"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page import="rpo.RPOPredecessorSuccessorEntry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Boolean isPredecessor = "predecessor".equals(request.getParameter("object"));
            List<RPOPredecessorSuccessorEntry> nameEntries = isPredecessor ? ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getPredecessorEntries() : ((RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON)).getSuccessorEntries();
            String header = isPredecessor ? "Predchodcovia" : "Následníci";
        %>
        <table class="companytable">
            <caption><%=header%></caption>
            <tr>
                <th>Názov:</th>
            </tr>
            <%
                if (nameEntries != null) {
                    for (int i = 0; i < nameEntries.size(); i++) {
                        RPOPredecessorSuccessorEntry de = nameEntries.get(i);
            %>
            <tr>
                <td><a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + de.getIco()%>"><%= de.getName()%></a></td>
            </tr>          
            <% }
                }
            %>
        </table>
    </body>
</html>
