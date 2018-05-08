/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.ContractEntityDAO;
import DAO.GrantEntityDAO;
import DAO.OrderEntityDAO;
import constants.RequestAttributeNames;
import constants.UrlParameters;
import constants.Urls;
import entity.ContractEntity;
import entity.GrantEntity;
import entity.OrderEntity;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rpo.RPOApiDataGetter;
import rpo.*;

/**
 *
 * @author sprlajur
 */
@WebServlet(Urls.PARTY_DETAIL)
public class PartyDetailServlet extends AbstractServlet {

    private final String PARTY_DETAIL_JSP_FILE_PATH = "/JSPpages/partyDetail.jsp";
    private final String PARTY_NOT_FOUND_JSP_FILE_PATH = "/JSPpages/partyNotFound.jsp";

    private ContractEntityDAO contractEntityManager;
    private GrantEntityDAO grantEntityManager;
    private OrderEntityDAO orderEntityManager;

    @Override
    public void init() {
        contractEntityManager = new ContractEntityDAO(entityManager);
        grantEntityManager = new GrantEntityDAO(entityManager);
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
        response.setContentType("text/html;charset=UTF-8");
        String ico = request.getParameter(UrlParameters.PARTY_DETAIL_ICO_PARAMETER.getParameter());
        RPOLegalPerson person = null;
        List<ContractEntity> contracts = null;
        List<GrantEntity> grants = null;
        List<OrderEntity> orders = null;
        if (ico != null && !ico.isEmpty()) {
            person = RPOApiDataGetter.getRPOData(ico);
            contracts = contractEntityManager.getContractsByICO(ico);
            grants = grantEntityManager.findByIco(ico);
            orders = orderEntityManager.findByIco(ico);
        }
        request.setAttribute(RequestAttributeNames.LEGAL_PERSON, person);
        request.setAttribute(RequestAttributeNames.ALL_CONTRACTS, contracts);
        request.setAttribute(RequestAttributeNames.ALL_GRANTS, grants);
        request.setAttribute(RequestAttributeNames.ALL_ORDERS, orders);
        String nextJSP = person == null ? PARTY_NOT_FOUND_JSP_FILE_PATH : PARTY_DETAIL_JSP_FILE_PATH;
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
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
