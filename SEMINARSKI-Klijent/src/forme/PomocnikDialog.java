/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Pomocnik;
import domen.Stomatolog;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author dimit
 */
public class PomocnikDialog extends javax.swing.JDialog {
    Stomatolog stomatolog;
    KlijentskaForma kf;

    /**
     * Creates new form PomocnikDialog
     */
    public PomocnikDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        kf = (KlijentskaForma) parent;
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

        jPanel1 = new javax.swing.JPanel();
        imePomocnikaTxt = new javax.swing.JTextField();
        prezimePomocnikaTxt = new javax.swing.JTextField();
        jmbgPomocnikaTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dodajPomocnikaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pomocnik");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Dodaj novog pomocnika")));

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("JMBG:");

        dodajPomocnikaButton.setText("Dodaj pomocnika");
        dodajPomocnikaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajPomocnikaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imePomocnikaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(prezimePomocnikaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dodajPomocnikaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jmbgPomocnikaTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imePomocnikaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prezimePomocnikaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmbgPomocnikaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(dodajPomocnikaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void dodajPomocnikaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajPomocnikaButtonActionPerformed
        String ime = imePomocnikaTxt.getText();
        String prezime = prezimePomocnikaTxt.getText();
        String jmbg = jmbgPomocnikaTxt.getText();
        
        if ("".equals(ime) || "".equals(prezime) || "".equals(jmbg)) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti pomocnika! Sva polja su obavezna!");
            return;
        }
        
        if (!jmbg.matches("^(\\d{13})$")) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti pomocnika! JMBG mora imati 13 cifara!");
            return;
        }
        
        Pomocnik pomocnik = new Pomocnik(-1, ime, prezime, jmbg, stomatolog);
        
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.UNESI_POMOCNIKA, pomocnik);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        
        boolean uspesnoUnesen = (boolean) so.getOdgovor();
        
        if (uspesnoUnesen) {
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio pomocnika!");
            kf.popuniTabeluPomocnici();
            imePomocnikaTxt.setText("");
            prezimePomocnikaTxt.setText("");
            jmbgPomocnikaTxt.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti pomocnika!");
        }
    }//GEN-LAST:event_dodajPomocnikaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodajPomocnikaButton;
    private javax.swing.JTextField imePomocnikaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jmbgPomocnikaTxt;
    private javax.swing.JTextField prezimePomocnikaTxt;
    // End of variables declaration//GEN-END:variables

    void postaviStomatologa(Stomatolog s) {
        stomatolog = s;
    }
}
