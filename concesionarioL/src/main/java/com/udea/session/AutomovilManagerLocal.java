/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Automovil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alejo Castaño Rojas
 */
@Local
public interface AutomovilManagerLocal {

    List<Automovil> getAllAutomoviles();

    Automovil update(Automovil automovil);

    void vendido(int idAutomovil);

    Automovil getAutomovil(int idAutomovil);

    
}
