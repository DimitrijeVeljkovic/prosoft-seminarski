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
public class Stomatolog implements Serializable {
    private int stomatologId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Stomatolog() {
    }

    public Stomatolog(int stomatologId, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.stomatologId = stomatologId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getStomatologId() {
        return stomatologId;
    }

    public void setStomatologId(int stomatologId) {
        this.stomatologId = stomatologId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    
    @Override
    public String toString() {
        return this.ime + " " + this.prezime;
    }
}
