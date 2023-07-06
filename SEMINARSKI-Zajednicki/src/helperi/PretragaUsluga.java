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
public class PretragaUsluga implements Serializable {
    private int stomatologId;
    private int pacijentId;

    public PretragaUsluga() {
    }

    public PretragaUsluga(int stomatologId, int pacijentId) {
        this.stomatologId = stomatologId;
        this.pacijentId = pacijentId;
    }

    public int getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(int pacijentId) {
        this.pacijentId = pacijentId;
    }

    public int getStomatologId() {
        return stomatologId;
    }

    public void setStomatologId(int stomatologId) {
        this.stomatologId = stomatologId;
    }
    
    
}
