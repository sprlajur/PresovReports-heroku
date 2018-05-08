<%-- 
    Document   : contractDetail
    Created on : Mar 18, 2018, 7:05:08 PM
    Author     : sprlajur
--%>

<%@page import="entity.OrderEntity"%>
<%@page import="entity.GrantEntity"%>
<%@page import="entity.ContractEntity"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="rpo.RPODepositEntry"%>
<%@page import="java.util.List"%>
<%@page import="rpo.RPOAddressEntry"%>
<%@page import="constants.UrlParameters"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="rpo.RPOLegalPerson"%>
<%@page import="constants.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Právnická osoba</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <%
            RPOLegalPerson person = (RPOLegalPerson) request.getAttribute(RequestAttributeNames.LEGAL_PERSON);
            String ico = request.getParameter(UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getParameter());
            List<ContractEntity> contracts = null;
            List<GrantEntity> grants = null;
            List<OrderEntity> orders = null;
            if (request.getAttribute(RequestAttributeNames.ALL_CONTRACTS) != null) {
                contracts = (List<ContractEntity>) request.getAttribute(RequestAttributeNames.ALL_CONTRACTS);
            }
            if (request.getAttribute(RequestAttributeNames.ALL_GRANTS) != null) {
                grants = (List<GrantEntity>) request.getAttribute(RequestAttributeNames.ALL_GRANTS);
            }
            if (request.getAttribute(RequestAttributeNames.ALL_ORDERS) != null) {
                orders = (List<OrderEntity>) request.getAttribute(RequestAttributeNames.ALL_ORDERS);
            }
        %>
        <h1><%=person.getName()%></h1>
        <div class="basicinfo">
            <strong>IČO: </strong> <span><%=ico%></span>
            <strong>Adresa: </strong> <span><%= TableDataFormatter.dataOrDash(person.getFormatted_address())%></span>
            <strong>Dátum založenia: </strong> <span><%= TableDataFormatter.dateFormatter(person.getEstablished_on())%></span>
            <% if (person.getTerminated_on() != null) {%>
            <strong>Dátum ukončenia činnosti: </strong> <span><%= TableDataFormatter.dateFormatter(person.getTerminated_on())%></span>
            <% }%>
            <c:if test = "${person.getCurrentLegalForm() ne null}">
                <strong>Právna forma: </strong> <span><%= person.getCurrentLegalForm()%></span>
            </c:if>
            <strong>Typ vlastníctva: </strong> <span><%= TableDataFormatter.dataOrDash(person.getOwnershipType())%></span>
            <strong>Počet zamestnancov: </strong> <span><%= TableDataFormatter.dataOrDash(person.getOrganizationSize())%></span>
            <strong>SK NACE: </strong> <span><%= TableDataFormatter.dataOrDash(person.getSkNACECategory())%></span>
            <strong>Hlavná ekonomická činnosť: </strong> <span><%= TableDataFormatter.dataOrDash(person.getMainActivityCode())%></span>
            <strong>Činnost podľa ESA2010: </strong> <span><%= TableDataFormatter.dataOrDash(person.getEsa2010Code())%></span>
            <strong>Miesto registrácie: </strong> <span><%= TableDataFormatter.dataOrDash(person.getRegistration_office())%></span>
            <strong>Registračné čislo: </strong> <span><%= TableDataFormatter.dataOrDash(person.getRegistration_nr())%></span>    
            <strong>Viac informácií na:</strong><span> <a href="https://finstat.sk/<%=ico%>" target="_blank">finstat.sk/<%=ico%></a></span> 

        </div>
        <% if (contracts != null && !contracts.isEmpty()) {%>
        <jsp:include page="companyContracts.jsp" />
        <% }%>
        <% if (grants != null && !grants.isEmpty()) {%>
        <jsp:include page="companyGrants.jsp" />
        <% }%>
        <% if (orders != null && !orders.isEmpty()) {%>
        <jsp:include page="companyOrders.jsp" />
        <% }%>
        <c:if test = "${person.getEconomicActivityEntries() ne null && not person.getEconomicActivityEntries().isEmpty()}">
            <jsp:include page="economicActivityEntries.jsp" />
        </c:if>        
        <c:if test = "${person.getLegalStatusEntries() ne null && not person.getLegalStatusEntries().isEmpty()}">
            <jsp:include page="legalStatusEntries.jsp" />
        </c:if>
        <c:if test = "${person.getShareEntries() ne null && not person.getShareEntries().isEmpty()}">
            <jsp:include page="shareEntries.jsp" />
        </c:if>
        <c:if test = "${person.getStatutoryEntries() ne null && not person.getStatutoryEntries().isEmpty()}">
            <jsp:include page="statutoryStakeholderEntries.jsp" >
                <jsp:param name="object" value="statutory" />
            </jsp:include>
        </c:if>
        <c:if test = "${person.getStakeholderEntries() ne null && not person.getStakeholderEntries().isEmpty()}">
            <jsp:include page="statutoryStakeholderEntries.jsp" />
        </c:if>
        <c:if test = "${person.getPredecessorEntries() ne null && not person.getPredecessorEntries().isEmpty()}">
            <jsp:include page="predecessorSuccessorEntries.jsp" >
                <jsp:param name="object" value="predecessor" />
            </jsp:include>
        </c:if>
        <c:if test = "${person.getSuccessorEntries() ne null && not person.getSuccessorEntries().isEmpty()}">
            <jsp:include page="predecessorSuccessorEntries.jsp" />
        </c:if>
        <c:if test = "${person.getEquityEntries() ne null && not person.getEquityEntries().isEmpty()}">
            <jsp:include page="equityEntries.jsp" />
        </c:if>
        <c:if test = "${person.getDepositEntries() ne null && not person.getDepositEntries().isEmpty()}">
            <jsp:include page="depositEntries.jsp" />
        </c:if>
        <c:if test = "${person.getNameEntries() ne null && person.getNameEntries().size() gt 1}">
            <jsp:include page="nameEntries.jsp" />
        </c:if>
        <c:if test = "${person.getAlternateNameEntries() ne null && not person.getAlternateNameEntries().isEmpty()}">
            <jsp:include page="alternateNameEntries.jsp" />
        </c:if>
        <c:if test = "${person.getAddressEntries() ne null && person.getAddressEntries().size() gt 1}">
            <jsp:include page="addressEntries.jsp" />
        </c:if>
        <c:if test = "${person.getAuthorizationEntries() ne null && not person.getAuthorizationEntries().isEmpty()}">
            <jsp:include page="authorizationEntries.jsp" />
        </c:if>
        <c:if test = "${person.getLegalForms() ne null && person.getLegalForms().size() gt 1}">
            <jsp:include page="legalFormEntries.jsp" />
        </c:if>
    </body>
</html>
