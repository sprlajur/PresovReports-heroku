<%-- 
    Document   : allContracts
    Created on : Mar 12, 2018, 9:47:27 PM
    Author     : sprlajur
--%>

<%@page import="constants.UrlParameters"%>
<%@page import="DAO.ContractEntityDAO"%>
<%@page import="constants.*"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="java.util.List"%>
<%@page import="entity.ContractEntity"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Zmluvy mesta</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <jsp:include page="mainSearch.jsp" />
        <jsp:include page="basicStatistics.jsp"/>
        <jsp:include page="pagination.jsp" />
        <%! List<ContractEntity> contracts;%>
        <table id="datatable" style="width:100%">
            <tr>
                <th class="sorttable_nosort"> Kontraktor </th>
                <th class="sorttable_nosort">Predmet</th>
                <th>Dátum podpisu</th>
                <th>Cena</th>
                <th class="sorttable_nosort"></th>
            </tr>
            <%
                contracts = (List<ContractEntity>) request.getAttribute(RequestAttributeNames.ALL_CONTRACTS);
                int endIndex = (int) request.getAttribute("endIndex");
                for (int i = (int) request.getAttribute("startIndex"); i < endIndex; i++) {
                    ContractEntity contract = contracts.get(i);
                    String parties = contract.getParties();
                    String party1 = TableDataFormatter.formatParties(parties, 0);
                    String party2 = TableDataFormatter.formatParties(parties, 1);
                    String nonPresovParty = party1.contains("Mesto Prešov") ? party2 : party1;
            %>
            <tr>      
                <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + ContractEntityDAO.getIcoFromContract(contract, nonPresovParty)%>"><%=nonPresovParty%></a> </td>
                <td><%=TableDataFormatter.formatTextData(contract.getSubject())%></td>
                <td><%=TableDataFormatter.dateFormatter(contract.getSignatureDate())%></td>
                <td class= "price_cell"><%=TableDataFormatter.priceFormatter(contract.getPrice(), contract.getCurrency())%></td>
                <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_CONTRACTS_URL + "/" + Urls.CONTRACT_DETAIL + UrlParameters.CONTRACT_DETAIL_NR_PARAMETER.getURLParameter() + contract.getContractNr()%>"><i class="glyphicon glyphicon-zoom-in"></i></a> </td>
            </tr>
            <% }%>
        </table>
        <jsp:include page="pagination.jsp" />
    </body>
</html>
