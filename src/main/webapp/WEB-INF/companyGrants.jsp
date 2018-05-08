<%-- 
    Document   : companyContracts
    Created on : May 6, 2018, 2:44:14 PM
    Author     : sprlajur
--%>

<%@page import="entity.GrantEntity"%>
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
            List<GrantEntity> grants = (List<GrantEntity>) request.getAttribute(RequestAttributeNames.ALL_GRANTS);
        %>
        <table class="companytable">
            <caption>Dotácie od mesta Prešov</caption>
            <tr>
                <th>Akcia</th>
                <th>Rok dotácie</th>
                <th>Stav vybavenia</th>
                <th>Schválené prostriedky</th>
            </tr>
            <%
                if (grants != null) {
                    for (int i = 0; i < grants.size(); i++) {
                        GrantEntity grant = grants.get(i);
            %>
            <tr>      
                <td><%=TableDataFormatter.formatTextData(grant.getAction())%></td>
                <td><%=TableDataFormatter.dataOrEmptyString(grant.getGrantYear())%></td>
                <td><%=TableDataFormatter.dataOrEmptyString(grant.getStatus())%></td> 
                <td><%=TableDataFormatter.priceFormatter(grant.getApprovedGrant(), grant.getCurrency())%></td>
            </tr>
            <%}
                }
            %>
        </table>
    </body>
</html>
