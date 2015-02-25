/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import colmena.abejas.Abeja;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro S. 
 */
public class Trabajo extends Thread{
    
    Socket socket;
    Abeja abeja;

    public Trabajo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream salida = null;
        try {
            salida = socket.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            InputStream entrada = socket.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            int zona = (int) (Math.random()*10);
            int abeja = flujoEntrada.readInt();
            System.out.println("Obrera nº " + abeja + ", ves a limpiar la zona " + zona);
            flujoSalida.writeInt(zona);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Trabajo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                salida.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Trabajo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
}