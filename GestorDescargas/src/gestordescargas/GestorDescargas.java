/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordescargas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class GestorDescargas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            new Descarga(new URL("https://w3.kcls.org/instruction/manuals/Word_2013_Nivel_1.pdf"), "C:\\Descargas\\").start();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
    
}
