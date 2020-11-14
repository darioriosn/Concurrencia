/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.mantenimiento.accesodatos;

import com.progra.mantenimiento.modelo.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class UsuarioDAO implements InterfaceDAO<Usuario> {

    private UsuarioCrud usuarioCrud;

    public UsuarioDAO() {
        this.usuarioCrud = new UsuarioCrud();
    }
    
    
    @Override
    public Optional<Usuario> getId(Integer id) {
        try {
            Usuario u = new Usuario();
            u.setId(1);
            return Optional.ofNullable(usuarioCrud.seleccionarPorId(u));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }

    @Override
    public List<Usuario> getAll(int activo) {
        try {
            return usuarioCrud.seleccionarTodoActivo(1);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public boolean save(Usuario t) {
        try {
            return usuarioCrud.insertarUsuario(t);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       }

    @Override
    public boolean update(Usuario t) {
        return false;
      }

    @Override
    public boolean delete(Usuario t) {
        return false;
      }
    
}
