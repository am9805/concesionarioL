/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Tipoautomovil;
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
public class TipoAutomovilManager implements TipoAutomovilManagerLocal {

    @PersistenceContext(unitName = "com.udea_concesionarioL_war_1.0-SNAPSHOTPU")
    private EntityManager em;  
    
    @Override
    public List<Tipoautomovil> getAllTipoAutomovil() {
        Query query = em.createNamedQuery("Tipoautomovil.findAll");
        return query.getResultList();
    }

    @Override
    public Tipoautomovil update(Tipoautomovil tipoAutomovil) {
        return em.merge(tipoAutomovil);
    }

    @Override
    public Tipoautomovil findById(Integer tipo) {
        Query query = em.createNamedQuery("Tipoautomovil.findByIdTipo").setParameter("idTipo", tipo);
        return (Tipoautomovil) query.getSingleResult();
    }

    
}
