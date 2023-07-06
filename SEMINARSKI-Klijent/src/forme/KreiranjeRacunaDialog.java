/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Pacijent;
import domen.Racun;
import domen.Stomatolog;
import domen.Usluga;
import helperi.GrupisanaUsluga;
import helperi.PomocniRacun;
import helperi.PretragaUsluga;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import modeli.ModelTabeleUsluga;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author dimit
 */
public class KreiranjeRacunaDialog extends javax.swing.JDialog {
    Stomatolog stomatolog;
    Pacijent pacijent;
    
    /**
     * Creates new form KreiranjeRacunaDialog
     */
    public KreiranjeRacunaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        kreirajRacunButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        uslugeTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stomatologTxt = new javax.swing.JLabel();
        pacijentTxt = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiranje racuna");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Odaberite stavke za kreiranje racuna"));

        kreirajRacunButton.setText("Kreiraj racun");
        kreirajRacunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kreirajRacunButtonActionPerformed(evt);
            }
        });

        uslugeTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(uslugeTbl);

        jLabel1.setText("Racun izdaje stomatolog:");

        jLabel2.setText("Racun se izdaje pacijentu:");

        stomatologTxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stomatologTxt.setText("Ime i prezime stomatologa");

        pacijentTxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pacijentTxt.setText("Ime i prezime pacijenta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pacijentTxt)
                            .addComponent(stomatologTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(kreirajRacunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(stomatologTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pacijentTxt)))
                    .addComponent(kreirajRacunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kreirajRacunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kreirajRacunButtonActionPerformed
        int[] selektovaniRedovi = uslugeTbl.getSelectedRows();
        
        if (selektovaniRedovi.length == 0) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira racun! Barem jedan red u tabeli mora biti selektovan");
            return;
        }
        
        ArrayList<GrupisanaUsluga> selektovaneUsluge = ((ModelTabeleUsluga) uslugeTbl.getModel()).vratiSelektovaneUsluge(selektovaniRedovi);
        PretragaUsluga pu = new PretragaUsluga(stomatolog.getStomatologId(), pacijent.getPacijentId());
        
        PomocniRacun pr = new PomocniRacun(pu, selektovaneUsluge);
        
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.UNESI_RACUN, pr);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        Racun racun = (Racun) so.getOdgovor();
        if (racun != null) {
            JOptionPane.showMessageDialog(this, "Sistem je uspesno kreirao racun u iznosu: " + racun.getUkupanIznos() + "RSD!");
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira racun!");
        }
    }//GEN-LAST:event_kreirajRacunButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton kreirajRacunButton;
    private javax.swing.JLabel pacijentTxt;
    private javax.swing.JLabel stomatologTxt;
    private javax.swing.JTable uslugeTbl;
    // End of variables declaration//GEN-END:variables

    void postaviStomatologaIPacijenta(Stomatolog stomatolog, Pacijent pacijent) {
        this.stomatolog = stomatolog;
        this.pacijent = pacijent;
        stomatologTxt.setText(this.stomatolog.toString());
        pacijentTxt.setText(this.pacijent.toString());
        
        srediTabeluUsluge();
    }

    private void srediTabeluUsluge() {
        ModelTabeleUsluga mtu = new ModelTabeleUsluga();
        uslugeTbl.setModel(mtu);
        uslugeTbl.getColumnModel().getColumn(0).setPreferredWidth(300);
        
        PretragaUsluga pu = new PretragaUsluga(stomatolog.getStomatologId(), pacijent.getPacijentId());
        
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_USLUGE_GRUPISANO, pu);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        ((ModelTabeleUsluga) uslugeTbl.getModel()).postaviUsluge((ArrayList<GrupisanaUsluga>) so.getOdgovor());
    }
}
