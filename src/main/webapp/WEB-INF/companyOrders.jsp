<%-- 
    Document   : companyContracts
    Created on : May 6, 2018, 2:44:14 PM
    Author     : sprlajur
--%>

<%@page import="entity.OrderEntity"%>
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
    </head>
    <body>
        <%
            List<OrderEntity> orders = (List<OrderEntity>) request.getAttribute(RequestAttributeNames.ALL_ORDERS);
            int height = orders.size() > 2 ? 300 : 120;
        %>
        <div class = "table-top-container" style="height: <%=(height + 50)%>px; width: 100%">
            <h4>Objednávky od mesta Prešov</h4>
            <div class="table-container">
                <div></div>
                <table cellspacing="0" class="statisticstable" id="sortable" style="height: <%=(height)%>px;  width: 100%;">
                    <thead>
                        <tr>
                            <th class="sorttable_nosort" style="width: 600px; max-width: 600px"><div style="width:600px;">Text objednávky</div></th>
                            <th><div style="width:150px">Dátum vystavenia</div></th>
                            <th><div style="width:150px">Stav vybavenia</div></th>
                            <th><div style="width:150px">Hodnota</div></th>
                            <th class="sorttable_nosort"><div style="width:150px"></div></th>
                        </tr>
                    </thead>
                    <%
                        if (orders != null) {
                            for (int i = 0; i < orders.size(); i++) {
                                OrderEntity order = orders.get(i);
                    %>
                    <tr>      
                        <td class="text_cell" style="width: 500px; max-width: 500px"><%=TableDataFormatter.formatTextData(order.getOrderText())%></td>
                        <td style="width: 150px; text-align: center"><%=TableDataFormatter.dateFormatter(order.getIssueDate())%></td>
                        <td style="width: 150px; text-align: center"><%=TableDataFormatter.dataOrEmptyString(order.getCompletenessStatus())%></td> 
                        <td style="width: 150px; text-align: center"><%=TableDataFormatter.priceFormatter(order.getValue(), order.getCurrency())%></td>
                        <td style="width: 150px; text-align: center"> <a href="${pageContext.request.contextPath}<%="/" + Urls.ALL_ORDERS_URL + "/" + Urls.ORDER_DETAIL + UrlParameters.ORDER_DETAIL_NR_PARAMETER.getURLParameter() + order.getOrderNr()%>"> <i class="glyphicon glyphicon-zoom-in"></i> </a> </td>
                    </tr>
                    <%}
                        }
                    %>
                </table>
            </div>
        </div>

    </body>
</html>
