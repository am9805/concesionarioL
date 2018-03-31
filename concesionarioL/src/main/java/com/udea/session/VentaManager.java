/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Factura;
import com.udea.entity.Venta;
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
public class VentaManager implements VentaManagerLocal {

    @PersistenceContext(unitName = "com.udea_concesionarioL_war_1.0-SNAPSHOTPU")
    private EntityManager em;  
    
    @Override
    public List<Venta> getAllVentas() {
        Query query = em.createNamedQuery("Venta.findAll");
        return query.getResultList();
    }

    @Override
    public Venta update(Venta venta) {
        return em.merge(venta);
    }

    @Override
    public boolean insert(Venta venta) {
        try {
            em.merge(venta);
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }

    @Override
    public List<Venta> findByNumeroFactura(Factura factura) {
        Query query = em.createNamedQuery("Venta.findByNumeroFactura").setParameter("numeroFactura", factura);
        return query.getResultList();
    }


}
