/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordescargas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class Descarga extends Thread {
    private URL url;
    private String location;
    
    private FileOutputStream fileOutputStream;
    private InputStream inputStream;
    private int len;
    private int inicio;
    private byte[] buffer = new byte[1024];
    private String nombreArchivo;

    public Descarga(final URL url, String location) {
        this.url = url;
        this.location = location;
        try{
            URLConnection uRLConnection = this.url.openConnection();
            inputStream = uRLConnection.getInputStream();
            String rutaArchivo = url.getFile();
            String nombre = rutaArchivo.substring(rutaArchivo.lastIndexOf("/")+1,rutaArchivo.length());
            System.out.println("Ruta del archivo: " + rutaArchivo);
            System.out.println("Nombre del archivo: " + nombre);
            fileOutputStream = new FileOutputStream(new File(this.location+nombre));
            this.nombreArchivo = nombre;
        }catch(IOException ex){
            ex.printStackTrace();
        }
       
        
    }
    
    @Override
    public void run(){
          System.out.println("Descargando...");
        try {
            while((len=inputStream.read(buffer))>=0){
                fileOutputStream.write(buffer, inicio, len);
                fileOutputStream.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Descarga.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            System.out.println("Descarga completada en:" + this.location+nombreArchivo );
    }
    
    
    
    
}
