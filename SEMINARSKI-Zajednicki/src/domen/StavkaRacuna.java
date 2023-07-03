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
public class StavkaRacuna implements Serializable {
    private int stavkaRacunaId;
    private Racun racun;
    private double iznos;
    private int kolicina;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int stavkaRacunaId, Racun racun, double iznos, int kolicina) {
        this.stavkaRacunaId = stavkaRacunaId;
        this.racun = racun;
        this.iznos = iznos;
        this.kolicina = kolicina;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getStavkaRacunaId() {
        return stavkaRacunaId;
    }

    public void setStavkaRacunaId(int stavkaRacunaId) {
        this.stavkaRacunaId = stavkaRacunaId;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }
    
    
}
