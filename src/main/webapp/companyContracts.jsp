<%-- 
    Document   : companyContracts
    Created on : May 6, 2018, 2:44:14 PM
    Author     : sprlajur
--%>

<%@page import="constants.UrlParameters"%>
<%@page import="constants.Urls"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="entity.ContractEntity"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="${pageContext.request.contextPath}/css/statisticsStyles.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/javascript/sorttable.js"></script>
    </head>
    <body>
        <%
            List<ContractEntity> contracts = (List<ContractEntity>) request.getAttribute(RequestAttributeNames.ALL_CONTRACTS);
            int height = contracts.size() > 2 ? 300 : 120;
        %>
        <div class = "table-top-container" style="height: <%=(height+50)%>px; width: 100%">
            <h4>Zmluvy s mestom Prešov</h4>
            <div class="table-container">
                <div></div>
                <table cellspacing="0" class="statisticstable" id="sortable" style="height: <%=(height)%>px;  width: 100%;">
                    <thead>
                        <tr>
                            <th class="sorttable_nosort" style="width: 600px; max-width: 600px"><div style="width:600px;">Predmet</div></th>
                            <th><div style="width:150px">Dátum podpisu</div></th>
                            <th><div style="width:150px">Suma</div></th>
                            <th class="sorttable_nosort"><div></div></th>
                        </tr>
                    </thead>
                    <%
                        if (contracts != null) {
                            for (int i = 0; i < contracts.size(); i++) {
                                ContractEntity contract = contracts.get(i);
                    %>
                    <tr>  
                        <td style="width: 800px; max-width: 800px"><%=TableDataFormatter.formatTextData(contract.getSubject())%></td>
                        <td style="text-align: center; width: 150px"><%=TableDataFormatter.dateFormatter(contract.getSignatureDate())%></td>
                        <td class= "price_cell" style="width:140px; text-align: center"><%=TableDataFormatter.priceFormatter(contract.getPrice(), contract.getCurrency())%></td>
                        <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_CONTRACTS_URL + "/" + Urls.CONTRACT_DETAIL + UrlParameters.CONTRACT_DETAIL_NR_PARAMETER.getURLParameter() + contract.getContractNr()%>"><i class="glyphicon glyphicon-zoom-in"></i></a> </td>
                    </tr>
                    <%}
                        }
                    %>
                </table>
            </div>
        </div>
    </body>
</html>
