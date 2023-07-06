/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dimit
 */
public class PomocniRacun implements Serializable {
    private PretragaUsluga ids;
    private ArrayList<GrupisanaUsluga> stavkeRacuna;

    public PomocniRacun() {
    }

    public PomocniRacun(PretragaUsluga ids, ArrayList<GrupisanaUsluga> stavkeRacuna) {
        this.ids = ids;
        this.stavkeRacuna = stavkeRacuna;
    }

    public ArrayList<GrupisanaUsluga> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(ArrayList<GrupisanaUsluga> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    public PretragaUsluga getIds() {
        return ids;
    }

    public void setIds(PretragaUsluga ids) {
        this.ids = ids;
    }
    
    
}
