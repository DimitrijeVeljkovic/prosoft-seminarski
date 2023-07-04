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
public class PretragaPomocnika implements Serializable {
    private int stomatologId;
    private String kriterijumPretrage;

    public PretragaPomocnika() {
    }

    public PretragaPomocnika(int stomatologId, String kriterijumPretrage) {
        this.stomatologId = stomatologId;
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public int getStomatologId() {
        return stomatologId;
    }

    public void setStomatologId(int stomatologId) {
        this.stomatologId = stomatologId;
    }
    
    
}
