/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.StavkaCenovnika;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dimit
 */
public class ModelTabeleCenovnik extends AbstractTableModel {
    private ArrayList<StavkaCenovnika> stavke = new ArrayList<>();
    private final String[] kolone = { "Naziv", "Cena", "Novcana jedinica" };

    @Override
    public int getRowCount() {
        return stavke.size();
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
        StavkaCenovnika stavka = stavke.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return stavka.getNaziv();
            case 1: return stavka.getCena();
            case 2: return stavka.getNovcanaJedinica();
        }
        
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            try {
                double novaCena = Double.parseDouble((String) aValue);
                stavke.get(rowIndex).setCena(novaCena);
                fireTableDataChanged();
            } catch (NumberFormatException ex) {
                Logger.getLogger(ModelTabeleCenovnik.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Neispravna cena! Cena mora biti brojcanog tipa!");
            }
        }
    }

    public void dodajStavke(ArrayList<StavkaCenovnika> cene) {
        stavke = cene;
        fireTableDataChanged();
    }

    public ArrayList<StavkaCenovnika> vratiStavkeCenovnika() {
        return stavke;
    }
    
}
