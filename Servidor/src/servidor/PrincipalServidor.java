/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;

/**
 *
 * @author Dario
 */
public class PrincipalServidor {
    public static void main(String[] args) throws IOException {
        Servidor ser = new Servidor();
        ser.startServer();
    }
}
