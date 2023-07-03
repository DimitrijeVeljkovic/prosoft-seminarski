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
public class Pomocnik implements Serializable {
    private int pomocnikId;
    private String ime;
    private String prezime;
    private String jmbg;
    private Stomatolog stomatolog;

    public Pomocnik() {
    }

    public Pomocnik(int pomocnikId, String ime, String prezime, String jmbg, Stomatolog stomatolog) {
        this.pomocnikId = pomocnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.stomatolog = stomatolog;
    }

    public Stomatolog getStomatolog() {
        return stomatolog;
    }

    public void setStomatolog(Stomatolog stomatolog) {
        this.stomatolog = stomatolog;
    }

    public int getPomocnikId() {
        return pomocnikId;
    }

    public void setPomocnikId(int pomocnikId) {
        this.pomocnikId = pomocnikId;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    
    
}
