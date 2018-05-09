<%-- 
    Document   : allGrants
    Created on : Apr 25, 2018, 5:29:45 PM
    Author     : sprlajur
--%>

<%@page import="constants.UrlParameters"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="entity.GrantEntity"%>
<%@page import="java.util.List"%>
<%@page import="constants.Urls"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Dotácie mesta</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <jsp:include page="mainSearch.jsp">
            <jsp:param name="dateCellType" value="hidden"/>
        </jsp:include>
        <jsp:include page="basicStatistics.jsp"/>
        <%! List<GrantEntity> grants;%>
        <table id="datatable" style="width:100%">
            <tr style=>      
                <th>Žiadateľ</th>
                <th>Akcia</th>
                <th>Rok dotácie</th>
                <th>Stav vybavenia</th>
                <th>Schválené prostriedky</th>
            </tr>
            <%
                grants = (List<GrantEntity>) request.getAttribute(RequestAttributeNames.ALL_GRANTS);
                int currentPage = (int) request.getAttribute("currentPage");
                int endIndex = (int) request.getAttribute("endIndex");
                for (int i = (int) request.getAttribute("startIndex"); i < endIndex; i++) {
                    GrantEntity grant = grants.get(i);
            %>
            <tr>      
                <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + grant.getApplicantIco()%>"><%= grant.getApplicant()%></a> </td>
                <td><%=TableDataFormatter.formatTextData(grant.getAction())%></td>
                <td><%=TableDataFormatter.dataOrEmptyString(grant.getGrantYear())%></td>
                <td><%=TableDataFormatter.dataOrEmptyString(grant.getStatus())%></td> 
                <td><%=TableDataFormatter.priceFormatter(grant.getApprovedGrant(), grant.getCurrency())%></td>
            </tr>
            <% }%>
        </table>
        <jsp:include page="pagination.jsp" />
    </body>
</html>
