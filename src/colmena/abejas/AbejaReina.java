/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena.abejas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            OutputStream salida = socket.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            InputStream entrada = socket.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            int zona = (int) (Math.random()*10);
            int abeja = flujoEntrada.readInt();
            System.out.println("Obrera nº " + abeja + ", ves a limpiar la zona " + zona);
            flujoSalida.writeInt(zona);
            socket.close();
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
