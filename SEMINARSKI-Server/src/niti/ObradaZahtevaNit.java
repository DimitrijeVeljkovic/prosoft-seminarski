/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Pacijent;
import domen.Pomocnik;
import domen.Stomatolog;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author dimit
 */
public class ObradaZahtevaNit extends Thread {
    Socket s;

    public ObradaZahtevaNit(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            
            switch (kz.getOperacija()) {
                case Operacije.LOGIN:
                    Stomatolog sLogin = (Stomatolog) kz.getParametar();
                    Stomatolog stomatolog = Kontroler.getInstance().vratiPrijavljenogStomatologa(sLogin);
                    so.setOdgovor(stomatolog);
                    break;
                case Operacije.VRATI_PACIJENTE:
                    ArrayList<Pacijent> pacijenti = Kontroler.getInstance().vratiPacijente();
                    so.setOdgovor(pacijenti);
                    break;
                case Operacije.VRATI_POMOCNIKE_ZA_STOMATOLOGA:
                    int stomatologId = (int) kz.getParametar();
                    ArrayList<Pomocnik> pomocnici = Kontroler.getInstance().vratiPomocnikeZaStomatologa(stomatologId);
                    so.setOdgovor(pomocnici);
                    break;
            }
            
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
