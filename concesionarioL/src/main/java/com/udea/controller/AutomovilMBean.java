/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.Automovil;
import com.udea.session.AutomovilManagerLocal;
import com.udea.session.FacturaManagerLocal;
import com.udea.session.LineaManagerLocal;
import com.udea.session.MarcaManagerLocal;
import com.udea.session.TipoAutomovilManagerLocal;
import com.udea.session.VentaManagerLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named(value = "automovilMBean")
@SessionScoped
public class AutomovilMBean implements Serializable {

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

    public AutomovilMBean() {
    }

    public List<Automovil> getAutomoviles() {
        if (automoviles == null || automoviles.isEmpty()) {
            refresh();
        }
        return automoviles;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public String showDetails(Automovil automovil) {
        this.automovil = automovil;
        return "DETAILS"; // Permite enlazar a CustomerDetails.xml 
    }

    /**
     * Action handler - Actualiza el modelo Customer en la BD. Se llama cuando
     * se presiona el boton update del formulario
     *
     * @return
     */
    public String update() {
        System.out.println("###UPDATE###");
        automovil = automovilManager.update(automovil);
        return "SAVED"; // Para el caso navegacional
    }

    /**
     * Action handler - returno hacia la vista de la lista de clientes
     *
     * @return
     */
    public String list() {
        System.out.println("###LIST###");
        return "LIST";
    }

    private void refresh() {
        automoviles = automovilManager.getAllAutomoviles();
    }

    private void agregarAuto(Integer idAutomovil, Integer cilindraje, String color, 
            Integer precio, Boolean enVenta, Integer meses_garantia, byte[] foto){
        Automovil nuevoAuto;
        nuevoAuto = new Automovil(idAutomovil,cilindraje,color,precio,enVenta,meses_garantia,foto);
        automovilManager.create(nuevoAuto);
    }

}
