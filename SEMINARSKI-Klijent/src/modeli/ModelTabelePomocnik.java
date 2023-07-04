/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Pomocnik;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dimit
 */
public class ModelTabelePomocnik extends AbstractTableModel {
    private ArrayList<Pomocnik> pomocnici = new ArrayList<>();
    private final String[] kolone = { "Ime", "Prezime", "JMBG" };

    @Override
    public int getRowCount() {
        return pomocnici.size();
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
        Pomocnik pomocnik = pomocnici.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return pomocnik.getIme();
            case 1: return pomocnik.getPrezime();
            case 2: return pomocnik.getJmbg();
        }
        
        return "";
    }

    public void postaviPomocnike(ArrayList<Pomocnik> p) {
        pomocnici = p;
        fireTableDataChanged();
    }
    
}
