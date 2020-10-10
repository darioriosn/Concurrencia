/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordescargagrafico;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 *
 * @author Dario
 */
public class Ventana extends JFrame {

    private final JProgressBar jProgressBar;
    private final JButton descarga;
    
    public Ventana() {
        super("Ventana de progreso");
        jProgressBar = new JProgressBar();
        jProgressBar.setValue(0);
        jProgressBar.setMaximum(100);
        
        jProgressBar.setStringPainted(true);
        
        jProgressBar.setBorder(BorderFactory.createTitledBorder("Descargando archivo.."));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = this.getContentPane();
        content.add(jProgressBar,BorderLayout.SOUTH);
        descarga = new JButton("Descargar");
        content.add(descarga);
        
        final AtomicBoolean running = new AtomicBoolean(false);
        
        descarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running.set(!running.get());
                descarga.setText(running.get() ? "Pausa" : "Continue");
                if(running.get()){
                    new Thread(){
                        public void run(){
                            int v = 0;
                            while(running.get() && v<jProgressBar.getMaximum()){
                                jProgressBar.setValue(++v);
                                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(200));
                            }
                        }
                    }.start();
                }
            }
        });
        
        this.setSize(300,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
        
    }
    
}
