/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Automovil;
import java.util.List;
import javax.ejb.EJB;
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

    
    @EJB
    private VentaManagerLocal ventaManager;

    @EJB
    private TipoAutomovilManagerLocal tipoAutomovilManager;

    @EJB
    private MarcaManagerLocal marcaManager;

    @EJB
    private LineaManagerLocal lineaManager;

    @EJB
    private FacturaManagerLocal facturaManager;

    @EJB
    private AutomovilManagerLocal automovilManager;

    private Automovil automovil;
    private List<Automovil> automoviles;
    
    @PersistenceContext(unitName = "com.udea_concesionarioL_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Automovil> getAllAutomoviles() {
        Query query = em.createNamedQuery("Automovil.findAll");
        return query.getResultList();
    }

    @Override
    public Automovil update(Automovil automovil) {
        return em.merge(automovil);
    }
    
    @Override
    public void refresh() {
        automoviles = automovilManager.getAllAutomoviles();
    }

//    public void agregar(){
//        Query query = em.
//                
//                INSERT INTO concesionariobd.automovil (id_automovil, tipo_automovil, cilindraje, color, precio, linea, en_venta, meses_garantia, foto) 
//	VALUES (231321, 1, 212121, 'asasa', 212121, 1, true, 213231321, x'736461736164647361616473');
//
//    }
    @Override
    public void create(Automovil auto) {
        String query = "INSERT INTO automovil (id_automovil, id_tipo, cilindraje, color, precio, linea, id_venta, meses_garantia, foto) VALUES (a, b, c, d, e, f, g, h, i)";
        Query q = em.createNamedQuery(query);
        q.setParameter("idAutomovil", auto.getIdAutomovil());
        q.setParameter("tipoAutomovil", auto.getTipoAutomovil().getIdTipo());
        q.setParameter("cilindraje", auto.getCilindraje());
        q.setParameter("color", auto.getColor());
        q.setParameter("precio", auto.getPrecio());
        q.setParameter("linea", auto.getLinea().getIdLinea());
        q.setParameter("enVenta", auto.getEnVenta());
        q.setParameter("mesesGarantia", auto.getMesesGarantia());
        q.setParameter("foto", auto.getFoto());
        q.executeUpdate();
    }

}
