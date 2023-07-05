/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Pacijent;
import domen.Pomocnik;
import domen.Stomatolog;
import helperi.PretragaPomocnika;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import modeli.ModelTabelePacijent;
import modeli.ModelTabelePomocnik;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author dimit
 */
public class KlijentskaForma extends javax.swing.JFrame {
    Stomatolog stomatolog;

    /**
     * Creates new form KlijentskaForma
     */
    public KlijentskaForma(Stomatolog s) {
        initComponents();
        setLocationRelativeTo(null);
        stomatolog = s;
        prijavljeniStomatologLbl.setText(stomatolog.getIme() + " " + stomatolog.getPrezime());
        srediTabeluPacijenti();
        srediTabeluPomocnici();
        popuniTabeluPacijenti();
        popuniTabeluPomocnici();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        prijavljeniStomatologLbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pacijentiTbl = new javax.swing.JTable();
        pretraziPacijenteTxt = new javax.swing.JTextField();
        dodajPacijentaButton = new javax.swing.JButton();
        pretraziPacijenteButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pomocniciTbl = new javax.swing.JTable();
        pretraziPomocnikeTxt = new javax.swing.JTextField();
        pretraziPomocnikeButton = new javax.swing.JButton();
        dodajPomocnikaButton = new javax.swing.JButton();
        obrisiPomocnikaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Prijavljeni stomatolog: ");

        prijavljeniStomatologLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        prijavljeniStomatologLbl.setText("Ime i Prezime");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacijenti"));

        pacijentiTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(pacijentiTbl);

        dodajPacijentaButton.setText("Dodaj pacijenta");
        dodajPacijentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajPacijentaButtonActionPerformed(evt);
            }
        });

        pretraziPacijenteButton.setText("Pretrazi pacijente");
        pretraziPacijenteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pretraziPacijenteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(pretraziPacijenteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pretraziPacijenteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dodajPacijentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pretraziPacijenteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pretraziPacijenteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dodajPacijentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pomocnici"));

        pomocniciTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(pomocniciTbl);

        pretraziPomocnikeButton.setText("Pretrazi pomocnike");
        pretraziPomocnikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pretraziPomocnikeButtonActionPerformed(evt);
            }
        });

        dodajPomocnikaButton.setText("Dodaj pomocnika");
        dodajPomocnikaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajPomocnikaButtonActionPerformed(evt);
            }
        });

        obrisiPomocnikaButton.setText("Obrisi pomocnika");
        obrisiPomocnikaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obrisiPomocnikaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(pretraziPomocnikeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pretraziPomocnikeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(obrisiPomocnikaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dodajPomocnikaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pretraziPomocnikeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pretraziPomocnikeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodajPomocnikaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obrisiPomocnikaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prijavljeniStomatologLbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(prijavljeniStomatologLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pretraziPacijenteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pretraziPacijenteButtonActionPerformed
        String kriterijumPretrage = pretraziPacijenteTxt.getText();
        
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRETRAZI_PACIJENTE, kriterijumPretrage);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        ArrayList<Pacijent> pacijenti = (ArrayList<Pacijent>) so.getOdgovor();
        ((ModelTabelePacijent) pacijentiTbl.getModel()).postaviPacijente(pacijenti);
        
        if (!pacijenti.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem je nasao pacijente po zadatoj vrednosti!");
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje pacijente po zadatoj vrednosti!");
        }
    }//GEN-LAST:event_pretraziPacijenteButtonActionPerformed

    private void pretraziPomocnikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pretraziPomocnikeButtonActionPerformed
        String kriterijumPretrage = pretraziPomocnikeTxt.getText();
        PretragaPomocnika pp = new PretragaPomocnika(stomatolog.getStomatologId(), kriterijumPretrage);
        
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRETRAZI_POMOCNIKE_ZA_STOMATOLOGA, pp);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        ArrayList<Pomocnik> pomocnici = (ArrayList<Pomocnik>) so.getOdgovor();
        ((ModelTabelePomocnik) pomocniciTbl.getModel()).postaviPomocnike(pomocnici);
        
        if (!pomocnici.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem je nasao pomocnike po zadatoj vrednosti!");
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje pomocnike po zadatoj vrednosti!");
        }
        
    }//GEN-LAST:event_pretraziPomocnikeButtonActionPerformed

    private void dodajPacijentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajPacijentaButtonActionPerformed
        PacijentDialog pd = new PacijentDialog(this, false);
        pd.setVisible(true);
    }//GEN-LAST:event_dodajPacijentaButtonActionPerformed

    private void dodajPomocnikaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajPomocnikaButtonActionPerformed
        PomocnikDialog pd = new PomocnikDialog(this, false);
        pd.setVisible(true);
        pd.postaviStomatologa(stomatolog);
    }//GEN-LAST:event_dodajPomocnikaButtonActionPerformed

    private void obrisiPomocnikaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obrisiPomocnikaButtonActionPerformed
        int redUTabeli = pomocniciTbl.getSelectedRow();
        
        if (redUTabeli == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise pomocnika! Pomocnik mora biti selektovan u tabeli!");
            return;
        }
        
        Pomocnik pomocnik = ((ModelTabelePomocnik) pomocniciTbl.getModel()).nadjiPomocnika(redUTabeli);
        
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.OBRISI_POMOCNIKA, pomocnik);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        boolean uspesnoObrisan = (boolean) so.getOdgovor();
        
        if (uspesnoObrisan) {
            JOptionPane.showMessageDialog(this, "Sistem je obrisao pomocnika!");
            popuniTabeluPomocnici();
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise pomocnika!");
        }
    }//GEN-LAST:event_obrisiPomocnikaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodajPacijentaButton;
    private javax.swing.JButton dodajPomocnikaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton obrisiPomocnikaButton;
    private javax.swing.JTable pacijentiTbl;
    private javax.swing.JTable pomocniciTbl;
    private javax.swing.JButton pretraziPacijenteButton;
    private javax.swing.JTextField pretraziPacijenteTxt;
    private javax.swing.JButton pretraziPomocnikeButton;
    private javax.swing.JTextField pretraziPomocnikeTxt;
    private javax.swing.JLabel prijavljeniStomatologLbl;
    // End of variables declaration//GEN-END:variables

    private void srediTabeluPomocnici() {
        ModelTabelePomocnik mt = new ModelTabelePomocnik();
        pomocniciTbl.setModel(mt);
    }

    private void srediTabeluPacijenti() {
        ModelTabelePacijent mt = new ModelTabelePacijent();
        pacijentiTbl.setModel(mt);
    }

    public void popuniTabeluPacijenti() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_PACIJENTE, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        ArrayList<Pacijent> pacijenti = (ArrayList<Pacijent>) so.getOdgovor();
        ((ModelTabelePacijent) pacijentiTbl.getModel()).postaviPacijente(pacijenti);
    }

    public void popuniTabeluPomocnici() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_POMOCNIKE_ZA_STOMATOLOGA, stomatolog.getStomatologId());
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        ArrayList<Pomocnik> pomocnici = (ArrayList<Pomocnik>) so.getOdgovor();
        ((ModelTabelePomocnik) pomocniciTbl.getModel()).postaviPomocnike(pomocnici);
    }
}
