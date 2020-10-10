/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dario
 */
public class Conexion {
    private final int PUERTO = 1234;
    private final String HOST = "localhost"; //127.0.0.1
    protected String mensajeServidor;
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; // socket del cliente
    
    protected DataOutputStream salidaServidor, salidaCliente;

    public Conexion(String tipo) throws IOException {
        if(tipo.equalsIgnoreCase("servidor")){
            ss = new ServerSocket(PUERTO);
            cs = new Socket();
            System.out.println("Escuchando por el puerto " + PUERTO);
        }else{
            cs = new Socket(HOST, PUERTO);
        }
    }
    
}
