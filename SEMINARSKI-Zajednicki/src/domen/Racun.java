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
public class Racun implements Serializable {
    private int racunId;
    private Date datumIzdavanja;
    private double ukupanIznos;
    private Stomatolog stomatolog;
    private Pacijent pacijent;

    public Racun() {
    }

    public Racun(int racunId, Date datumIzdavanja, double ukupanIznos, Stomatolog stomatolog, Pacijent pacijent) {
        this.racunId = racunId;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznos = ukupanIznos;
        this.stomatolog = stomatolog;
        this.pacijent = pacijent;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public int getRacunId() {
        return racunId;
    }

    public void setRacunId(int racunId) {
        this.racunId = racunId;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Stomatolog getStomatolog() {
        return stomatolog;
    }

    public void setStomatolog(Stomatolog stomatolog) {
        this.stomatolog = stomatolog;
    }
    
    
}
