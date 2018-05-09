<%-- 
    Document   : contractDetail
    Created on : Mar 18, 2018, 7:05:08 PM
    Author     : sprlajur
--%>

<%@page import="entity.OrderEntity"%>
<%@page import="DAO.ContractEntityDAO"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="entity.ContractEntity"%>
<%@page import="constants.UrlParameters"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="constants.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Objednávka</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <% OrderEntity order = (OrderEntity) request.getAttribute(RequestAttributeNames.ORDER);
            String orderNr = (String) TableDataFormatter.dataOrDash(order.getOrderNr());
            String supplier = (String) TableDataFormatter.dataOrDash(order.getSupplier());
            String price = (String) TableDataFormatter.dataOrDash(TableDataFormatter.priceFormatter(order.getValue(), order.getCurrency()));
            String issueDate = TableDataFormatter.dateFormatter(order.getIssueDate());
            String releaseDate = TableDataFormatter.dateFormatter(order.getReleaseDate());
            String orgStructure = (String) TableDataFormatter.dataOrDash(order.getOfficeOrganizationStructure());
            String approverName = (String) TableDataFormatter.dataOrDash(order.getApproverName());
            String approverFunction = (String) TableDataFormatter.dataOrDash(order.getApproverFunction());
            String productionDate = TableDataFormatter.dateFormatter(order.getProductionDate());
            String notes = (String) TableDataFormatter.dataOrDash(order.getReleaseNotes());
            String status = (String) TableDataFormatter.dataOrDash(order.getCompletenessStatus());
        %>
        <h1>Objednávka číslo <%=order.getOrderNr()%></h1>
        <div class="basicinfo">
            <strong>Dodávateľ: </strong> <span><a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + order.getIco()%>"><%=order.getSupplier()%></a></span>
            <strong>Hodnota: </strong> <span><%= price%></span>
            <strong>Dátum vyhotovenia: </strong> <span><%=productionDate%></span>
            <strong>Dátum zverejnenia: </strong> <span><%=releaseDate%></span>
            <strong>Dátum vystavenia: </strong> <span><%=issueDate%></span>
            <strong>Organizačná štruktúra úradu: </strong> <span><%= orgStructure%></span>
            <strong>Schvaľujúci: </strong> <span><%= approverName%></span>
            <strong>Funkcia schvaľujúceho: </strong> <span><%=approverFunction%></span>
            <strong>Poznámky k zverejneniu: </strong> <span><%=notes%></span>
            <strong>Stav vybavenia: </strong> <span><%=status%></span>
        </div>
    </body>
</html>
