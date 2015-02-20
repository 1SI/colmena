/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colmena;

import colmena.abejas.AbejaReina;
import colmena.abejas.Limpiadora;
import colmena.abejas.Nodriza;
import colmena.abejas.Zangano;
import java.util.ArrayList;

/**
 *
 * @author fran
 */
public class Colmena {
    
    final static int PUERTO_REINA = 5000;
    final static int PUERTO_LIMPIADORA = 5000;
    
    public static void main(String[] args){
        ArrayList<Limpiadora> listaLimpiadoras = new ArrayList();
        ArrayList<Zangano> listaZanganos = new ArrayList();
        ArrayList<Nodriza> listaNodrizas = new ArrayList();
        AbejaReina reina = new AbejaReina(PUERTO_REINA);
        reina.start();
        listaLimpiadoras.add(new Limpiadora(PUERTO_LIMPIADORA,1));
        listaLimpiadoras.add(new Limpiadora(PUERTO_LIMPIADORA,2));
        listaLimpiadoras.add(new Limpiadora(PUERTO_LIMPIADORA,3));
        listaLimpiadoras.add(new Limpiadora(PUERTO_LIMPIADORA,4));
        for(Limpiadora limpiadora:listaLimpiadoras){
            limpiadora.start();
        }
        listaNodrizas.add(new Nodriza(5001,1));
        listaNodrizas.add(new Nodriza(5002,2));
        listaNodrizas.add(new Nodriza(5003,3));
        listaNodrizas.add(new Nodriza(5004,4));
        listaNodrizas.add(new Nodriza(5005,5));
        for(Nodriza nodriza:listaNodrizas){
            nodriza.start();
        }
        listaZanganos.add(new Zangano(5001,1));
        listaZanganos.add(new Zangano(5002,2));
        listaZanganos.add(new Zangano(5003,3));
        for(Zangano zangano:listaZanganos){
            zangano.start();
        }
    }
    
}
