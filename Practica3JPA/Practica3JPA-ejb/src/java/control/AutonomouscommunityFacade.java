/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Autonomouscommunity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ignacio
 */
@Stateless
public class AutonomouscommunityFacade extends AbstractFacade<Autonomouscommunity> {

    @PersistenceContext(unitName = "Practica3JPA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutonomouscommunityFacade() {
        super(Autonomouscommunity.class);
    }
    
}
