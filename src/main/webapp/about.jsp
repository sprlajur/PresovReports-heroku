<%-- 
    Document   : about
    Created on : May 8, 2018, 1:54:07 PM
    Author     : sprlajur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>O projekte</title>
    </head>
    <body>
        <jsp:include page="topMenu.jsp" />
        <h2>O projekte</h2>
        <p style="width: 70%">
            Táto webstránka prezentuje ekonomické dáta mesta Prešov. 
            Obsahuje prehľad všetkých zmlúv, ktoré mesto uzavrelo, objednávok, ktoré vyhotovilo, faktúr,
            ktoré vyplatilo a podané žiadosti o dotáciu. Tieto dáta sú zverejňované v zmysle zákona č. 211/2000 Z. z.
            o slobodnom prístupe k informáciám na stránke <a href="http://egov.presov.sk/Default.aspx?NavigationState=400:0:">egov.presov.sk</a>.
            Naviac stránka ponúka dáta z Registra právnických osôb o firmách, s ktorými mesto spolupracuje, poskytované cez API inciatívou <a href="http://slovensko.digital">slovensko.digital</a>
            a základné štatistiky týchto dát.
            <br>
            <br>
            <strong>Posledná aktualizácia dát:</strong> 8.5.2018.
        </p>
    </body>
</html>
