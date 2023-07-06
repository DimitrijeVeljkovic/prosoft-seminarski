/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Stomatolog;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dimit
 */
public class ModelTabeleStomatolog extends AbstractTableModel {
    private ArrayList<Stomatolog> stomatolozi = new ArrayList<>();
    private final String[] kolone = { "Ime", "Prezime", "Korisnicko ime" };

    @Override
    public int getRowCount() {
        return stomatolozi.size();
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
        Stomatolog s = stomatolozi.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return s.getIme();
            case 1: return s.getPrezime();
            case 2: return s.getKorisnickoIme();
        }
        
        return "";
    }

    public void postaviStomatologe(ArrayList<Stomatolog> stomatolozi) {
        this.stomatolozi = stomatolozi;
        fireTableDataChanged();
    }
    
}
