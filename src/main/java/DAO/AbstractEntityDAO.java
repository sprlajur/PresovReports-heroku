/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;

/**
 *
 * @author sprlajur
 */
public abstract class AbstractEntityDAO {

    EntityManager entityManager;
    
    public String wrapInPercentageSigns(String string) {
        return "%" + string + "%";
    }
    
    public String wrapInPercentageSignsLowerCase(String string) {
        return "%" + string.toLowerCase() + "%";
    }
}
