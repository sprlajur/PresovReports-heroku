<%-- 
    Document   : allGrants
    Created on : Apr 25, 2018, 5:29:45 PM
    Author     : sprlajur
--%>

<%@page import="constants.UrlParameters"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="entity.OrderEntity"%>
<%@page import="java.util.List"%>
<%@page import="constants.Urls"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Objednávky mesta</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <jsp:include page="mainSearch.jsp" />
        <jsp:include page="basicStatistics.jsp"/>
        <%! List<OrderEntity> orders;%>
        <table id="datatable" style="width:100%">
            <tr>      
                <th>Dodávateľ</th>
                <th>Text objednávky</th>
                <th>Hodnota</th>
                <th>Stav vybavenia</th>
                <th>Dátum vystavenia</th>
                <th></th>
            </tr>
            <%
                orders = (List<OrderEntity>) request.getAttribute(RequestAttributeNames.ALL_ORDERS);
                int currentPage = (int) request.getAttribute("currentPage");
                int endIndex = (int) request.getAttribute("endIndex");
                for (int i = (int) request.getAttribute("startIndex"); i < endIndex; i++) {
                    OrderEntity order = orders.get(i);
            %>
            <tr>      
                <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + order.getIco()%>"><%= order.getSupplier()%></a> </td>
                <td class="text_cell"><%=TableDataFormatter.formatTextData(order.getOrderText())%></td>
                <td><%=TableDataFormatter.priceFormatter(order.getValue(), order.getCurrency())%></td>
                <td><%=TableDataFormatter.dataOrEmptyString(order.getCompletenessStatus())%></td> 
                <td><%=TableDataFormatter.dateFormatter(order.getIssueDate())%></td>
                <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_ORDERS_URL + "/" + Urls.ORDER_DETAIL + UrlParameters.ORDER_DETAIL_NR_PARAMETER.getURLParameter() + order.getOrderNr()%>"> <i class="glyphicon glyphicon-zoom-in"></i> </a> </td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
