/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.mantenimiento.accesodatos;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Dario
 */
public interface InterfaceDAO<T> {
    Optional<T> getId(Integer id);
    
    List<T> getAll(int activo);
    
    boolean save(T t);
    
    boolean update(T t);
    
    boolean delete(T t);
}
