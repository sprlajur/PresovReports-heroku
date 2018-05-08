/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import constants.RequestAttributeNames;
import constants.Urls;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import presentation.TableDataFormatter;

/**
 *
 * @author sprlajur
 */
public abstract class AbstractServlet extends HttpServlet {

    @PersistenceContext
    EntityManager entityManager;

    protected String searchedParty;
    protected String searchedText;
    protected Date from;
    protected Date to;

    public void setPaginationParameters(HttpServletRequest request, int entityCount) {
        int currentPage = 1;
        int lastPage = (int) Math.ceil(entityCount / (double) Urls.RECORDS_PER_PAGE);
        try {
            currentPage = Integer.parseInt(request.getParameter("pageNr"));
        } catch (NumberFormatException e) {
            currentPage = 1;
        }
        currentPage = currentPage > lastPage ? lastPage : currentPage;
        currentPage = currentPage < 1 ? 1 : currentPage;
        int startIndex = (currentPage - 1) * Urls.RECORDS_PER_PAGE;
        int endIndex = Math.min(startIndex + Urls.RECORDS_PER_PAGE, entityCount);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lastPage", lastPage);
        request.setAttribute("startIndex", startIndex);
        request.setAttribute("endIndex", endIndex);
        System.out.println("ei:" + endIndex);
        request.setAttribute(RequestAttributeNames.ENTITY_SIZE, entityCount);
    }

    public void setFilterParameters(HttpServletRequest request) {
        searchedParty = request.getParameter(RequestAttributeNames.SEARCHED_PARTY);
        searchedText = request.getParameter(RequestAttributeNames.SEARCHED_TEXT);
        String fromStr = request.getParameter(RequestAttributeNames.DATE_FROM);
        String toStr = request.getParameter(RequestAttributeNames.DATE_TO);
        from = null;
        to = null;
        DateFormat formatter = new SimpleDateFormat(TableDataFormatter.DATE_PATTERN);
        try {
            if (fromStr != null) {
                from = formatter.parse(request.getParameter(RequestAttributeNames.DATE_FROM));
            }
            if (toStr != null) {
                to = formatter.parse(request.getParameter(RequestAttributeNames.DATE_TO));
            }
        } catch (ParseException ex) {
        }
    }

    public void setTotalValueAttribute(List<BigDecimal> values, HttpServletRequest request) {
        BigDecimal sum = values.stream().filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
        request.setAttribute(RequestAttributeNames.ENTITY_SUM, sum);
    }
}
