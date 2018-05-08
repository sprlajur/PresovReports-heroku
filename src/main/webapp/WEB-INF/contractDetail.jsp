<%-- 
    Document   : contractDetail
    Created on : Mar 18, 2018, 7:05:08 PM
    Author     : sprlajur
--%>

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
        <title>Zmluva</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <% ContractEntity contract = (ContractEntity) request.getAttribute(RequestAttributeNames.CONTRACT);
            String parties = contract.getParties();
            String party1 = TableDataFormatter.formatParties(parties, 0);
            String party2 = TableDataFormatter.formatParties(parties, 1);
            String contractID = (String) TableDataFormatter.dataOrDash(contract.getContractNr());
            String type = (String) TableDataFormatter.dataOrDash(contract.getType());
            String kind = (String) TableDataFormatter.dataOrDash(contract.getKind());
            String currency = (String) TableDataFormatter.dataOrDash(contract.getCurrency());
            String signatureDate = TableDataFormatter.dateFormatter(contract.getSignatureDate());
            String releaseDate = TableDataFormatter.dateFormatter(contract.getReleaseDate());
            String name = (String) TableDataFormatter.dataOrDash(contract.getName());
            String mainOrAppendix = (String) TableDataFormatter.dataOrDash(contract.getMainOrAppendix());
            String signaturePlace = (String) TableDataFormatter.dataOrDash(contract.getSignaturePlace());
            String validityDate = TableDataFormatter.dateFormatter(contract.getValidityDate());
            String subject = (String) TableDataFormatter.dataOrDash(contract.getSubject());
        %>
        <h1>Zmluva číslo <%=contract.getContractNr()%></h1>
        <div class="basicinfo">
            <strong>Typ: </strong> <span><%= type%></span>
            <strong>Druh: </strong> <span><%= contract.getKind()%></span>
            <strong>Strany: </strong> <span><a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + ContractEntityDAO.getIcoFromContract(contract, party1)%>"><%=party1%></a>;&nbsp; &nbsp;  
                <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + ContractEntityDAO.getIcoFromContract(contract, party2)%>"><%=party2%></a></span>
            <strong>Predmet: </strong> <span><%= subject%></span>
            <strong>Suma: </strong> <span><%= (String) TableDataFormatter.dataOrDash(TableDataFormatter.priceFormatter(contract.getPrice(), currency))%></span>
            <strong>Dátum podpisu: </strong> <span><%=signatureDate%></span>
            <strong>Dátum zverejnenia: </strong> <span><%=releaseDate%></span>
            <strong>Názov: </strong> <span><%= name%></span>
            <strong>Hlavná/Dodatok: </strong> <span><%= mainOrAppendix%></span>
            <strong>Miesto (miesta) podpisu: </strong> <span><%=signaturePlace%></span>
            <strong>Dátum platnosti: </strong> <span><%=validityDate%></span>
        </div>
    </body>
</html>
