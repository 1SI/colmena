/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena.abejas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author fran
 */
public class Zangano extends Abeja{
    
    private int nAbeja;
    
    private void busqueda() throws Exception{
        boolean encontrado = false;
        while(!encontrado){
            socket = new Socket("localhost", puerto);
            DataInputStream flujoEntrada = new DataInputStream(socket.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());
            int tiempo = ((int)Math.random()*5)+5;
            System.out.println("Soy el zangano nº " + nAbeja + ". Me voy de caza");
            int probabilidad = (int) Math.floor(Math.random()*5+1);
            if(probabilidad == 1){
                System.out.println("Soy el zangano nº " + nAbeja + ". "
                        + "He encontrado otra Reina. Me voy");
                encontrado = true;
                socket.close();
            }else{
                System.out.println("Soy el zangano nº " + nAbeja + ". "
                        + "Buscando una nodriza");
                flujoSalida.writeInt(nAbeja);
                if(flujoEntrada.readBoolean()){
                    System.out.println("Zangano nº " + nAbeja + ". Pilas cargadas");
                    socket.close();
                }
            }
        }
    }
    
    @Override
    public void run(){
        try{
            busqueda();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Zangano(int puerto,int nAbeja){
        this.puerto = puerto;
        this.nAbeja = nAbeja;
    }
    
}