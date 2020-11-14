/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadserver;

import com.google.gson.Gson;
import com.progra.examen.ui.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author Dario
 */
public class ClienteHilo implements Runnable  {

    Socket cliente;
    private int numero;

    public ClienteHilo(Socket cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
    }
    
    
    
    @Override
    public void run() {
      try{
          DataInputStream inStream = new DataInputStream(cliente.getInputStream());
          DataOutputStream outStream = new DataOutputStream(cliente.getOutputStream()); 
          String clienteMensaje = "";
          clienteMensaje = inStream.readUTF();
          //Logica para ir a base de datos
          /*
            1,nombre:Martillo,descripcion:'Martillo de la marca Stanley' 
          */
          Gson gson = new Gson();
          Data d = gson.fromJson(clienteMensaje, Data.class);
          //insertar si el tipo de accion 1, si el mantenimiento. 
          outStream.writeUTF(gson.toJson(d));
          outStream.flush();
          
          inStream.close();
          outStream.close();
          cliente.close();
      }catch(Exception ex){
          System.out.println(ex);
      }
      finally{
          System.out.println("Cliente - " + numero + " cerro conexion");
      }
    }
    
}
