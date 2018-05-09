/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.ContractEntityDAO;
import constants.RequestAttributeNames;
import constants.Urls;
import entity.ContractEntity;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sprlajur
 */
@WebServlet(Urls.ALL_CONTRACTS_URL)
public class AllContractsServlet extends AbstractServlet {

    private ContractEntityDAO contractEntityManager;
    private final String JSP_FILE_PATH = "WEB-INF/allContracts.jsp";

    @Override
    public void init() {
        contractEntityManager = new ContractEntityDAO(entityManager);
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
        List<ContractEntity> contracts = contractEntityManager.getAllContracts();
        setPaginationParameters(request, contracts == null ? 0 : contracts.size());
        request.setAttribute(RequestAttributeNames.ALL_CONTRACTS, contracts);
        if (contracts != null) {
            List<BigDecimal> values = contracts.stream().map(contract -> contract.getPrice()).collect(Collectors.toList());
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
        List<ContractEntity> contracts = null;
        if (!searchedParty.isEmpty() || !searchedText.isEmpty() || from != null || to != null) {
            contracts = contractEntityManager.getContractsByFilter(searchedParty, searchedText, from, to);
            setPaginationParameters(request, contracts == null ? 0 : contracts.size());
            if (contracts != null) {
                List<BigDecimal> values = contracts.stream().map(contract -> contract.getPrice()).collect(Collectors.toList());
                setTotalValueAttribute(values, request);
            }
            request.setAttribute(RequestAttributeNames.ALL_CONTRACTS, contracts);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(JSP_FILE_PATH);
            dispatcher.forward(request, response);
        } else {
            doGet(request, response);
        }
    }
}
