package gui2;

import static gui2.RamkaDodajOsobe.*;
import static gui2.Dodaj.tabela_czytelnik;
import static gui2.Dodaj.tabela_ksiazka;
//import static gui2.RamkaDodajOsobe.getImie;
//import static gui2.RamkaDodajOsobe.getKodPocztowy;
//import static gui2.RamkaDodajOsobe.getMiejscowosc;
//import static gui2.RamkaDodajOsobe.getNazwisko;
//import static gui2.RamkaDodajOsobe.getNrDomu;
//import static gui2.RamkaDodajOsobe.getPlec;
//import static gui2.RamkaDodajOsobe.getTelefon;
//import static gui2.RamkaDodajOsobe.getUlica;
//import static gui2.RamkaDodajOsobe.setEmail;
//import static gui2.RamkaDodajOsobe.setImie;
//import static gui2.RamkaDodajOsobe.setKodPocztowy;
//import static gui2.RamkaDodajOsobe.setMiejscowosc;
//import static gui2.RamkaDodajOsobe.setNazwisko;
//import static gui2.RamkaDodajOsobe.setNrDomu;
//import static gui2.RamkaDodajOsobe.setTelefon;
//import static gui2.RamkaDodajOsobe.setUlica;
import static gui2.oknoGlowne.*;
//import static gui2.adres.adres;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Studenci {

    protected static String url = "jdbc:mysql://127.0.0.1/";
    protected static String dbName = "ksiegarnia";
    protected static String driver = "com.mysql.jdbc.Driver";
    protected static String userName = "root";
    protected static String password = "";
    protected static int id_update;
    protected static Connection conn = null;

    public static void main(String[] args) throws SQLException {

         oknoGlowne okno = new oknoGlowne();
         okno.setVisible(true);
         tabelka();
//         Dodaj frame = new Dodaj();
//         frame.setVisible(true);
//         tabela_czytelnik();
//         tabela_ksiazka();
        // polaczenie();
        //wyswietlDane();
    }
    //------------------------------------------------------------------------------       

    static Connection polaczenie_start() {

        try {
            conn = DriverManager.getConnection(url + dbName, userName, password);
            Class.forName(driver);

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Studenci.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    //----------------------------------------------------------------------------
    static void polaczenie_stop() {
        try {
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(Studenci.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//-----------------------------------------------------------------------------
    static void Dodaj_wypozyczenie(){
        String telefon1=tabela_czytelnik.getValueAt(tabela_czytelnik.getSelectedRow(), 2).toString();
        System.out.println(telefon1);
        String query ="SELECT Id_czytelnik FROM czytelnicy WHERE Telefon=?";
        try{
            polaczenie_start();
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, telefon1);
            //preparedStmt.execute();
            //Statement stmt = conn.createStatement();
            ResultSet rs = preparedStmt.execute();
            System.out.println(query);
            while (rs.next()) {
                int id_czyt=rs.getInt(0);
                System.out.println(id_czyt);
            }
            
        }catch(SQLException e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }polaczenie_stop();
    }
//-----------------------------------------------------------------------------   
    static void Dodaj_czytelnika(String imie,
            String nazwisko,
            String email,
            int telefon) {

        String query = " insert into czytelnik (Imie, Nazwisko, Email, Telefon)"
                + " values (?, ?, ?, ?)";
        try {

            polaczenie_start();
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            System.out.println(imie+nazwisko);
            preparedStmt.setString(1, imie);
            preparedStmt.setString(2, nazwisko);
            preparedStmt.setString(3, email);
            preparedStmt.setInt(4, telefon);
            preparedStmt.execute();
            

        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }polaczenie_stop();
    }
//------------------------------------------------------------------------------

    static void Dodaj_ksiazke(String autor,
            String tytul,
            int rok_wydania,
            String status) {
        System.out.println(autor);
        String query2 = "insert into ksiazki (Autor, Tytul, Rok_wydania, Status)"
                + " values (?, ?, ?, ?)";
        try {

            polaczenie_start();
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);

            preparedStmt2.setString(1, autor);
            preparedStmt2.setString(2, tytul);
            preparedStmt2.setInt(3, rok_wydania);
            preparedStmt2.setString(4, status);

            preparedStmt2.execute();

            polaczenie_stop();

        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
//-----------------------------------------------------------------------------
    static boolean tabelka() {
        boolean zmienna = false;
        int i = 0;

        String query = "SELECT c.Imie, c.Nazwisko, w.Data_wypozyczenia, k.Tytul, k.Autor, w.Termin_oddania "
                + "FROM ksiazki k, czytelnik c, wypozyczenia w "
                + "WHERE w.Id_ksiazki=k.Id_ksiazki AND w.Id_czytelnik=c.Id_czytelnik ";

        try {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            //  DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            polaczenie_start();
            Statement stmt = conn.createStatement();//;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add("''" + rs.getString(4) + "''");
                row.add(rs.getString(5));
                row.add(rs.getString(6));

                model.addRow(row);
                i++;
                model.setRowCount(i);
                model.fireTableDataChanged();

                zmienna = true;

            }
            
            JOptionPane.showConfirmDialog(null, "Wyświetlono wszystkie wypożyczenia ", "Infomacja", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException b) {
            JOptionPane.showConfirmDialog(null, "Polaczenie z baza danych nie powiodlo sie " + b, "Infomacja", JOptionPane.PLAIN_MESSAGE);;
        } catch (HeadlessException e) {
            System.err.println(e.getMessage());
        }
        polaczenie_stop();
        return zmienna;
    }
//----------------------------------------------------------------------------
    static boolean tabela_czytelnik(){

         boolean zmienna = false;
        int i = 0;

        String query = "SELECT Imie, Nazwisko, Telefon, Email "
                + "FROM czytelnik ";
        try {
            DefaultTableModel model = (DefaultTableModel)tabela_czytelnik.getModel();
            //  DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            polaczenie_start();
            Statement stmt = conn.createStatement();//;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Vector row = new Vector();
                row.add(rs.getString("Imie"));
                row.add(rs.getString("Nazwisko"));
                row.add(rs.getInt("Telefon"));
                row.add(rs.getString("Email"));
                model.addRow(row);
                i++;
                model.setRowCount(i);
                model.fireTableDataChanged();
                zmienna = true;

            }
            
        } catch (SQLException b) {
            JOptionPane.showConfirmDialog(null, "Polaczenie z baza danych nie powiodlo sie " + b, "Infomacja", JOptionPane.PLAIN_MESSAGE);;
        } catch (HeadlessException e) {
            System.err.println(e.getMessage());
        }
        polaczenie_stop();
        return zmienna;
    }
    //----------------------------------------------------------------------------
    static boolean tabela_ksiazka(){

         boolean zmienna = false;
        int i = 0;

        String query = "SELECT Autor, Tytul, Rok_wydania, Status "
                + "FROM ksiazki ";
        try {
            DefaultTableModel model = (DefaultTableModel)tabela_ksiazka.getModel();
            //  DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            polaczenie_start();
            Statement stmt = conn.createStatement();//;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Vector row = new Vector();
                row.add(rs.getString("Autor"));
                row.add("''"+rs.getString("Tytul")+"''");
                row.add(rs.getInt("Rok_wydania"));
                row.add(rs.getString("Status"));
                model.addRow(row);
                i++;
                model.setRowCount(i);
                model.fireTableDataChanged();
                zmienna = true;

            }
            
        } catch (SQLException b) {
            JOptionPane.showConfirmDialog(null, "Polaczenie z baza danych nie powiodlo sie " + b, "Infomacja", JOptionPane.PLAIN_MESSAGE);;
        } catch (HeadlessException e) {
            System.err.println(e.getMessage());
        }
        polaczenie_stop();
        return zmienna;
    }
//-----------------------------------------------------------------------------    
    static void usun() {

        String delI = (tabela.getValueAt(tabela.getSelectedRow(), 0)).toString();
        int del = Integer.parseInt(delI);
        String query = "delete from studenci where ID = ?";

        try {
            polaczenie_start();
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, del);
            preparedStmt.execute();
            polaczenie_stop();

            tabelka();

        } catch (SQLException ex) {
            Logger.getLogger(oknoGlowne.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //----------------------------------------------------------------------------        
    static void edytuj() {

        if (tabela.getSelectedRow() == -1) {
            JOptionPane.showConfirmDialog(null, "nie wybrano rekordu! ", "Infomacja", JOptionPane.PLAIN_MESSAGE);
        } else {

            String imie = " ",
                    nazwisko = " ",
                    email = " ",
                    plec = " ",
                    Miejscowosc = " ",
                    KodPocztowy = " ",
                    Ulica = " ";
            int NrDomu = 0,
                    id1 = 0,
                    id2 = 0,
                    telefon = 0;

            String delI = (tabela.getValueAt(tabela.getSelectedRow(), 0)).toString();
            int id = Integer.parseInt(delI);
            try {
                Connection conn = DriverManager.getConnection(url + dbName, userName, password);

                String selectSQL = "SELECT * FROM studenci WHERE ID = ?";
                String selectSQL2 = "SELECT * FROM adresy WHERE ID_adres = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
                PreparedStatement preparedStatement2 = conn.prepareStatement(selectSQL2);

                preparedStatement.setInt(1, id);
                preparedStatement2.setInt(1, id);

                ResultSet rs = preparedStatement.executeQuery();
                ResultSet rs2 = preparedStatement2.executeQuery();

                while (rs.next()) {
                    id1 = rs.getInt(1);
                    imie = rs.getString(2);
                    nazwisko = rs.getString(3);
                    email = rs.getString(4);
                    plec = rs.getString(5);
                    telefon = rs.getInt(6);
                }

                while (rs2.next()) {
                    id2 = rs2.getInt(1);
                    Miejscowosc = rs2.getString(2);
                    KodPocztowy = Integer.toString(rs2.getInt(3));
                    Ulica = rs2.getString(4);
                    NrDomu = rs2.getInt(5);
                }
                // System.out.println(id1+imie+nazwisko+email+plec+telefon+id2+Miejscowosc+KodPocztowy+Ulica+NrDomu);
                RamkaDodajOsobe frame = new RamkaDodajOsobe();
                frame.setVisible(true);

                setImie(imie);
                setNazwisko(nazwisko);
                setEmail(email);
                setTelefon(telefon);
                setMiejscowosc(Miejscowosc);
                setKodPocztowy(KodPocztowy);
                setUlica(Ulica);
                setNrDomu(NrDomu);
                conn.close();
                if (id1 == id2) {
                    id_update = id2;
                } else {
                    JOptionPane.showConfirmDialog(null, "problem z indeksowaniem ", "Infomacja", JOptionPane.PLAIN_MESSAGE);
                }

            } catch (SQLException b) {
                JOptionPane.showConfirmDialog(null, "Polaczenie z baza danych nie powiodlo sie " + b, "Infomacja", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    //----------------------------------------------------------------------------
    static void aktualizuj() throws SQLException {

        String query = "UPDATE studenci SET Imie=?,Nazwisko=?,email=?,plec=?,telefon=? WHERE ID=?";
        String query2 = "UPDATE adresy SET Miejscowosc=?,KodPocztowy=?,Ulica=?,NrDomu=? WHERE ID_adres=?";

        try (Connection conn = DriverManager.getConnection(url + dbName, userName, password)) {
            try {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, getImie());
                preparedStmt.setString(2, getNazwisko());
                preparedStmt.setString(3, getEmail());
                // preparedStmt.setString(4, getPlec());
                preparedStmt.setInt(5, getTelefon());
                preparedStmt.setInt(6, id_update);
                preparedStmt.execute();

                PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
                preparedStmt2.setString(1, getMiejscowosc());
                preparedStmt2.setString(2, getKodPocztowy());
                preparedStmt2.setString(3, getUlica());
                preparedStmt2.setString(4, getNrDomu());
                preparedStmt2.setInt(5, id_update);
                preparedStmt2.execute();
            } catch (SQLException e) {

                JOptionPane.showConfirmDialog(null, "bład indeksow! ", "Infomacja", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }


    //--------------------------------------------------------------------------

    static void wyswietlDane() {
        String query = "SELECT k.Autor, k.Tytul, c.Imie, c.Nazwisko, w.Data_wypozyczenia "
                + "FROM ksiazki k, czytelnik c, wypozyczenia w "
                + "where w.Id_ksiazki=k.Id_ksiazki and w.Id_czytelnik=c.Id_czytelnik";

        try {
            polaczenie_start();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int i = 1;
            while (rs.next()) {
                String autor = rs.getString("Autor");
                String imie = rs.getString("Imie");
                String nazwisko = rs.getString("Nazwisko");
                String tytul = rs.getString("Tytul");
                String data = rs.getString("Data_wypozyczenia");
                System.out.print(i + ". " + autor + ", ''" + tytul + "'' --" + data + "-- " + imie + " " + nazwisko);
                System.out.print("\n --------------\n");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        polaczenie_stop();
    }

}
