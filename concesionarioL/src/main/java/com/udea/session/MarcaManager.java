/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Marca;
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
public class MarcaManager implements MarcaManagerLocal {

    @PersistenceContext(unitName = "com.udea_concesionarioL_war_1.0-SNAPSHOTPU")
    private EntityManager em;  
    
    @Override
    public List<Marca> getAllMarcas() {
        Query query = em.createNamedQuery("Marca.findAll");
        return query.getResultList();
    }

    @Override
    public Marca update(Marca marca) {
        return em.merge(marca);
    }

    @Override
    public Marca findById(Integer marca) {
        Query query = em.createNamedQuery("Marca.findByIdMarca").setParameter("idMarca", marca);
        return (Marca) query.getSingleResult();
    }

   
}
