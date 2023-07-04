/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DBBroker;
import domen.Pacijent;
import domen.Pomocnik;
import domen.Stomatolog;
import helperi.PretragaPomocnika;
import java.util.ArrayList;

/**
 *
 * @author dimit
 */
public class Kontroler {
    private static Kontroler instance;
    DBBroker dbb;

    public Kontroler() {
        dbb = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Stomatolog vratiPrijavljenogStomatologa(Stomatolog sLogin) {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        Stomatolog s = dbb.vratiPrijavljenogStomatologa(sLogin);
        dbb.zatvoriKonekciju();
        
        return s;
    }

    public ArrayList<Pacijent> vratiPacijente() {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<Pacijent> pacijenti = dbb.vratiPacijente();
        dbb.zatvoriKonekciju();
        
        return pacijenti;
    }

    public ArrayList<Pomocnik> vratiPomocnikeZaStomatologa(int stomatologId) {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<Pomocnik> pomocnici = dbb.vratiPomocnikeZaStomatologa(stomatologId);
        dbb.zatvoriKonekciju();
        
        return pomocnici;
    }

    public ArrayList<Pacijent> pretraziPacijente(String kriterijumPacijent) {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<Pacijent> pacijenti = dbb.pretraziPacijente(kriterijumPacijent);
        dbb.zatvoriKonekciju();
        
        return pacijenti;
    }

    public ArrayList<Pomocnik> pretraziPomocnike(PretragaPomocnika pp) {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<Pomocnik> pomocnici = dbb.pretraziPomocnike(pp);
        dbb.zatvoriKonekciju();
        
        return pomocnici;
    }
    
    
}
