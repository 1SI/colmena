/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author fran
 */
public class UtilReina extends Thread {

    Socket socket;
    private static int numHijo = 0;

    public UtilReina(Socket socket) {
        this.socket = socket;
        numHijo++;
    }

    @Override
    public void run() {
        try {
            OutputStream salida = socket.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            InputStream entrada = socket.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            int zona = (int) (Math.random() * 10);
            int abeja = flujoEntrada.readInt();
            System.out.println("Soy el hijo de la reina nº " + numHijo + ". Aceptada tu peticion obrera nº " + abeja);
            System.out.println("Obrera nº " + abeja + ", ves a limpiar la zona " + zona);
            flujoSalida.writeInt(zona);
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

}
