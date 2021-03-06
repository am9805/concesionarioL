/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Linea;
import com.udea.entity.Marca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alejo Castaño Rojas
 */
@Stateless
public class LineaManager implements LineaManagerLocal {

    @PersistenceContext(unitName = "com.udea_concesionarioL_war_1.0-SNAPSHOTPU")
    private EntityManager em;  
    
    @Override
    public List<Linea> getAllLineas() {
        Query query = em.createNamedQuery("Linea.findAll");
        return query.getResultList();
    }
    @Override
    public Linea update(Linea linea) {
        return em.merge(linea);
    }

    @Override
    public List<Linea> findAllByIdMarca(Marca id) {
        Query query = em.createNamedQuery("Linea.findByIdMarca").setParameter("marca", id);
                
        return query.getResultList();
    }

    @Override
    public Linea findById(Integer id) {
        Query query = em.createNamedQuery("Linea.findByIdLinea").setParameter("idLinea", id);
        return (Linea) query.getSingleResult();
    }
}
