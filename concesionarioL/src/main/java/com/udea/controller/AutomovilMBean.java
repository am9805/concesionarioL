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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
    private List<Automovil> carritoDeCompras;
    
    public AutomovilMBean() {
        carritoDeCompras = new ArrayList<Automovil>();
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

    public String update() {
        System.out.println("###UPDATE###");
        automovil.setEnVenta(false);
        automovil = automovilManager.update(automovil);
        return "LIST"; 
    }
    
    public String changeAutomovil(Automovil auto){
        this.automovil = auto;
        return "DetailsAutomovil";
    }

    public String list() {
        System.out.println("###LIST###");
        return "LIST";
    }
    
    public List<Automovil> getCarrito(){
        return carritoDeCompras;
    }
    
    public String carrito(){
         System.out.println("###CARRITO###");
        return "CARRITO";
    }
    
    public boolean addCart(Automovil auto){
        boolean control = true;
        for (Automovil automovil : carritoDeCompras) {
            if(automovil.getIdAutomovil() == auto.getIdAutomovil())
            {
                control = false;
            }      
        }
        System.out.println(auto.getLinea().getNombre());
        if(control){
            carritoDeCompras.add(auto);
        }
        return control;
    }
    
    public void removeCart(Automovil auto){
        carritoDeCompras.remove(auto);
    }

    private void refresh() {
        automoviles = automovilManager.getAllAutomoviles();
    }

}
