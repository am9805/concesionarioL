/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Factura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejo Castaño Rojas
 */
@Stateless
public class FacturaManager implements FacturaManagerLocal {

    @PersistenceContext(unitName = "com.udea_concesionarioL_war_1.0-SNAPSHOTPU")
    private EntityManager em;
        
    @Override
    public List<Factura> getAllFacturas() {
        Query query = em.createNamedQuery("Factura.findAll");
        return query.getResultList();
    }
    @Override
    public Factura update(Factura factura) {
        return em.merge(factura);
    }

}
