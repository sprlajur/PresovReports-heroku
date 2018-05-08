/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.InvoiceEntityDAO;
import constants.RequestAttributeNames;
import constants.Urls;
import entity.InvoiceEntity;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import presentation.TopCompany;

/**
 *
 * @author sprlajur
 */
@WebServlet(Urls.ALL_INVOICES_URL)
public class AllInvoicesServlet extends AbstractServlet {

    private InvoiceEntityDAO invoiceEntityManager;
    private final String JSP_FILE_PATH = "/JSPpages/allInvoices.jsp";

    @Override
    public void init() {
        invoiceEntityManager = new InvoiceEntityDAO(entityManager);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<InvoiceEntity> invoices = invoiceEntityManager.findAll();
        setPaginationParameters(request, invoices == null ? 0 : invoices.size());
        request.setAttribute(RequestAttributeNames.ALL_INVOICES, invoices);
        if (invoices != null) {
            List<BigDecimal> values = invoices.stream().map(invoice -> invoice.getPrice()).collect(Collectors.toList());
            setTotalValueAttribute(values, request);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSP_FILE_PATH);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        setFilterParameters(request);
        List<InvoiceEntity> invoices = null;
        if (!searchedParty.isEmpty() || !searchedText.isEmpty() || from != null || to != null) {
            invoices = invoiceEntityManager.getInvoicesByFilter(searchedParty, searchedText, from, to);
            setPaginationParameters(request, invoices == null ? 0 : invoices.size());
            request.setAttribute(RequestAttributeNames.ALL_INVOICES, invoices);
            if (invoices != null) {
                List<BigDecimal> values = invoices.stream().map(invoice -> invoice.getPrice()).collect(Collectors.toList());
                setTotalValueAttribute(values, request);
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSP_FILE_PATH);
            dispatcher.forward(request, response);
        } else {
            doGet(request, response);
        }
    }
}
