<%-- 
    Document   : mainSearch
    Created on : May 1, 2018, 1:26:05 PM
    Author     : sprlajur
--%>

<%@page import="presentation.TableDataFormatter"%>
<%@page import="constants.RequestAttributeNames"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/mainSearchStyles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="${pageContext.request.contextPath}/javascript/datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/javascript/datepicker-sk.js"></script>
        <script>
            $(function () {
                $('.datepicker').datepicker(
                        $.extend({
                            changeYear: true,
                            changeMonth: true
                        },
                                $.datepicker.regional['sk']));
            });
            function clearForms()
            {
                $(':input').not(':button, :submit, :reset, :hidden, :checkbox, :radio').val('');
                $(':checkbox, :radio').prop('checked', false);
            }
        </script>
    </head>
    <%
        String dateCellType = request.getParameter("dateCellType");
        if(dateCellType == null || dateCellType.isEmpty()){
            dateCellType = "text";
        }
        %>
    <form id="searchForm" action="${requestScope['javax.servlet.forward.request_uri']}"  method="post">
        <div style="color: white; font-size: 20px"> Filter </div>
        <table class="filter-table" align="center">
            <tr>
                <td><input class="s" type="text" name="<%=RequestAttributeNames.SEARCHED_PARTY%>" placeholder="Názov firmy" value="<%=TableDataFormatter.dataOrEmptyString(request.getParameter(RequestAttributeNames.SEARCHED_PARTY))%>"></td> 
                <td><input class="s" type="text" name="<%=RequestAttributeNames.SEARCHED_TEXT%>" placeholder="Text predmetu" value="<%=TableDataFormatter.dataOrEmptyString(request.getParameter(RequestAttributeNames.SEARCHED_TEXT))%>"></td>
                <td id="dateCell"><input type="<%=dateCellType %>" name="from" class="datepicker" placeholder="Dátum od" value="<%=TableDataFormatter.dataOrEmptyString(request.getParameter("from"))%>"></td> 
                <td id="dateCell"><input type="<%=dateCellType %>" name="to" class="datepicker" placeholder="Dátum do" value="<%=TableDataFormatter.dataOrEmptyString(request.getParameter("to"))%>"></td>
                <td id= "buttonsCell"><button class="button" id="submitButton" type="submit"><i class="glyphicon glyphicon-search"></i></button><button class="button" id="clearValuesButton" onclick="clearForms()"><i class="glyphicon glyphicon-filter"></i></button> </td>
            </tr>
        </table>
    </form>
</html>
