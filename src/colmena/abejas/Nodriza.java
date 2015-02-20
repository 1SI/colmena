/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena.abejas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;

/**
 *
 * @author fran
 */
public class Nodriza extends Obrera{

    int nAbeja;
    
    @Override
    public void trabajo() throws Exception {
        server = new ServerSocket(puerto);
        System.out.println("Soy la nodriza " + nAbeja);
        while(true){
            socket = server.accept();
            DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());
            DataInputStream flujoEntrada = new DataInputStream(socket.getInputStream());
            int nZangano = flujoEntrada.readInt();
            System.out.println("Empezando a dar de comer al zangano " + nZangano);
            Thread.sleep(((long)Math.floor(Math.random()*(5-3+1)+3)));
            System.out.println("Terminando de dar de comer al zangano " + nZangano);
            flujoSalida.writeBoolean(true);
            socket.close();
        }
    }
    
    public Nodriza(int puerto,int nAbeja){
        super(puerto);
        this.nAbeja = nAbeja;
    }
    
}
