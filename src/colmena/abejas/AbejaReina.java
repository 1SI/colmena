/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena.abejas;

import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import threads.Cortesana;

/**
 *
 * @author fran
 */
public class AbejaReina extends Abeja{
    
    private void ordenes() throws Exception{
        server = new ServerSocket(puerto);
        System.out.println("Soy la abeja reina, estoy en el puerto " + puerto);
        while(true){
            socket = server.accept();
            Cortesana atenderAbeja = new Cortesana(socket);
            atenderAbeja.start();
        }
    }
    
    @Override
    public void run(){
        try {
            ordenes();
        } catch (Exception ex) {
            Logger.getLogger(AbejaReina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public AbejaReina(int puerto){
        this.puerto = puerto;
    }
    
    /*public static void main(String[] args){
        AbejaReina reina = new AbejaReina(5000);
    }*/
    
}
