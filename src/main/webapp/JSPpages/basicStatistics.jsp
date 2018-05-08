<%-- 
    Document   : basicStatistics
    Created on : May 8, 2018, 11:47:33 AM
    Author     : sprlajur
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="constants.RequestAttributeNames"%>
<%@page import="presentation.TableDataFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            BigDecimal sum = new BigDecimal(0);
            if (request.getAttribute(RequestAttributeNames.ENTITY_SUM) != null) {
                sum = (BigDecimal) request.getAttribute(RequestAttributeNames.ENTITY_SUM);
            }
        %>
        <div class="basicinfo" style="height:30px;">
            <strong style="width:170px">Počet záznamov: </strong> <span><%=TableDataFormatter.dataOrEmptyString(request.getAttribute(RequestAttributeNames.ENTITY_SIZE))%></span>
            <strong style="width:170px">Celková hodnota: </strong> <span><%=TableDataFormatter.priceFormatter(sum, "EUR")%></span>
        </div>
    </body>
</html>
