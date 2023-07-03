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
public class Cenovnik implements Serializable {
    private int cenovnikId;
    private Date datumAzuriranja;

    public Cenovnik() {
    }

    public Cenovnik(int cenovnikId, Date datumAzuriranja) {
        this.cenovnikId = cenovnikId;
        this.datumAzuriranja = datumAzuriranja;
    }

    public Date getDatumAzuriranja() {
        return datumAzuriranja;
    }

    public void setDatumAzuriranja(Date datumAzuriranja) {
        this.datumAzuriranja = datumAzuriranja;
    }

    public int getCenovnikId() {
        return cenovnikId;
    }

    public void setCenovnikId(int cenovnikId) {
        this.cenovnikId = cenovnikId;
    }
    
    
}
