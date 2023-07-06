/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DBBroker;
import domen.Pacijent;
import domen.Pomocnik;
import domen.Racun;
import domen.StavkaCenovnika;
import domen.StavkaRacuna;
import domen.Stomatolog;
import domen.Usluga;
import helperi.GrupisanaUsluga;
import helperi.PomocniRacun;
import helperi.PretragaPomocnika;
import helperi.PretragaUsluga;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public boolean unesiPacijenta(Pacijent pacijent) {
        boolean uspesno = false;
        
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        try {
            dbb.unesiPacijenta(pacijent);
            dbb.commit();
            uspesno = true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbb.rollback();
        }
        dbb.zatvoriKonekciju();
        
        return uspesno;
    }

    public boolean unesiPomocnika(Pomocnik pomocnik) {
        boolean uspesno = false;
        
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        try {
            dbb.unesiPomocnika(pomocnik);
            dbb.commit();
            uspesno = true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbb.rollback();
        }
        dbb.zatvoriKonekciju();
        
        return uspesno;
    }

    public boolean obrisiPomocnika(Pomocnik pomocnikZaBrisanje) {
        boolean uspesno = false;
        
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        try {
            dbb.obrisiPomocnika(pomocnikZaBrisanje);
            dbb.commit();
            uspesno = true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbb.rollback();
        }
        dbb.zatvoriKonekciju();
        
        return uspesno;
    }

    public ArrayList<StavkaCenovnika> vratiStavkeCenovnika() {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<StavkaCenovnika> stavkeCenovnika = dbb.vratiStavkeCenovnika();
        dbb.zatvoriKonekciju();
        
        return stavkeCenovnika;
    }

    public boolean unesiUslugu(Usluga usluga) {
        boolean uslugaZapamcena = false;
        
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        try {
            dbb.unesiUslugu(usluga);
            dbb.commit();
            uslugaZapamcena = true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbb.rollback();
        }
        dbb.zatvoriKonekciju();
        
        return uslugaZapamcena;
    }

    public boolean azurirajCenovnik(ArrayList<StavkaCenovnika> noveStavkeCenovnika) {
        boolean cenovnikAzuriran = false;
        
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        try {
            int cenovnikId = (int)(Math.random() * 1000000);
            
            dbb.dodajNoviCenovnik(cenovnikId, new Date());
            for (StavkaCenovnika stavkaCenovnika : noveStavkeCenovnika) {
                dbb.dodajStavkuCenovnika(cenovnikId, stavkaCenovnika);
            }
            
            dbb.commit();
            cenovnikAzuriran = true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbb.rollback();
        } 
        dbb.zatvoriKonekciju();
        
        return cenovnikAzuriran;
    }

    public ArrayList<GrupisanaUsluga> vratiUslugeGrupisano(PretragaUsluga pu) {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<GrupisanaUsluga> usluge = dbb.vratiUslugeGrupisano(pu);
        dbb.zatvoriKonekciju();
        
        return usluge;
    }

    public Racun unesiRacun(PomocniRacun pr) {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        try {
            int racunId = (int)(Math.random() * 1000000);
            double ukupno = 0;
            for (GrupisanaUsluga stavka : pr.getStavkeRacuna()) {
                ukupno += stavka.getIznos();
            }
            Racun racun = new Racun(
                    racunId,
                    new java.util.Date(),
                    ukupno,
                    new Stomatolog(pr.getIds().getStomatologId(), "", "", "", ""), 
                    new Pacijent(pr.getIds().getPacijentId(), "", "")
            );
            
            dbb.unesiRacun(racun);
            for (GrupisanaUsluga gu : pr.getStavkeRacuna()) {
                StavkaRacuna stavka = new StavkaRacuna(-1, racun, gu.getIznos(), gu.getKolicina());
                
                dbb.unesiStavkuRacuna(stavka);
            }
            
            dbb.commit();
            dbb.zatvoriKonekciju();
            return racun;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbb.rollback();
            dbb.zatvoriKonekciju();
            return null;
        }
    }
    
    
}
