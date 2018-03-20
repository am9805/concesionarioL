/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Automovil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejo Castaño Rojas
 */
@Stateless
public class AutomovilManager implements AutomovilManagerLocal {

    @PersistenceContext(unitName = "com.udea_concesionarioL_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Automovil> getAllAutomoviles() {
        Query query = em.createNamedQuery("Automovil.findAll");
        return query.getResultList();
    }
    @Override
    public Automovil getAutomovil(int idAutomovil) {
        Query query = em.createNamedQuery("Automovil.findAll");
        List<Automovil> automoviles = query.getResultList();
        if (!automoviles.isEmpty()) {
            for (Automovil auto : automoviles) {
                if (auto.getIdAutomovil() == idAutomovil) {
                    return auto;
                }
            }
        }
        return null;
    }
    @Override
    public Automovil update(Automovil automovil) {
        return em.merge(automovil);
    }

    
    @Override
    public void vendido(int idAutomovil) {
        Query query = em.createNamedQuery("Automovil.replace");
//        Automovil auto = getAutomovil(idAutomovil);
//        auto.setEnVenta(false);
        query.setParameter("idAutomovil", idAutomovil);
//        return auto;
    }

    

}
