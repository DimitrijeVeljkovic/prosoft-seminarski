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
public class Pacijent implements Serializable {
    private int pacijentId;
    private String ime;
    private String prezime;

    public Pacijent() {
    }

    public Pacijent(int pacijentId, String ime, String prezime) {
        this.pacijentId = pacijentId;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(int pacijentId) {
        this.pacijentId = pacijentId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    
    
}
