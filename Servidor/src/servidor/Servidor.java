/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class Servidor extends Conexion {
    
    public Servidor() throws IOException {
        super("servidor");
    }
    
    public void startServer(){
        System.out.println("Esperando....");
        try {
            //cliente acepta conexiones del servidor
            cs = ss.accept();
            System.out.println("Cliente esperando");
            
            salidaCliente = new DataOutputStream(cs.getOutputStream());
            
            salidaCliente.writeUTF("Peticion recibida y aceptada");
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            
            while((mensajeServidor = entrada.readLine()) != null){
                System.out.println("Mensaje del cliente:" + mensajeServidor);
            }
            
            System.out.println("Fin de conexion");
            
             ss.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
    
}
