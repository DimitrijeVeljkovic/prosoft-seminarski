/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Pacijent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dimit
 */
public class ModelTabelePacijent extends AbstractTableModel {
    private ArrayList<Pacijent> pacijenti = new ArrayList<>();
    private final String[] kolone = { "Ime", "Prezime" };

    @Override
    public int getRowCount() {
        return pacijenti.size();
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
        Pacijent pacijent = pacijenti.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return pacijent.getIme();
            case 1: return pacijent.getPrezime();
        }
        
        return "";
    }

    public void postaviPacijente(ArrayList<Pacijent> p) {
        pacijenti = p;
        fireTableDataChanged();
    }
    
    public Pacijent nadjiPacijenta(int red) {
        return pacijenti.get(red);
    }
}
