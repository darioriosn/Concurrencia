/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.examen.ui;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class PeticionCliente extends Observable{

    private ArticulosMantenimiento articulosMantenimiento;
    
    
    public PeticionCliente(ArticulosMantenimiento am) {
        articulosMantenimiento = am;
        this.addObserver(articulosMantenimiento);
    }
    
    
    
    public void enviarInformacion(String dataJson){
          try {
            // TODO add your handling code here:
            Socket socket = new Socket("127.0.0.1", 7777);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            String clienteMensaje="", servidorMensaje="";
            //Logica
            outStream.writeUTF(dataJson);
            outStream.flush();
            servidorMensaje = inStream.readUTF();
            this.setChanged();
            this.notifyObservers(servidorMensaje);
            this.clearChanged();
            outStream.close();
            inStream.close();
            socket.close();
           
        } catch (IOException ex) {
            Logger.getLogger(ArticulosMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
