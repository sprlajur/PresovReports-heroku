/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.OrderEntityDAO;
import constants.RequestAttributeNames;
import constants.UrlParameters;
import constants.Urls;
import entity.OrderEntity;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sprlajur
 */
@WebServlet(Urls.ALL_ORDERS_URL + "/" +Urls.ORDER_DETAIL)
public class OrderDetailServlet extends AbstractServlet {

    private final String ORDER_DETAIL_JSP_FILE_PATH = "/JSPpages/orderDetail.jsp";
    private final String ORDER_NOT_FOUND_JSP_FILE_PATH = "/JSPpages/orderNotFound.jsp";
    private OrderEntityDAO orderEntityDAO;

    @Override
    public void init() {
        orderEntityDAO = new OrderEntityDAO(entityManager);
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
        response.setContentType("text/html;charset=UTF-8");
        OrderEntity order = null;
        try {
            String orderNr = request.getParameter(UrlParameters.ORDER_DETAIL_NR_PARAMETER.getParameter());
            order = orderEntityDAO.findByInternalNr(orderNr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String nextJSP = order == null ? ORDER_NOT_FOUND_JSP_FILE_PATH : ORDER_DETAIL_JSP_FILE_PATH;
        if(order != null){
            request.setAttribute(RequestAttributeNames.ORDER, order);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
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
