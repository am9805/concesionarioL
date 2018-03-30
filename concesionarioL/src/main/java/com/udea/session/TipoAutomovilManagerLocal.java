/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Tipoautomovil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alejo Castaño Rojas
 */
@Local
public interface TipoAutomovilManagerLocal {

    List<Tipoautomovil> getAllTipoAutomovil();

    Tipoautomovil update(Tipoautomovil tipoAutomovil);

    Tipoautomovil findById(Integer tipo);
    
}
