/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Dario
 */
public class Cliente extends Conexion {
    
    public Cliente() throws IOException {
        super("cliente");
    }
    
    public void startConnectionClient(){
        try{
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            
            for(int i=0; i<2; i++){
                salidaServidor.writeUTF("Este mensaje es para el servidor: mensaje " + i + "" );
            }
            
            cs.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
