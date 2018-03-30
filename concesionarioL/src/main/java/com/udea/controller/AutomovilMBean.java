/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.*;
import com.udea.entity.Linea;
import com.udea.entity.Marca;
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
    private Automovil newAutomovil;
    private List<Automovil> automoviles;
    private List<Automovil> carritoDeCompras;
    private List<Marca> marcas;
    private List<Linea> lineas;
    private List<Tipoautomovil> tipos;
    /*atributos para crear el automovil*/
    private Integer linea;
    private String color;
    private Integer tipo;
    private Integer cilindraje;
    private Integer marca;
    private String precio;
    private String mesesGarantia;
    private boolean enVenta;
    private String errorCreate;
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(String mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }

    public boolean isEnVenta() {
        return enVenta;
    }

    public void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getErrorCreate() {
        return errorCreate;
    }

    public void setErrorCreate(String errorCreate) {
        this.errorCreate = errorCreate;
    }
    
    
    public List<Tipoautomovil> getTipos(){
         if (tipos == null || tipos.isEmpty()) {
            tipos = tipoAutomovilManager.getAllTipoAutomovil();
        }
        
        return tipos;
    }
    
    public List<Marca> getMarcas(){
        if (marcas == null || marcas.isEmpty()) {
            marcas = marcaManager.getAllMarcas();
        }
        
        return marcas;
    }
    
    public List<Linea> getLineas(){
        if (marca != null) {
            lineas = lineaManager.findAllByIdMarca(marcaManager.findById(marca));
            //System.out.println("se piden lineas******************"+marca+lineas.toString());
        }
        else{
            if(lineas != null) lineas.clear();
        }
        
        return lineas;
    }
    
    public AutomovilMBean() {
        carritoDeCompras = new ArrayList<Automovil>();
    }

    public List<Automovil> getAutomoviles() {
        if (automoviles == null || automoviles.isEmpty()) {
            refresh();
        }
            refresh();
        return automoviles;
    }
    
    public Automovil getAutomovil() {
        return automovil;
    }
    
    public String changeAutomovil(Automovil auto){
        this.automovil = auto;
        return "DetailsAutomovil";
    }
    
    
    public String initInsertAuto(){
        this.automovil = new Automovil();
        return "CreateAutomovil";
    }
    
    public void saveAutomovil(){
        this.errorCreate = "";
        Linea lineaAuto = null;
        Tipoautomovil tipoAutomovil = null;
        
        refresh();
        
        if(linea != null){
            lineaAuto = lineaManager.findById(linea);
            System.out.println(lineaAuto.getNombre());
        }
        if(tipo != null){
            tipoAutomovil = tipoAutomovilManager.findById(tipo);
            System.out.println(tipoAutomovil.getNombre());
        }

        if(lineaAuto != null && tipoAutomovil != null && color != null && mesesGarantia != null
                && precio != null && cilindraje != null){
            Integer id = 0;
            for (Automovil a : automoviles) {
                if(id < a.getIdAutomovil())
                {
                    id = a.getIdAutomovil();
                }
                
            }
            Automovil auto = new Automovil();
            auto.setLinea(lineaAuto);
            auto.setTipoAutomovil(tipoAutomovil);
            auto.setColor(color);
            auto.setMesesGarantia(Integer.parseInt(mesesGarantia));
            auto.setCilindraje(cilindraje);
            auto.setPrecio(Integer.parseInt(precio));
            auto.setIdAutomovil(id+1);
            auto.setFoto(new byte[1]);
            
            System.out.println(auto.toString());
            if(automovilManager.insert(auto)){
               errorCreate = "insertado correctamente";
               clearAutomovilAtributos();
            }
        }
        else{
            //errorCreate = "Validar la información";
        }
        
    }
    
    private void clearAutomovilAtributos(){
        color = null;
        mesesGarantia=null;
        cilindraje = null;
        precio = null;
        linea = null;
        marca = null;
        enVenta = false;
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
