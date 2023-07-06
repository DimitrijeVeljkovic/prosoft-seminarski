/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import helperi.GrupisanaUsluga;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dimit
 */
public class ModelTabeleUsluga extends AbstractTableModel {
    private ArrayList<GrupisanaUsluga> usluge = new ArrayList<>();
    private final String[] kolone = { "Naziv stavke", "Iznos", "Kolicina" };

    @Override
    public int getRowCount() {
        return usluge.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupisanaUsluga usluga = usluge.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return usluga.getNaziv();
            case 1: return usluga.getIznos();
            case 2: return usluga.getKolicina();
        }
        
        return "";
    }

    public void postaviUsluge(ArrayList<GrupisanaUsluga> usluge) {
        this.usluge = usluge;
        fireTableDataChanged();
    }

    public ArrayList<GrupisanaUsluga> vratiSelektovaneUsluge(int[] selektovaniRedovi) {
        ArrayList<GrupisanaUsluga> selektovaneUsluge = new ArrayList<>();
        
        for (int i : selektovaniRedovi) {
            selektovaneUsluge.add(usluge.get(i));
        }
        
        return selektovaneUsluge;
    };
    
}
