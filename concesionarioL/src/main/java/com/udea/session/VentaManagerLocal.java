/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alejo Castaño Rojas
 */
@Local
public interface VentaManagerLocal {

    List<Venta> getAllVentas();

    Venta update(Venta venta);
    
}
