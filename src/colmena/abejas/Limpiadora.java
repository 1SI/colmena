/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena.abejas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author fran
 */
public class Limpiadora extends Obrera {
    
    int nAbeja;

    @Override
    public void trabajo() throws Exception {
        while (true) {
            socket = new Socket("localhost", puerto);
            DataInputStream flujoEntrada = new DataInputStream(socket.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());
            flujoSalida.writeInt(nAbeja);
            int zona = flujoEntrada.readInt();
            System.out.println("Soy la abeja nº " + nAbeja +". Empezando a limpiar la zona " + zona);
            Thread.sleep((long) (Math.random()*10000));
            System.out.println("Zona " + zona + " limpia por la abeja nº " + nAbeja + ". Dame otra zona");
        }
    }

    public Limpiadora(int puerto, int nAbeja){
        super(puerto);
        this.nAbeja = nAbeja;
    }

    /*public static void main(String[] args){
        try {
            Limpiadora limpiadora = new Limpiadora(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
}
