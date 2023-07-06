/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.Pacijent;
import domen.Pomocnik;
import domen.Racun;
import domen.StavkaCenovnika;
import domen.StavkaRacuna;
import domen.Stomatolog;
import domen.Usluga;
import helperi.GrupisanaUsluga;
import helperi.PomocniRacun;
import helperi.PretragaPomocnika;
import helperi.PretragaUsluga;
import java.sql.Connection;
import java.sql.Date;
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
        String upit = "SELECT sc.stavkaCenovnikaId, sc.cenovnikId, sc.naziv, sc.cena, sc.novcanaJedinica\n" +
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
                                rs.getString("sc.naziv"),
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

    public void unesiUslugu(Usluga usluga) throws SQLException {
        String upit = "INSERT INTO Usluga (stomatologId, pacijentId, datum, opis, pomocnikId, stavkaCenovnikaId) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setInt(1, usluga.getStomatolog().getStomatologId());
        ps.setInt(2, usluga.getPacijent().getPacijentId());
        ps.setDate(3, new Date(usluga.getDatum().getTime()));
        ps.setString(4, usluga.getOpis());
        ps.setInt(5, usluga.getPomocnik().getPomocnikId());
        ps.setInt(6, usluga.getStavkaCenovnika().getStavkaCenovnikaId());
        
        ps.executeUpdate();
    }

    public void dodajNoviCenovnik(int cenovnikId, java.util.Date trenutniDatum) throws SQLException {
        String upit = "INSERT INTO Cenovnik (cenovnikId, datumAzuriranja) VALUES (?, ?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setInt(1, cenovnikId);
        ps.setDate(2, new Date(trenutniDatum.getTime()));
        
        ps.executeUpdate();
    }

    public void dodajStavkuCenovnika(int cenovnikId, StavkaCenovnika stavkaCenovnika) throws SQLException {
        String upit = "INSERT INTO stavka_cenovnika (cenovnikId, naziv, cena, novcanaJedinica) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setInt(1, cenovnikId);
        ps.setString(2, stavkaCenovnika.getNaziv());
        ps.setDouble(3, stavkaCenovnika.getCena());
        ps.setString(4, stavkaCenovnika.getNovcanaJedinica());
        
        ps.executeUpdate();
    }

    public ArrayList<GrupisanaUsluga> vratiUslugeGrupisano(PretragaUsluga pu) {
        String upit = "SELECT s.naziv, SUM(s.cena) as iznos, COUNT(u.uslugaId) as kolicina "
                    + "FROM usluga u INNER JOIN stavka_cenovnika s ON u.stavkaCenovnikaId = s.stavkaCenovnikaId "
                    + "WHERE u.stomatologId = ? AND u.pacijentId = ? "
                    + "GROUP BY s.stavkaCenovnikaId";
        ArrayList<GrupisanaUsluga> usluge = new ArrayList<>();
        
        try {
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setInt(1, pu.getStomatologId());
            ps.setInt(2, pu.getPacijentId());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                GrupisanaUsluga u = new GrupisanaUsluga(
                        rs.getString("s.naziv"),
                        rs.getDouble("iznos"),
                        rs.getInt("kolicina")
                );
                usluge.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usluge;
    };

    public void unesiRacun(Racun racun) throws SQLException {
        String upit = "INSERT INTO racun (racunId, datumIzdavanja, ukupanIznos, stomatologId, pacijentId) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setInt(1, racun.getRacunId());
        ps.setDate(2, new Date(racun.getDatumIzdavanja().getTime()));
        ps.setDouble(3, racun.getUkupanIznos());
        ps.setInt(4, racun.getStomatolog().getStomatologId());
        ps.setInt(5, racun.getPacijent().getPacijentId());
        
        ps.executeUpdate();
    };

    public void unesiStavkuRacuna(StavkaRacuna stavka) throws SQLException {
        String upit = "INSERT INTO stavka_racuna (racunId, iznos, kolicina) VALUES (?, ?, ?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        
        ps.setInt(1, stavka.getRacun().getRacunId());
        ps.setDouble(2, stavka.getIznos());
        ps.setInt(3, stavka.getKolicina());
        
        ps.executeUpdate();
    }
}
