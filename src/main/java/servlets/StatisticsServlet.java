/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.ContractEntityDAO;
import DAO.GrantEntityDAO;
import DAO.InvoiceEntityDAO;
import DAO.OrderEntityDAO;
import constants.RequestAttributeNames;
import constants.Urls;
import entity.ContractEntity;
import entity.GrantEntity;
import entity.InvoiceEntity;
import entity.OrderEntity;
import java.io.IOException;
import java.util.List;
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
@WebServlet(Urls.STATISTICS)
public class StatisticsServlet extends AbstractServlet {

    private InvoiceEntityDAO invoiceEntityManager;
    private GrantEntityDAO grantEntityManager;
    private ContractEntityDAO contractEntityManager;
    private OrderEntityDAO orderEntityManager;
    private final String JSP_FILE_PATH = "/JSPpages/statistics.jsp";

    @Override
    public void init() {
        invoiceEntityManager = new InvoiceEntityDAO(entityManager);
        grantEntityManager = new GrantEntityDAO(entityManager);
        contractEntityManager = new ContractEntityDAO(entityManager);
        orderEntityManager = new OrderEntityDAO(entityManager);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TopCompany> topCompaniesByTotalAmount = invoiceEntityManager.getTopCompaniesByTotalAmount();
        List<TopCompany> topCompaniesByNrOfInvoices = invoiceEntityManager.getTopCompaniesByNumberOfInvoices();
        List<InvoiceEntity> topInvoices = invoiceEntityManager.getTopInvoicesByPrice();
        List<GrantEntity> topGrants = grantEntityManager.getTopGrantsByPrice();
        List<ContractEntity> topContracts = contractEntityManager.getTopContractsByPrice();
        List<OrderEntity> topOrders = orderEntityManager.getTopOrdersByPrice();
        request.setAttribute(RequestAttributeNames.TOP_COMPANIES_BY_TOTAL_AMOUNT, topCompaniesByTotalAmount);
        request.setAttribute(RequestAttributeNames.TOP_COMPANIES_BY_NR_OF_INVOICES, topCompaniesByNrOfInvoices);
        request.setAttribute(RequestAttributeNames.ALL_INVOICES, topInvoices);
        request.setAttribute(RequestAttributeNames.ALL_GRANTS, topGrants);
        request.setAttribute(RequestAttributeNames.ALL_CONTRACTS, topContracts);
        request.setAttribute(RequestAttributeNames.ALL_ORDERS, topOrders);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSP_FILE_PATH);
        dispatcher.forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
