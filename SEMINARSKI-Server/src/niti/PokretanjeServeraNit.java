/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dimit
 */
public class PokretanjeServeraNit extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut!");
            
            while (true) {
                Socket s = ss.accept();
                ObradaZahtevaNit ozn = new ObradaZahtevaNit(s);
                ozn.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
