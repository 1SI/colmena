/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena.abejas;

import java.net.Socket;


/**
 *
 * @author fran
 */
public abstract class Obrera extends Abeja{
    
    public Socket socketSeguridad;
    
    public abstract void trabajo() throws Exception;
    
    @Override
    public void run(){
        try {
            trabajo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Obrera(int puerto){
        this.puerto = puerto;
    }
    
}
