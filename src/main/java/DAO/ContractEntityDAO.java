/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.ContractEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author sprlajur
 */
public class ContractEntityDAO extends AbstractEntityDAO {

    public ContractEntityDAO(EntityManager em) {
        this.entityManager = em;
    }

    public List<ContractEntity> getAllContracts() {
        return entityManager.createNamedQuery(ContractEntity.Q_CONTRACT_ENTITY_FIND_ALL)
                .getResultList();
    }
    
    public List<ContractEntity> getContractsByICO(String ico) {
        return entityManager.createNamedQuery(ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_ICO)
                .setParameter(ContractEntity.SQL_PARAM_ICO, wrapInPercentageSigns(ico))
                .getResultList();
    }
    
    public List<ContractEntity> getTopContractsByPrice() {
        return entityManager.createNamedQuery(ContractEntity.Q_CONTRACT_ENTITY_FIND_TOP_BY_PRICE)
                .setFirstResult(0)
                .setMaxResults(100)
                .getResultList();
    }

    public static String getIcoFromContract(ContractEntity contract, String partyName) {
        String[] partiesICOs = contract.getPartiesIco().split(";;");
        for (String partiesICO : partiesICOs) {
            if (partiesICO.contains(partyName)) {
                return partiesICO.replaceAll("[^0-9]", "");
            }
        }
        return null;
    }

    public ContractEntity getContractByID(Integer id) {
        return entityManager.find(ContractEntity.class, id);
    }

    public ContractEntity getContractByContractNr(String contractNr) {
        return entityManager.createNamedQuery(ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_CONTRACT_NR, ContractEntity.class)
                .setParameter(ContractEntity.SQL_PARAM_CONTRACT_NR, contractNr)
                .getSingleResult();
    }

    public List<ContractEntity> getContractsByFilter(String party, String text, Date from, Date to) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ContractEntity> query = cb.createQuery(ContractEntity.class);
        Root<ContractEntity> c = query.from(ContractEntity.class);
        query.select(c);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (party != null && !party.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("parties")), wrapInPercentageSignsLowerCase(party)));
        }
        if (text != null && !text.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("subject")), wrapInPercentageSignsLowerCase(text)));
        }
        if (from != null) {
            Predicate greaterThanOrEqualTo = cb.greaterThanOrEqualTo(c.get("signatureDate").as(java.util.Date.class), from);
            predicates.add(greaterThanOrEqualTo);
        }
        if (to != null) {
            Predicate lessThanOrEqualTo = cb.lessThanOrEqualTo(c.get("signatureDate").as(java.util.Date.class), to);
            predicates.add(lessThanOrEqualTo);
        }
        return entityManager.createQuery(query.where(cb.and(predicates.toArray(new Predicate[0])))).getResultList();
    }
}
