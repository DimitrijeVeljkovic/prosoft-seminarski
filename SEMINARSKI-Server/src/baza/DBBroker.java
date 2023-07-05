/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.Pacijent;
import domen.Pomocnik;
import domen.StavkaCenovnika;
import domen.Stomatolog;
import helperi.PretragaPomocnika;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dimit
 */
public class DBBroker {
    Connection konekcija;
    private static final String DRAJVER = "com.mysql.cj.jdbc.Driver";
    private static final String BAZA = "jdbc:mysql://localhost:3306/prosoft-seminarski";
    
    public void ucitajDrajver() {
        try {
            Class.forName(DRAJVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void otvoriKonekciju() {
        try {
            konekcija = DriverManager.getConnection(BAZA, "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Stomatolog vratiPrijavljenogStomatologa(Stomatolog sLogin) {
        String upit = "SELECT * FROM Stomatolog WHERE korisnickoIme = ? AND lozinka = ?";
        
        try {
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setString(1, sLogin.getKorisnickoIme());
            ps.setString(2, sLogin.getLozinka());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                return new Stomatolog(rs.getInt("stomatologId"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public ArrayList<Pacijent> vratiPacijente() {
        String upit = "SELECT * FROM Pacijent";
        ArrayList<Pacijent> pacijenti = new ArrayList<>();
        
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {
                pacijenti.add(new Pacijent(rs.getInt("pacijentId"), rs.getString("ime"), rs.getString("prezime")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pacijenti;
    }

    public ArrayList<Pomocnik> vratiPomocnikeZaStomatologa(int stomatologId) {
        String upit = "SELECT * FROM Pomocnik WHERE stomatologId = ?";
        ArrayList<Pomocnik> pomocnici = new ArrayList<>();
        
        try {
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setInt(1, stomatologId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                pomocnici.add(
                        new Pomocnik(
                                rs.getInt("pomocnikId"),
                                rs.getString("ime"),
                                rs.getString("prezime"),
                                rs.getString("jmbg"),
                                null
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pomocnici;
    }

    public ArrayList<Pacijent> pretraziPacijente(String kriterijumPacijent) {
        String upit = "SELECT * FROM Pacijent WHERE ime LIKE ? OR prezime LIKE ?";
        ArrayList<Pacijent> pacijenti = new ArrayList<>();
        
        try {
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setString(1, "%" + kriterijumPacijent + "%");
            ps.setString(2, "%" + kriterijumPacijent + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                pacijenti.add(new Pacijent(rs.getInt("pacijentId"), rs.getString("ime"), rs.getString("prezime")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pacijenti;
    }

    public ArrayList<Pomocnik> pretraziPomocnike(PretragaPomocnika pp) {
        String upit = "SELECT * FROM Pomocnik WHERE stomatologId = ? AND ( ime LIKE ? OR prezime LIKE ? OR jmbg LIKE ? )";
        ArrayList<Pomocnik> pomocnici = new ArrayList<>();
        
        try {
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setInt(1, pp.getStomatologId());
            ps.setString(2, "%" + pp.getKriterijumPretrage() + "%");
            ps.setString(3, "%" + pp.getKriterijumPretrage() + "%");
            ps.setString(4, "%" + pp.getKriterijumPretrage() + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                pomocnici.add(
                        new Pomocnik(
                                rs.getInt("pomocnikId"),
                                rs.getString("ime"),
                                rs.getString("prezime"),
                                rs.getString("jmbg"),
                                null
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pomocnici;
    }

    public void unesiPacijenta(Pacijent pacijent) throws SQLException {
        String upit = "INSERT INTO Pacijent (ime, prezime) VALUES (?, ?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setString(1, pacijent.getIme());
        ps.setString(2, pacijent.getPrezime());
        
        ps.executeUpdate();
    }

    public void unesiPomocnika(Pomocnik pomocnik) throws SQLException {
        String upit = "INSERT INTO Pomocnik (ime, prezime, jmbg, stomatologId) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setString(1, pomocnik.getIme());
        ps.setString(2, pomocnik.getPrezime());
        ps.setString(3, pomocnik.getJmbg());
        ps.setInt(4, pomocnik.getStomatolog().getStomatologId());
        
        ps.executeUpdate();
    }

    public void obrisiPomocnika(Pomocnik pomocnikZaBrisanje) throws SQLException {
        String upit = "DELETE FROM Pomocnik WHERE pomocnikId = ?";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setInt(1, pomocnikZaBrisanje.getPomocnikId());
        
        ps.executeUpdate();
    }

    public ArrayList<StavkaCenovnika> vratiStavkeCenovnika() {
        String upit = "SELECT sc.stavkaCenovnikaId, sc.cenovnikId, sc.cena, sc.novcanaJedinica\n" +
                      "FROM stavka_cenovnika AS sc INNER JOIN (SELECT cenovnikId, datumAzuriranja \n" +
                                                              "FROM cenovnik \n" +
                                                              "ORDER BY datumAzuriranja DESC \n" +
                                                              "LIMIT 1) AS c ON sc.cenovnikId = c.cenovnikId;";
        ArrayList<StavkaCenovnika> stavkeCenovnika = new ArrayList<>();
        
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {
                stavkeCenovnika.add(
                        new StavkaCenovnika(
                                rs.getInt("sc.stavkaCenovnikaId"),
                                null,
                                rs.getDouble("sc.cena"),
                                rs.getString("sc.novcanaJedinica")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stavkeCenovnika;
    }
}
