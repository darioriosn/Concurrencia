/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.examen.ui;

import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class Data {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer tipoAccion;
    private String mantenimiento;
    private static final Logger LOG = Logger.getLogger(Data.class.getName());

    public Data() {
    }

    public Data(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    

    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tipoAccion
     */
    public Integer getTipoAccion() {
        return tipoAccion;
    }

    /**
     * @param tipoAccion the tipoAccion to set
     */
    public void setTipoAccion(Integer tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    /**
     * @return the mantenimiento
     */
    public String getMantenimiento() {
        return mantenimiento;
    }

    /**
     * @param mantenimiento the mantenimiento to set
     */
    public void setMantenimiento(String mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    
}
