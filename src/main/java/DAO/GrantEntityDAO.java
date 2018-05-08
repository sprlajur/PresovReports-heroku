/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.GrantEntity;
import java.util.ArrayList;
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
public class GrantEntityDAO extends AbstractEntityDAO {
    
    public GrantEntityDAO(EntityManager em){
        this.entityManager = em;
    }
    
    public List<GrantEntity> findAll(){
        return entityManager.createNamedQuery(GrantEntity.Q_GRANT_ENTITY_FIND_ALL)
                .getResultList();
    }
    
    public List<GrantEntity> findByIco(String ico){
        return entityManager.createNamedQuery(GrantEntity.Q_GRANT_ENTITY_FIND_BY_ICO)
                .setParameter(GrantEntity.SQL_PARAM_ICO, ico)
                .getResultList();
    }
    
    public List<GrantEntity> getTopGrantsByPrice(){
        return entityManager.createNamedQuery(GrantEntity.Q_GRANT_ENTITY_FIND_TOP_BY_PRICE)
                .getResultList();
    }

    public List<GrantEntity> getGrantsByFilter(String party, String text) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GrantEntity> query = cb.createQuery(GrantEntity.class);
        Root<GrantEntity> c = query.from(GrantEntity.class);
        query.select(c);
        List<Predicate> predicates = new ArrayList<>();
        if (party != null && !party.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("applicant")), wrapInPercentageSignsLowerCase(party)));
        }
        if (text != null && !text.isEmpty()) {
            predicates.add(cb.like(cb.lower(c.<String>get("action")), wrapInPercentageSignsLowerCase(text)));
        }
        return entityManager.createQuery(query.where(cb.and(predicates.toArray(new Predicate[0])))).getResultList();
    }
}
