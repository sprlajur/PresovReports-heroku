/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.InvoiceEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import presentation.TopCompany;

/**
 *
 * @author sprlajur
 */
public class InvoiceEntityDAO extends AbstractEntityDAO {

    public InvoiceEntityDAO(EntityManager em) {
        this.entityManager = em;
    }

    public List<InvoiceEntity> findAll() {
        return entityManager.createNamedQuery(InvoiceEntity.Q_INVOICE_ENTITY_FIND_ALL, InvoiceEntity.class)
                .getResultList();
    }

    public List<TopCompany> getTopCompaniesByTotalAmount() {
        return entityManager.createNamedQuery(InvoiceEntity.Q_INVOICE_ENTITY_FIND_TOP_SUPPLIERS_BY_TOTAL_AMOUNT)
                .setFirstResult(0)
                .setMaxResults(100)
                .getResultList();
    }

    public List<TopCompany> getTopCompaniesByNumberOfInvoices() {
        return entityManager.createNamedQuery(InvoiceEntity.Q_INVOICE_ENTITY_FIND_TOP_SUPPLIERS_BY_NR_OF_INVOICES)
                .setFirstResult(0)
                .setMaxResults(100)
                .getResultList();
    }
    
    public List<InvoiceEntity> getTopInvoicesByPrice() {
        return entityManager.createNamedQuery(InvoiceEntity.Q_INVOICE_ENTITY_FIND_TOP_INVOICES_BY_PRICE)
                .setFirstResult(0)
                .setMaxResults(100)
                .getResultList();
    }

    public List<InvoiceEntity> getInvoicesByFilter(String party, String text, Date from, Date to) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InvoiceEntity> query = cb.createQuery(InvoiceEntity.class);
        Root<InvoiceEntity> c = query.from(InvoiceEntity.class);
        query.select(c);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (party != null && !party.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("supplier")), "%" + party.toLowerCase() + "%"));
        }
        if (text != null && !text.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("paymentDescription")), "%" + text.toLowerCase() + "%"));
        }
        if (from != null) {
            Predicate greaterThanOrEqualTo = cb.greaterThanOrEqualTo(c.get("releaseDate").as(java.util.Date.class), from);
            predicates.add(greaterThanOrEqualTo);
        }
        if (to != null) {
            Predicate lessThanOrEqualTo = cb.lessThanOrEqualTo(c.get("releaseDate").as(java.util.Date.class), to);
            predicates.add(lessThanOrEqualTo);
        }
        return entityManager.createQuery(query.where(cb.and(predicates.toArray(new Predicate[0])))).getResultList();
    }
}
