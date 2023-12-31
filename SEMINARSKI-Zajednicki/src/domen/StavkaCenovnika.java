/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author dimit
 */
public class StavkaCenovnika implements Serializable {
    private int stavkaCenovnikaId;
    private Cenovnik cenovnik;
    private String naziv;
    private double cena;
    private String novcanaJedinica;

    public StavkaCenovnika() {
    }

    public StavkaCenovnika(int stavkaCenovnikaId, Cenovnik cenovnik, String naziv, double cena, String novcanaJedinica) {
        this.stavkaCenovnikaId = stavkaCenovnikaId;
        this.cenovnik = cenovnik;
        this.naziv = naziv;
        this.cena = cena;
        this.novcanaJedinica = novcanaJedinica;
    }

    public String getNovcanaJedinica() {
        return novcanaJedinica;
    }

    public void setNovcanaJedinica(String novcanaJedinica) {
        this.novcanaJedinica = novcanaJedinica;
    }

    public int getStavkaCenovnikaId() {
        return stavkaCenovnikaId;
    }

    public void setStavkaCenovnikaId(int stavkaCenovnikaId) {
        this.stavkaCenovnikaId = stavkaCenovnikaId;
    }

    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return this.naziv + " - " + this.cena + " " + this.novcanaJedinica;
    }
    
    
}
