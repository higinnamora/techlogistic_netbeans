/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aurac
 */
@Stateless
public class MateriaPrimaFacade extends AbstractFacade<MateriaPrima> {

    @PersistenceContext(unitName = "techlogistic2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaPrimaFacade() {
        super(MateriaPrima.class);
    }
    
}
