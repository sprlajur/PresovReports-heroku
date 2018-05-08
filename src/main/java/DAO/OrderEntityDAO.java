/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.OrderEntity;
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
public class OrderEntityDAO extends AbstractEntityDAO {

    public OrderEntityDAO(EntityManager em) {
        this.entityManager = em;
    }

    public List<OrderEntity> findAll() {
        return entityManager.createNamedQuery(OrderEntity.Q_ORDER_ENTITY_FIND_ALL, OrderEntity.class)
                .getResultList();
    }
    
    public List<OrderEntity> getTopOrdersByPrice() {
        return entityManager.createNamedQuery(OrderEntity.Q_ORDER_ENTITY_FIND_TOP_BY_PRICE, OrderEntity.class)
                .setFirstResult(0)
                .setMaxResults(100)
                .getResultList();
    }

    public OrderEntity findByInternalNr(String orderNr) {
        return entityManager.createNamedQuery(OrderEntity.Q_ORDER_ENTITY_FIND_BY_INTERNAL_NR, OrderEntity.class)
                .setParameter(OrderEntity.SQL_PARAM_INTERNAL_NR, orderNr)
                .getSingleResult();
    }
    
    public List<OrderEntity> findByIco(String ico) {
        return entityManager.createNamedQuery(OrderEntity.Q_ORDER_ENTITY_FIND_BY_ICO, OrderEntity.class)
                .setParameter(OrderEntity.SQL_PARAM_ICO, ico)
                .getResultList();
    }
    
    public List<OrderEntity> getOrdersByFilter(String party, String text, Date from, Date to) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> query = cb.createQuery(OrderEntity.class);
        Root<OrderEntity> c = query.from(OrderEntity.class);
        query.select(c);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (party != null && !party.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("supplier")), "%" + party.toLowerCase() + "%"));
        }
        if (text != null && !text.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("orderText")), "%" + text.toLowerCase() + "%"));
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
