/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplorunnable;

/**
 *
 * @author Dario
 */
public class Circulo extends Figura implements Runnable{
    private int radio;
    private double PI = Math.PI;

    public Circulo() {
    }

    /**
     * @return the radio
     */
    public int getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(int radio) {
        this.radio = radio;
    }

    /**
     * @return the PI
     */
    public double getPI() {
        return PI;
    }

    /**
     * @param PI the PI to set
     */
    public void setPI(double PI) {
        this.PI = PI;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("ProcesoCirculo1");
        System.out.println("Nombre: " + Thread.currentThread().getName());
        
        System.out.println("Esta vivo? " + Thread.currentThread().isAlive());
        
        dibujarCirculo();
        
    }

    private void dibujarCirculo() {
        System.out.println("Dibujando circulo...");
    }
    
    
    
    
}
