<%-- 
    Document   : statistics
    Created on : May 6, 2018, 7:14:19 PM
    Author     : sprlajur
--%>

<%@page import="DAO.ContractEntityDAO"%>
<%@page import="entity.OrderEntity"%>
<%@page import="entity.ContractEntity"%>
<%@page import="entity.GrantEntity"%>
<%@page import="entity.InvoiceEntity"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page import="constants.UrlParameters"%>
<%@page import="constants.Urls"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="java.util.List"%>
<%@page import="presentation.TopCompany"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/statisticsStyles.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="${pageContext.request.contextPath}/javascript/sorttable.js"></script>
        <script src="${pageContext.request.contextPath}/javascript/statisticsjs.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <title>Štatistiky</title>
    </head>
    <body>
        <%
            List<TopCompany> companies = (List<TopCompany>) request.getAttribute(RequestAttributeNames.TOP_COMPANIES_BY_TOTAL_AMOUNT);
            List<TopCompany> companiesByNrOfInvoices = (List<TopCompany>) request.getAttribute(RequestAttributeNames.TOP_COMPANIES_BY_NR_OF_INVOICES);
            List<InvoiceEntity> topInvoices = (List<InvoiceEntity>) request.getAttribute(RequestAttributeNames.ALL_INVOICES);
            List<GrantEntity> topGrants = (List<GrantEntity>) request.getAttribute(RequestAttributeNames.ALL_GRANTS);
            List<ContractEntity> topContracts = (List<ContractEntity>) request.getAttribute(RequestAttributeNames.ALL_CONTRACTS);
            List<OrderEntity> topOrders = (List<OrderEntity>) request.getAttribute(RequestAttributeNames.ALL_ORDERS);
        %>
        <jsp:include page="topMenu.jsp" />
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'companies')" id="defaultOpen">Top firmy</button>
            <button class="tablinks" onclick="openCity(event, 'invoices')">Top faktúry</button>
            <button class="tablinks" onclick="openCity(event, 'grants')">Top dotácie</button>
            <button class="tablinks" onclick="openCity(event, 'contracts')">Top zmluvy</button>
            <button class="tablinks" onclick="openCity(event, 'orders')">Top objednávky</button>
        </div>
        <div id="companies" class="tabcontent">
            <div class = "table-top-container" style="height: 400px; width: 550px; float: left">
                <h4>Top 100 firiem podľa hodnoty vyplatených faktúr</h4>
                <div class="table-container"  style="float: left">
                    <div></div>
                    <table cellspacing="0" class="statisticstable" style="height: 400px;  width: 550px; float: left;">
                        <thead>
                            <!--<div style="top: 0"><caption> Top 100 firiem podľa hodnoty vyplatených faktúr </caption> </div>-->
                            <tr>
                                <th class="sorttable_nosort"><div></div></th>
                                <th class="sorttable_nosort"  style="width: 350px; max-width: 350px"><div> Firma </div></th>
                                <th><div style="width: 150px">Suma</div></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i = (int) 0; i < companies.size(); i++) {
                                    TopCompany tc = companies.get(i);
                            %>
                            <tr>
                                <td style="width: 10px; text-align: center"><%= i + 1%>.</td>
                                <td><a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + tc.getIco()%>"><%=tc.getName()%></a> </td>
                                <td class="price_cell" style="width: 150px; text-align: center"><%=TableDataFormatter.priceFormatter(tc.getAmount(), "EUR")%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class = "table-top-container" style="height: 400px; width: 550px; float: right">
                <h4>Top 100 firiem podľa počtu vyplatených faktúr</h4>
                <div class="table-container" style="float: right">
                    <div></div>
                    <table cellspacing="0" class="statisticstable" style="height: 400px; width: 550px;">
                        <thead>
                            <tr>
                                <th class="sorttable_nosort"><div></div></th>
                                <th class="sorttable_nosort" style="width: 430px; max-width: 430px"><div> Firma </div></th>
                                <th><div>Počet</div></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i = (int) 0; i < companiesByNrOfInvoices.size(); i++) {
                                    TopCompany tc = companiesByNrOfInvoices.get(i);
                            %>
                            <tr>
                                <td style="width: 10px; text-align: center"><%= i + 1%>.</td>
                                <td><a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + tc.getIco()%>"><%=tc.getName()%></a> </td>
                                <td style="text-align: left"><%=tc.getAmount()%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div id="invoices" class="tabcontent">
            <div class = "table-top-container" style="height: 400px; width: 100%; float: left">
                <h4>Top 100 faktúr podľa vyplatenej sumy</h4>
                <div class="table-container">
                    <div></div>
                    <table cellspacing="0" class="statisticstable" id="sortable" style="height: 400px;  width: 100%;">
                        <tr>      
                            <th class="sorttable_nosort"><div></div></th>
                            <th class="sorttable_nosort" style="width: 250px; max-width: 250px"><div>Dodávateľ</div></th>
                            <th class="sorttable_nosort" style="width: 350px; max-width: 350px"><div>Účel platby</div></th>
                            <th><div>Dátum zverejnenia</div></th>
                            <th><div>Zmluva / Objednávka</div></th>
                            <th style="text-align: center;"><div style="width: 200px">Cena</div></th>
                        </tr>
                        <% for (int i = (int) 0; i < topInvoices.size(); i++) {
                                InvoiceEntity invoice = topInvoices.get(i);
                                String contractOrOrderUrl = "", contractOrOrderHref = "";
                                if (invoice.getContractNr() != null) {
                                    contractOrOrderUrl = "/" + Urls.ALL_CONTRACTS_URL + "/" + Urls.CONTRACT_DETAIL + UrlParameters.CONTRACT_DETAIL_NR_PARAMETER.getURLParameter() + invoice.getContractNr();
                                    contractOrOrderHref = (String) TableDataFormatter.dataOrEmptyString(invoice.getContractNr());
                                } else if (invoice.getOrderNr() != null) {
                                    contractOrOrderUrl = "/" + Urls.ALL_ORDERS_URL + "/" + Urls.ORDER_DETAIL + UrlParameters.ORDER_DETAIL_NR_PARAMETER.getURLParameter() + invoice.getOrderNr();
                                    contractOrOrderHref = (String) TableDataFormatter.dataOrEmptyString(invoice.getOrderNr());
                                }
                        %>
                        <tr>  
                            <td style="width: 10px; text-align: center"><%=i + 1%>.</td>
                            <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + invoice.getSupplierIco()%>"><%= invoice.getSupplier()%></a> </td>
                            <td><%=TableDataFormatter.formatTextData(invoice.getPaymentDescription())%></td>
                            <td style="text-align: center"><%=TableDataFormatter.dateFormatter(invoice.getReleaseDate())%></td>
                            <td style="text-align: center"> <a href="${pageContext.request.contextPath}<%=contractOrOrderUrl%>"><%= contractOrOrderHref%></a> </td>
                            <td class="price_cell" style="text-align: center"><%=TableDataFormatter.priceFormatter(invoice.getPrice(), invoice.getCurrency())%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
        <div id="grants" class="tabcontent">
            <div class = "table-top-container" style="height: 400px; width: 100%; float: left">
                <h4>Top 100 dotácií podľa vyplatenej sumy</h4>
                <div class="table-container">
                    <div></div>
                    <table cellspacing="0" class="statisticstable" id="sortable" style="height: 400px;  width: 100%;">
                        <tr style=>
                            <th class="sorttable_nosort"><div></div></th>
                            <th class="sorttable_nosort" style="width: 350px; max-width: 350px"><div style="width: 100px;">Žiadateľ</div></th>
                            <th class="sorttable_nosort" style="width: 400px; max-width: 400px"><div  style="width: 100px;">Akcia</div></th>
                            <th style="width: 170px"><div style="width: 200px">Rok dotácie</div></th>
                            <th><div style="width: 200px">Schválená suma</div></th>
                        </tr>
                        <% for (int i = (int) 0; i < topGrants.size(); i++) {
                                GrantEntity grant = topGrants.get(i);
                        %>
                        <tr>  
                            <td style="width: 10px; text-align: center"><%=i + 1%>.</td>
                            <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + grant.getApplicantIco()%>"><%= grant.getApplicant()%></a> </td>
                            <td><%=TableDataFormatter.formatTextData(grant.getAction())%></td>
                            <td style="text-align: center"><%=TableDataFormatter.dataOrEmptyString(grant.getGrantYear())%></td>
                            <td class="price_cell" style="text-align: center"><%=TableDataFormatter.priceFormatter(grant.getApprovedGrant(), grant.getCurrency())%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
        <div id="contracts" class="tabcontent">
            <div class = "table-top-container" style="height: 400px; width: 100%; float: left">
                <h4>Top 100 zmlúv podľa ceny</h4>
                <div class="table-container">
                    <div></div>
                    <table cellspacing="0" class="statisticstable" id="sortable" style="height: 400px;  width: 100%;">
                        <tr>
                            <th class="sorttable_nosort" style="width: 10px"><div></div></th>
                            <th class="sorttable_nosort" style="width: 300px; max-width: 350px"><div style="width: 100px;"> Kontraktor</div></th>
                            <th class="sorttable_nosort" style="width: 450px; max-width: 450px"><div style="width: 130px;">Predmet</div></th>
                            <th><div style="width:150px">Dátum podpisu</div></th>
                            <th><div style="width:150px">Cena</div></th>
                            <th class="sorttable_nosort"><div>Detail</div></th>
                        </tr>
                        <% for (int i = 0; i < topContracts.size(); i++) {
                                ContractEntity contract = topContracts.get(i);
                                String parties = contract.getParties();
                                String party1 = TableDataFormatter.formatParties(parties, 0);
                                String party2 = TableDataFormatter.formatParties(parties, 1);
                                String nonPresovParty = party1.contains("Mesto Prešov") ? party2 : party1;
                        %>
                        <tr>  
                            <td style="width: 10px; text-align: center"><%=i + 1%>.</td>
                            <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + ContractEntityDAO.getIcoFromContract(contract, nonPresovParty)%>"><%=nonPresovParty%></a> </td>
                            <td><%=TableDataFormatter.formatTextData(contract.getSubject())%></td>
                            <td style="text-align: center"><%=TableDataFormatter.dateFormatter(contract.getSignatureDate())%></td>
                            <td class= "price_cell" style="width:140px; text-align: center"><%=TableDataFormatter.priceFormatter(contract.getPrice(), contract.getCurrency())%></td>
                            <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_CONTRACTS_URL + "/" + Urls.CONTRACT_DETAIL + UrlParameters.CONTRACT_DETAIL_NR_PARAMETER.getURLParameter() + contract.getContractNr()%>"><i class="glyphicon glyphicon-zoom-in"></i></a> </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
        <div id="orders" class="tabcontent">
            <div class = "table-top-container" style="height: 400px; width: 100%; float: left">
                <h4>Top 100 objednávok podľa hodnoty</h4>
                <div class="table-container">
                    <div></div>
                    <table cellspacing="0" class="statisticstable" id="sortable" style="height: 400px;  width: 100%;">
                        <tr> 
                            <th class="sorttable_nosort"><div></div></th>
                            <th class="sorttable_nosort" style="width: 250px; max-width: 250px"><div style="width: 100px;">Dodávateľ</div></th>
                            <th class="sorttable_nosort" style="width: 500px; max-width: 500px"><div style="width: 150px;">Text objednávky</div></th>
                            <th style="width: 120px"><div style="width: 150px">Dátum vystavenia</div></th>
                            <th><div style="width: 100px">Hodnota</div></th>
                            <th class="sorttable_nosort"><div style="width: 100px">Detail</div></th>
                        </tr>
                        <% for (int i = (int) 0; i < topInvoices.size(); i++) {
                                OrderEntity order = topOrders.get(i);
                        %>
                        <tr>  
                            <td style="width: 10px; text-align: center"><%=i + 1%>.</td>
                            <td> <a href="${pageContext.request.contextPath}<%="/" + Urls.PARTY_DETAIL + UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getURLParameter() + order.getIco()%>"><%= order.getSupplier()%></a> </td>
                            <td class="text_cell" style="width: 400px; max-width: 400px"><%=TableDataFormatter.formatTextData(order.getOrderText())%></td>
                            <td style="width: 150px; text-align: center"><%=TableDataFormatter.dateFormatter(order.getIssueDate())%></td>
                            <td class="price_cell" style="text-align: center"><%=TableDataFormatter.priceFormatter(order.getValue(), order.getCurrency())%></td>
                            <td style="width: 100px; text-align: center"> <a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_ORDERS_URL + "/" + Urls.ORDER_DETAIL + UrlParameters.ORDER_DETAIL_NR_PARAMETER.getURLParameter() + order.getOrderNr()%>"> <i class="glyphicon glyphicon-zoom-in"></i> </a> </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script>
        document.getElementById("defaultOpen").click();
    </script>
</html>
