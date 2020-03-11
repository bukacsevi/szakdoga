package newpackage;

import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @Bukács Éva
 */
public class DbKapcsolat {

    private Vector<Termék> termekek;
    private Vector<Raktár> raktarak;
    private Vector<Vevő> vevok;
    private Vector<Beszállító> beszallitok;
    private Vector<Termék> termekekAdottRaktarban;

    private String database;
    private Connection con;
    private Statement stmt;
    private PreparedStatement ptmt;

    public DbKapcsolat() {
        termekek = new Vector<Termék>();
        raktarak = new Vector<Raktár>();
        vevok = new Vector<Vevő>();
        beszallitok = new Vector<Beszállító>();
        termekekAdottRaktarban = new Vector<Termék>();

        //Kapcsolat az adatbázissal
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "jelszo");
            //c.setAutoCommit(false);
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.err.println("Adatbáziskapcsolati hiba!");
            System.exit(0);
        }
        System.out.println("Csatlakozva");

        /* if (con != null) {
         try {
         stmt = con.createStatement();
         } catch (SQLException ex) {
         System.out.println("Hiba a statementel: " + ex);
         }

         }*/
        //Táblák létrehozása ha még nem létezik
        //Beszállítók tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS beszallitok("
                    + "cegId  SERIAL NOT NULL PRIMARY KEY,"
                    + "cegNev text,"
                    + "telephely text,"
                    + "cegTelefonSzam text,"
                    + "cegEmailCim text,"
                    + "cegAdoSzam text)");

            System.out.println("tábla beszallitok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a beszallitok tábla létrehozásánál");
        }

        //Termék Tábla
        try {      //BESZÁLLITOiD és nem kell db
            stmt.execute("CREATE TABLE IF NOT EXISTS termekek("
                    + "termekId  SERIAL NOT NULL PRIMARY KEY,"
                    + "cegId int REFERENCES beszallitok(cegId),"
                    + "cikkszám text," // legyen unique
                    + "megnevezes text,"
                    + "ar int)");

            System.out.println("tábla termekek létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a termek tábla létrehozásánál");
        }

        //Raktár Tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS raktarak("
                    + "raktarId  SERIAL NOT NULL PRIMARY KEY,"
                    + "raktarNev text," //legyen unique
                    + "raktarCim text,"
                    + "raktarTelefonSzam text,"
                    + "raktarEmailCim text)");

            System.out.println("tábla raktarak létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a raktar tábla létrehozásánál");
        }

        //Vevők tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS vevok("
                    + "vevoId  SERIAL NOT NULL PRIMARY KEY,"
                    + "vezetekNev text,"
                    + "keresztNev text,"
                    + "vevocim text,"
                    + "vevoTelefonSzam text,"
                    + "vevoEmailCim text)");

            System.out.println("tábla vevok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a vevok tábla létrehozásánál");
        }

        //Tranzakciók tábla //legyen dátum
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS tranzakciok ("
                    + "  tranzakcioId SERIAL NOT NULL PRIMARY KEY,   "
                    + "  raktarId int REFERENCES raktarak(raktarId),"
                    + "  termekId int REFERENCES termekek(termekId),"
                    + "  termekDb int DEFAULT 0"
                    + ")");

            System.out.println("tábla tranzakciok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a tranzakciok tábla létrehozásásnál");
        }

        //Atvezetés tábla //legyen dátum
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS atvezetes ("
                    + "  atvezetesId SERIAL NOT NULL PRIMARY KEY,   "
                    + "  startRaktarId int REFERENCES raktarak(raktarId),"
                    + "  celRaktarId int REFERENCES raktarak(raktarId),"
                    + "  termekId int REFERENCES termekek(termekId),"
                    + "  atvittTermekDb int DEFAULT 0"
                    + ")");

            System.out.println("tábla atvezetes létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba az atvezetes tábla létrehozásásnál");
        }

        termekekVektorFeltolt();
        raktarakVektorFeltolt();
        vevokVektorFeltolt();
        beszallitokVektorFeltolt();

        //lekerdezTranzakcio();
    }

    public Vector<Termék> getTermekek() {
        return this.termekek;
    }

    public Vector<Raktár> getRaktarak() {
        return this.raktarak;
    }
    
    public ComboBoxModel getRaktarakModel(){
        ComboBoxModel model=null;
            
        return model;
    }
    public Vector<Vevő> getVevok() {
        return this.vevok;
    }

    public Vector<Beszállító> getBeszallitok() {
        return this.beszallitok;
    }

    public Vector<Termék> getTermekekAdottRaktarban() {
        return termekekAdottRaktarban;
    }

    public void raktarkoziAtvezetes(int startRaktarId, int celRaktarId, int termekId, int hanyDb) {
        int startRaktarDb = 0;
        int celRaktarDb = 0;
        int startRaktarbanMaradoTermekDb = 0;
        int celRaktarJovebeniTermekDb = 0; //0 kuldendo darabnál ne csináljon semmit, és ne jelenlen meg a sartraktár a célraktárnál
        int letezikEmarAtranzakcio = -1;//ha 0lesz a start raktárban akkor törölje a tranzakciokból a sort
        ResultSet rs;

        try {
            //van e a cél raktárban már az átvezetendő termékből
            rs = stmt.executeQuery("SELECT count(*) letezikE FROM tranzakciok where raktarId=" + celRaktarId + " AND termekId=" + termekId + ";");

            while (rs.next()) {
                letezikEmarAtranzakcio = rs.getInt("letezikE");
                System.out.println(letezikEmarAtranzakcio);
            }

            //mennyi van a kiindulási raktárban a termékből
            rs = stmt.executeQuery("SELECT termekDb FROM tranzakciok WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + ";");
            while (rs.next()) {
                startRaktarDb = rs.getInt("termekDb");
            }

            //mennyi van cél raktárban a termékből
            rs = stmt.executeQuery("SELECT termekDb FROM tranzakciok WHERE raktarId=" + celRaktarId + " AND termekId=" + termekId + ";");
            while (rs.next()) {
                celRaktarDb = rs.getInt("termekDb");
            }

            startRaktarbanMaradoTermekDb = startRaktarDb - hanyDb;
            celRaktarJovebeniTermekDb = celRaktarDb + hanyDb;

            //tranzakcio módosít ha már van a célraktárban a termékből
            if (startRaktarbanMaradoTermekDb > -1 && letezikEmarAtranzakcio == 1 && hanyDb != 0) {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + "; ");
                ptmt.setInt(1, startRaktarbanMaradoTermekDb);
                ptmt.executeUpdate();

                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE raktarId=" + celRaktarId + " AND termekId=" + termekId + "; ");
                ptmt.setInt(1, celRaktarJovebeniTermekDb);
                ptmt.executeUpdate();

                //atvezetes rögzítése
                ptmt = con.prepareStatement("INSERT INTO atvezetes (startRaktarId,celRaktarId,termekId,atvittTermekDb) VALUES(?,?,?,?)");
                ptmt.setInt(1, startRaktarId);
                ptmt.setInt(2, celRaktarId);
                ptmt.setInt(3, termekId);
                ptmt.setInt(4, hanyDb);
                ptmt.executeUpdate();

            } //tranzakcio feltölt ha még nincs a célraktárban a termékből
            else if (startRaktarbanMaradoTermekDb > -1 && letezikEmarAtranzakcio == 0 && hanyDb != 0) {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + "; ");
                ptmt.setInt(1, startRaktarbanMaradoTermekDb);
                ptmt.executeUpdate();

                ptmt = con.prepareStatement("INSERT INTO tranzakciok (raktarId,termekId,termekDb) VALUES(?,?,?)");
                ptmt.setInt(1, celRaktarId);
                ptmt.setInt(2, termekId);
                ptmt.setInt(3, hanyDb);
                ptmt.executeUpdate();

                //atvezetes rögzitese
                ptmt = con.prepareStatement("INSERT INTO atvezetes (startRaktarId,celRaktarId,termekId,atvittTermekDb) VALUES(?,?,?,?)");
                ptmt.setInt(1, startRaktarId);
                ptmt.setInt(2, celRaktarId);
                ptmt.setInt(3, termekId);
                ptmt.setInt(4, hanyDb);
                ptmt.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
        lekerdezTranzakcio();
    }

    public void bevetelezes(int raktarId, int termekId, int db) {
        int ujTermekDarab = 0;
        int letezikEmarAtranzakcio = -1;
        ResultSet rs;

        //Létezeik e már ez a tranzakció, új termék darab szám számolása//fv-t csinálni belole
        try {
            rs = stmt.executeQuery("SELECT count(*) letezikE FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");

            //letezikEmarAtranzakcio==0, ha nem és 1,ha igen//egy termékid raktárid pár csak egyszer szerepelhet
            while (rs.next()) {
                letezikEmarAtranzakcio = rs.getInt("letezikE");
            }

            //a régi darabszám plusz az új darabszám, régit lekérdezi
            rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");
            while (rs.next()) {
                ujTermekDarab = db + rs.getInt("termekDb");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Nincs ilyen tranzakcio, inzertálja
        if (letezikEmarAtranzakcio == 0) {
            try {
                ptmt = con.prepareStatement("INSERT INTO tranzakciok (raktarId,termekId,termekDb)VALUES(?,?,?);");
                ptmt.setInt(1, raktarId);
                ptmt.setInt(2, termekId);
                ptmt.setInt(3, db);
                ptmt.executeUpdate();
                System.out.println("Tranzakcio hozzáadva");
            } catch (SQLException ex) {
                Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Van már ilyen tranzakcio, módosítsa a darabszámot
            //Van már ilyen tranzakcio, módosítsa a darabszámot
        } else if (letezikEmarAtranzakcio != 0) {
            try {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE  termekId=" + termekId + " AND raktarId=" + raktarId + ";");
                ptmt.setInt(1, ujTermekDarab);
                ptmt.executeUpdate();
                System.out.println("Tranzakcio hozzáadva");
            } catch (SQLException ex) {
                Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //tranzakciók kiírása
        lekerdezTranzakcio();
    }

    public void kivételezés(int raktarId, int termekId, int db) throws Exception {
        int ujTermekDarab = 0;
        int aktualisTermekDarab = 0;
        ResultSet rs;

        try {
            rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok WHERE tranzakciok.raktarId='" + raktarId + "' AND tranzakciok.termekId='" + termekId + "';");

            while (rs.next()) {
                aktualisTermekDarab = rs.getInt("termekDb");
            }
        } catch (Exception e) {
            System.err.println("hiba");
        }

        ujTermekDarab = aktualisTermekDarab - db;

        if (ujTermekDarab < 0) {
            throw new Exception("A kivételezendő termék mennyiség túllépi a raktárban lévő termékek számát! ");
        } else {
            try {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE tranzakciok.raktarId= " + raktarId + " AND tranzakciok.termekId=" + termekId + ";");
                ptmt.setInt(1, ujTermekDarab);
                ptmt.executeUpdate();
            } catch (Exception e) {
                System.err.println("hiba");
            }
        }

        lekerdezTranzakcio();
    }

    public String sqlLetrezoz(int raktarId, String termekMegnevezes, String termekCikkszam) {
        String sql = "SELECT raktarak.raktarNev, termekek.cikkszám, termekek.megnevezes, termekek.ar, tranzakciok.termekDb FROM ((tranzakciok INNER JOIN termekek ON tranzakciok.termekId=termekek.termekId) INNER JOIN raktarak ON tranzakciok.raktarId=raktarak.raktarId)";
        String raktarSql = "tranzakciok.raktarId=" + "" + raktarId + "";
        String megnevezesSql = "termekek.megnevezes=" + "'" + termekMegnevezes + "'";
        String cikkszamSql = "termekek.cikkszám=" + "'" + termekCikkszam + "'";

        String WHERE = " WHERE ";
        String AND = " AND ";
        int mennyi = 0;
        int szamol = 0;

        if (raktarId != 0) {
            mennyi = mennyi + 1;
        }
        if (!(termekMegnevezes.equals(""))) {
            mennyi = mennyi + 1;
        }
        if (!(termekCikkszam.equals(""))) {
            mennyi = mennyi + 1;
        }
        if (mennyi > 0) {
            sql = sql + WHERE;
        } else {
            sql = sql + ";";
        }
        System.out.println(sql);

        if (raktarId != 0) {
            sql = sql + raktarSql;
            szamol = szamol + 1;
            System.out.println(sql);
            if (mennyi == szamol) {
                sql = sql + ";";
                System.out.println(sql);
            }
            if (szamol < mennyi) {
                sql = sql + AND;
                System.out.println(sql);
            }
        }
        if (!(termekMegnevezes.equals(""))) {
            sql = sql + megnevezesSql;
            szamol = szamol + 1;
            System.out.println(sql);
            if (mennyi == szamol) {
                sql = sql + ";";
                System.out.println(sql);
            }
            if (szamol < mennyi) {
                sql = sql + AND;
                System.out.println(sql);
            }
        }
        if (!(termekCikkszam.equals(""))) {
            sql = sql + cikkszamSql;
            szamol = szamol + 1;
            System.out.println(sql);
            if (mennyi == szamol) {
                sql = sql + ";";
                System.out.println(sql);
            }
            if (szamol < mennyi) {
                sql = sql + AND;
                System.out.println(sql);
            }
        }
        return sql;
    }

    public DefaultTableModel lekerdezes(int raktarId, String termekMegnevezes, String termekCikkszam) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Raktár");
        model.addColumn("Cikkszám");
        model.addColumn("Megnevezés");
        model.addColumn("Ár");
        model.addColumn("Mennyiség");

        try {
            String sql = sqlLetrezoz(raktarId, termekMegnevezes, termekCikkszam);
            //ResultSet rs = stmt.executeQuery("SELECT raktarak.raktarNev, termekek.cikkszám, termekek.megnevezes, termekek.ar, tranzakciok.termekDb FROM ((tranzakciok INNER JOIN termekek ON tranzakciok.termekId=termekek.termekId) INNER JOIN raktarak ON tranzakciok.raktarId=raktarak.raktarId) WHERE tranzakciok.raktarId=" + raktarId + " AND termekek.megnevezes='"+termekMegnevezes+"' AND termekek.cikkszám='"+termekCikkszam+"' ;");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("raktarNev"), rs.getString("cikkszám"), rs.getString("megnevezes"), rs.getInt("ar"), rs.getInt("termekDb")});

            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return model;
    }
    public int lekerdezesLeltar(int raktarId, String termekMegnevezes, String termekCikkszam) {

        int darab=0;

        try {
            String sql = sqlLetrezoz(raktarId, termekMegnevezes, termekCikkszam);
            //ResultSet rs = stmt.executeQuery("SELECT raktarak.raktarNev, termekek.cikkszám, termekek.megnevezes, termekek.ar, tranzakciok.termekDb FROM ((tranzakciok INNER JOIN termekek ON tranzakciok.termekId=termekek.termekId) INNER JOIN raktarak ON tranzakciok.raktarId=raktarak.raktarId) WHERE tranzakciok.raktarId=" + raktarId + " AND termekek.megnevezes='"+termekMegnevezes+"' AND termekek.cikkszám='"+termekCikkszam+"' ;");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                darab=rs.getInt("termekDb");

            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return darab;
    }

    public DefaultTableModel eletutLekerdezes() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("startRaktár");
        model.addColumn("celrakar");
        model.addColumn("termek");
        model.addColumn("db");
               

        try {            
            
            ResultSet rs = stmt.executeQuery("SELECT r.raktarNev as b, s.raktarNev as c, termekek.megnevezes, atvezetes.atvittTermekDb "
                                            +"FROM (((atvezetes  INNER JOIN raktarak as r ON atvezetes.startRaktarId=r.raktarId)"
                                                               +"INNER JOIN raktarak as s ON atvezetes.celRaktarId=s.raktarId) "
                                                               +"INNER JOIN termekek  ON atvezetes.termekId=termekek.termekId); ");
            
            System.out.println(rs);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("b"),rs.getString("c"),rs.getString("megnevezes"),rs.getInt("atvittTermekDb")});               
                
            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }
        
        return model;
    }
    public DefaultTableModel eletutLekerdezes(int raktarid) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("startRaktár");
        model.addColumn("celrakar");
        model.addColumn("termek");
        model.addColumn("db");
               

        try {            
            
            ResultSet rs = stmt.executeQuery("SELECT r.raktarNev as b, s.raktarNev as c, termekek.megnevezes, atvezetes.atvittTermekDb "
                                            +"FROM (((atvezetes  INNER JOIN raktarak as r ON atvezetes.startRaktarId=r.raktarId)"
                                                               +"INNER JOIN raktarak as s ON atvezetes.celRaktarId=s.raktarId) "
                                                               +"INNER JOIN termekek  ON atvezetes.termekId=termekek.termekId)WHERE atvezetes.startRaktarId="+raktarid+"; ");
            
            System.out.println(rs);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("b"),rs.getString("c"),rs.getString("megnevezes"),rs.getInt("atvittTermekDb")});               
                
            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }
        
        return model;
    }

    private void lekerdezTranzakcio() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT startRaktarId, celRaktarId, termekId, atvittTermekDb FROM atvezetes;");

            System.out.println("_____________________Tranzakciok:___________________________");
            while (rs.next()) {

                System.out.println("start:  " + rs.getInt("startRaktarId"));
                System.out.println("cel  :" + rs.getString("celRaktarId"));
                System.out.println("termek :  " + rs.getString("termekId"));
                System.out.println("termek db:  " + rs.getInt("atvittTermekDb"));
                System.out.println("");

            }//while
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");
            //System.err.println(se.getSQLState()); //hibakód
            System.err.println(se.getMessage()); //sql hibaüzenet
        }

    }

    public Termék lekerdezTermek(String cikkszam) {
        Termék termek=null;
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek INNER JOIN beszallitok ON termekek.cegId=beszallitok.cegId WHERE termekek.cikkszám='"+cikkszam+"';");
            
            while (rs.next()) {
                 termek= new Termék(rs.getInt("termekId"),
                                  rs.getInt("cegId"),
                                  rs.getString("cikkszám"),
                                  rs.getString("megnevezes"),
                                  rs.getInt("ar"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a terméklekérdezésnél");
        }
        return termek;
    }

    public Raktár lekerdezRaktar(String raktarNev) {
        Raktár raktar=null;
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak WHERE raktarNev='"+raktarNev+"';");

            
            while (rs.next()) {

                raktar=new Raktár(rs.getInt("raktarId"),
                rs.getString("raktarNev"),
                rs.getString("raktarCim"),
                rs.getString("raktarTelefonSzam"),
                rs.getString("raktarEmailCim"));
                

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
        return raktar;
    }

    public Vevő lekerdezVevo(String email) {
        Vevő vevo=null;
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok WHERE vevoEmailCim='"+email+"' ;");

            
            while (rs.next()) {
                vevo=new Vevő(rs.getInt("vevoId"),
                rs.getString("vezetekNev"),
                rs.getString("keresztNev"),
                rs.getString("vevoCim"),
                rs.getString("vevoTelefonSzam"),
                rs.getString("vevoEmailCim"));

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
        return vevo;
    }

    public Beszállító lekerdezBeszallito(int beszallitoId) {
        Beszállító beszallito=null;
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok WHERE cegId="+beszallitoId+" ;");

            
            while (rs.next()) {
                beszallito=new Beszállító(rs.getInt("cegId"),
                rs.getString("cegNev"),
                rs.getString("telephely"),
                rs.getString("cegTelefonSzam"),
                rs.getString("cegEmailCim"),
                rs.getString("cegAdoszam"));
                

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
        return beszallito;
    }

    private void ujTermekVektorhozAd(Termék termek) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek WHERE cikkszám='" + termek.getCikkszam() + "' ;");

            while (rs.next()) {
                termekek.add(new Termék(rs.getInt("termekId"),
                        rs.getInt("cegId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ujRaktarVektorhozAd(Raktár raktar) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak WHERE raktarNev='" + raktar.getRaktarNev() + "' ;");

            while (rs.next()) {
                raktarak.add(new Raktár(rs.getInt("raktarId"),
                        rs.getString("raktarNev"),
                        rs.getString("raktarCim"),
                        rs.getString("raktarTelefonSzam"),
                        rs.getString("raktarEmailCim")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void ujVevoVektorhozAd(Vevő vevo) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok WHERE vevoEmailCim='" + vevo.getVevoEmailCim() + "' ;");

            while (rs.next()) {
                vevok.add(new Vevő(rs.getInt("vevoId"),
                        rs.getString("vezetekNev"),
                        rs.getString("keresztNev"),
                        rs.getString("vevoCim"),
                        rs.getString("vevoTelefonSzam"),
                        rs.getString("vevoEmailCim")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ujBeszallitoVektorhozAd(Beszállító beszallito) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok WHERE cegNev='" + beszallito.getCegNev() + "' ;");

            while (rs.next()) {
                beszallitok.add(new Beszállító(rs.getInt("cegId"),
                        rs.getString("cegNev"),
                        rs.getString("telephely"),
                        rs.getString("cegTelefonSzam"),
                        rs.getString("cegEmailCim"),
                        rs.getString("cegAdoSzam")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void termekekVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek ;");
            termekek.clear();

            while (rs.next()) {
                termekek.add(new Termék(rs.getInt("termekId"),
                        rs.getInt("cegId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar")));

            }
        } catch (SQLException se) {
            System.err.println("Termék lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void raktarakVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak ;");
            raktarak.clear();
            while (rs.next()) {

                raktarak.add(new Raktár(rs.getInt("raktarId"),
                        rs.getString("raktarNev"),
                        rs.getString("raktarCim"),
                        rs.getString("raktarTelefonSzam"),
                        rs.getString("raktarEmailCim")));
            }
        } catch (SQLException se) {
            System.err.println("Raktár lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void vevokVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok ;");
            vevok.clear();

            while (rs.next()) {
                vevok.add(new Vevő(rs.getInt("vevoId"),
                        rs.getString("vezetekNev"),
                        rs.getString("keresztNev"),
                        rs.getString("vevoCim"),
                        rs.getString("vevoTelefonSzam"),
                        rs.getString("vevoEmailCim")));

            }
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void beszallitokVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok ;");
            beszallitok.clear();  //régi adatokat eldobja

            while (rs.next()) {
                //újakkal feltölti
                beszallitok.add(new Beszállító(rs.getInt("cegId"),
                        rs.getString("cegNev"),
                        rs.getString("telephely"),
                        rs.getString("cegTelefonSzam"),
                        rs.getString("cegEmailCim"),
                        rs.getString("cegAdoszam")));
            }
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void ujTermek(Termék termek) {

        try {
            ptmt = con.prepareStatement("INSERT INTO termekek (cegId,cikkszám,megnevezes,ar)VALUES(?,?,?,?)");
            ptmt.setInt(1, termek.getBeszallitoId());
            ptmt.setString(2, termek.getCikkszam());
            ptmt.setString(3, termek.getMegnevezes());
            ptmt.setInt(4, termek.getAr());
            ptmt.executeUpdate();

            ujTermekVektorhozAd(termek);

            JOptionPane.showMessageDialog(null, "Termék hozzáadva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }
        

    }
    public void modositTermek(Termék termek) {
        
        try {                                                           //cikkszám='"+termek.getCikkszam()+"',
            String sql="UPDATE termekek SET cegid="+termek.getBeszallitoId()+", megnevezes='"+termek.getMegnevezes()+"',  ar="+termek.getAr()+" WHERE cikkszám='"+termek.getCikkszam()+"'; ";
            
            
            stmt.executeUpdate(sql);
            termekekVektorFeltolt();
            JOptionPane.showMessageDialog(null, "Termék módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }
        

    }
    public void modositRaktar(Raktár raktar) {
        
        try {                           //raktarNev='"+raktar.getRaktarNev()+"',
            String sql="UPDATE raktarak SET  raktarCim='"+raktar.getRaktarCim()+"', raktarTelefonSzam='"+raktar.getRaktarTelefonSzam()+"', raktaremailcim='"+raktar.getRaktarEmailCim()+"' WHERE raktarnev='"+raktar.getRaktarNev()+"'; ";
            
            
            stmt.executeUpdate(sql);
            raktarakVektorFeltolt();
            JOptionPane.showMessageDialog(null, "Raktár módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }
        

    }
    public void modositVevo(Vevő vevo) {
        
        try {                           
            String sql="UPDATE vevok SET vezetekNev='"+vevo.getVezetekNev()+"',keresztNev='"+vevo.getKeresztNev()+"',  vevocim='"+vevo.getVevoCim()+"', vevoTelefonSzam='"+vevo.getVevoTelefonSzam()+"' WHERE vevoEmailCim='"+vevo.getVevoEmailCim()+"'; ";
            
            
            stmt.executeUpdate(sql);
            vevokVektorFeltolt();
            JOptionPane.showMessageDialog(null, "Vásárló módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }
        

    }
    public void modositBeszallito(Beszállító beszallito) {
        
        try {                           
            String sql="UPDATE beszallitok SET cegNev='"+beszallito.getCegNev()+"',telephely='"+beszallito.getTelephely()+"',  cegtelefonszam='"+beszallito.getCegTelefonSzam()+"', cegemailcim='"+beszallito.getCegEmailCim()+"', cegadoszam='"+beszallito.getCegAdoSzam()+"' WHERE cegid="+beszallito.getCegId()+"; ";
            
            
            stmt.executeUpdate(sql);
            beszallitokVektorFeltolt();
            JOptionPane.showMessageDialog(null, "Beszállító módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }
        
    }
    public void torolTermek(Termék termek) {

        try {
            String sql="DELETE FROM termekek WHERE cikkszám='"+termek.getCikkszam()+"'; ";
            
            
            stmt.executeUpdate(sql);
            termekekVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Termék törölve!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nem lehet törölni a terméket amíg beszállítóhoz vagy raktárhoz van rendelve!!");

        }
        

    }
    public void torolBeszallito(Beszállító beszallito) {
        
        try {
            String sql="DELETE FROM beszallitok WHERE cegid="+beszallito.getCegId()+"; ";
            
            
            stmt.executeUpdate(sql);
            beszallitokVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Beszállító törölve!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Beszállító nem törölhető amíg termékek vannak hozzárendelve!");

        }
        

    }
    public void torolVevo(Vevő vevo) {

        try {
            String sql="DELETE FROM vevok WHERE vevoEmailCim='"+vevo.getVevoEmailCim()+"'; ";
            
            
            stmt.executeUpdate(sql);
            vevokVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Vásárló törölve!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }
        

    }
    public void torolRaktar(Raktár raktar) {

        try {
            String sql="DELETE FROM raktarak WHERE raktarnev='"+raktar.getRaktarNev()+"'; ";
            
            
            stmt.executeUpdate(sql);
            raktarakVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Raktár törölve!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nem lehet törölni a raktárat amíg termékek vannak hozzárendelve!");

        }
        //termekek.add(termek);
        //termekek.add(termek);

    }

    public void ujRaktar(Raktár raktar) {

        try {
            ptmt = con.prepareStatement("INSERT INTO raktarak (raktarNev,raktarCim,raktarTelefonSzam,raktarEmailCim)VALUES(?,?,?,?)");
            ptmt.setString(1, raktar.getRaktarNev());
            ptmt.setString(2, raktar.getRaktarCim());
            ptmt.setString(3, raktar.getRaktarTelefonSzam());
            ptmt.setString(4, raktar.getRaktarEmailCim());
            ptmt.executeUpdate();

            ujRaktarVektorhozAd(raktar);

            JOptionPane.showMessageDialog(null, "Raktár hozzáadva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }
        // raktarak.add(raktar);
        // raktarak.add(raktar);

    }

    public void ujVevo(Vevő vevo) {

        try {

            String sql = "INSERT INTO vevok (vezetekNev,keresztNev,vevocim,vevoTelefonSzam,vevoEmailCim) "
                    + "VALUES ('" + vevo.getVezetekNev() + "','" + vevo.getKeresztNev() + "','" + vevo.getVevoCim() + "','" + vevo.getVevoTelefonSzam() + "','" + vevo.getVevoEmailCim() + "')";

            stmt.executeUpdate(sql);
            ujVevoVektorhozAd(vevo);
            JOptionPane.showMessageDialog(null, "Vásárló hozzáadva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }

    public void ujBeszallito(Beszállító beszallito) {

        try {

            String sql = "INSERT INTO beszallitok (cegNev,telephely,cegTelefonszam,cegEmailCim,cegAdoSzam) "
                    + "VALUES ('" + beszallito.getCegNev() + "','" + beszallito.getTelephely() + "','" + beszallito.getCegTelefonSzam() + "','" + beszallito.getCegEmailCim() + "','" + beszallito.getCegAdoSzam() + "')";

            stmt.executeUpdate(sql);
            ujBeszallitoVektorhozAd(beszallito);
            JOptionPane.showMessageDialog(null, "Beszállító hozzáadva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }

    public void raktarTermekLista(int raktarId) {
        try {

            ResultSet rs = stmt.executeQuery("SELECT termekek.termekId, termekek.cegId,termekek.cikkszám,termekek.megnevezes,termekek.ar FROM termekek INNER JOIN tranzakciok ON tranzakciok.termekId=termekek.termekId AND tranzakciok.raktarId=" + raktarId + " AND tranzakciok.termekDb>0 ;");
            termekekAdottRaktarban.clear();

            while (rs.next()) {
                termekekAdottRaktarban.add(new Termék(rs.getInt("termekId"),
                        rs.getInt("cegId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar")));

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public int aktualisTermekMennyisegRaktarban(Raktár raktar, Termék termek) {
        int raktarId = raktar.getRaktarId();
        int termekId = termek.getTermekId();
        int termekDb = 0;

        try {
            ResultSet rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok WHERE tranzakciok.termekId=" + termekId + " AND tranzakciok.raktarId=" + raktarId + " ;");

            while (rs.next()) {
                termekDb = rs.getInt("termekDb");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return termekDb;
    }
}
