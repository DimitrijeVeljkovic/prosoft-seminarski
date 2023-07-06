/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperi;

import java.io.Serializable;

/**
 *
 * @author dimit
 */
public class GrupisanaUsluga implements Serializable {
    private String naziv;
    private double iznos;
    private int kolicina;

    public GrupisanaUsluga() {
    }

    public GrupisanaUsluga(String naziv, double iznos, int kolicina) {
        this.naziv = naziv;
        this.iznos = iznos;
        this.kolicina = kolicina;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
