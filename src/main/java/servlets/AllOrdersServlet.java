/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.OrderEntityDAO;
import constants.RequestAttributeNames;
import constants.Urls;
import entity.OrderEntity;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sprlajur
 */
@WebServlet(Urls.ALL_ORDERS_URL)
public class AllOrdersServlet extends AbstractServlet {

    private OrderEntityDAO orderEntityManager;
    private final String JSP_FILE_PATH = "/JSPpages/allOrders.jsp";

    @Override
    public void init() {
        orderEntityManager = new OrderEntityDAO(entityManager);
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
        List<OrderEntity> orders = orderEntityManager.findAll();
        setPaginationParameters(request, orders == null ? 0 : orders.size());
        request.setAttribute(RequestAttributeNames.ALL_ORDERS, orders);
        if (orders != null) {
            List<BigDecimal> values = orders.stream().map(order -> order.getValue()).collect(Collectors.toList());
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
        List<OrderEntity> orders = null;
        if (!searchedParty.isEmpty() || !searchedText.isEmpty() || from != null || to != null) {
            orders = orderEntityManager.getOrdersByFilter(searchedParty, searchedText, from, to);
            setPaginationParameters(request, orders == null ? 0 : orders.size());
            request.setAttribute(RequestAttributeNames.ALL_ORDERS, orders);
            if (orders != null) {
                List<BigDecimal> values = orders.stream().map(order -> order.getValue()).collect(Collectors.toList());
                setTotalValueAttribute(values, request);
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSP_FILE_PATH);
            dispatcher.forward(request, response);
        } else {
            doGet(request, response);
        }
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
