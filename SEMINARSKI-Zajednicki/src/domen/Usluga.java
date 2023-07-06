/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dimit
 */
public class Usluga implements Serializable {
    private Stomatolog stomatolog;
    private Pacijent pacijent;
    private int uslugaId;
    private Date datum;
    private String opis;
    private Pomocnik pomocnik;
    private StavkaCenovnika stavkaCenovnika;

    public Usluga() {
    }

    public Usluga(Stomatolog stomatolog, Pacijent pacijent, int uslugaId, Date datum, String opis, Pomocnik pomocnik, StavkaCenovnika stavkaCenovnika) {
        this.stomatolog = stomatolog;
        this.pacijent = pacijent;
        this.uslugaId = uslugaId;
        this.datum = datum;
        this.opis = opis;
        this.pomocnik = pomocnik;
        this.stavkaCenovnika = stavkaCenovnika;
    }

    public StavkaCenovnika getStavkaCenovnika() {
        return stavkaCenovnika;
    }

    public void setStavkaCenovnika(StavkaCenovnika stavkaCenovnika) {
        this.stavkaCenovnika = stavkaCenovnika;
    }

    public Stomatolog getStomatolog() {
        return stomatolog;
    }

    public void setStomatolog(Stomatolog stomatolog) {
        this.stomatolog = stomatolog;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Pomocnik getPomocnik() {
        return pomocnik;
    }

    public void setPomocnik(Pomocnik pomocnik) {
        this.pomocnik = pomocnik;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(int uslugaId) {
        this.uslugaId = uslugaId;
    }
    
    
}
