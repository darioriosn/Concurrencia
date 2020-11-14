/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadserver;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dario
 */
public class MultithreadServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        
            ServerSocket server = new ServerSocket(7777);
            System.out.println("Server Started");
            int contador = 0;
            while(true){
                contador++;
                Socket serverClient = server.accept();
                System.out.println("Cliente Numero: " + contador + " iniciado"); 
                ClienteHilo ch = new ClienteHilo(serverClient, contador);
                ch.run();
                
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
