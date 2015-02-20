package colmena.abejas;

import java.net.ServerSocket;
import java.net.Socket;

public abstract class Abeja extends Thread{
    
    Socket socket;
    ServerSocket server;
    int puerto;
    
}
