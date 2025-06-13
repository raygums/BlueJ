import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:budidaya.db"; // Nama file database SQLite

    public DatabaseManager() {
        createNewDatabase();
        createTables();
    }

    // Metode untuk membuat file database baru jika belum ada
    private void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                System.out.println("Koneksi ke database SQLite berhasil!");
                System.out.println("Database 'budidaya.db' berhasil dibuat/ditemukan.");
            }
        } catch (SQLException e) {
            System.err.println("Error saat membuat database: " + e.getMessage());
        }
    }

    // Metode untuk membuat tabel
    private void createTables() {
        String sqlPeternak = "CREATE TABLE IF NOT EXISTS peternak (" +
                             "id_peternak TEXT PRIMARY KEY," +
                             "nama_peternak TEXT NOT NULL," +
                             "alamat_peternak TEXT" +
                             ");";

        String sqlKolam = "CREATE TABLE IF NOT EXISTS kolam (" +
                          "id_kolam TEXT PRIMARY KEY," +
                          "nama_kolam TEXT NOT NULL," +
                          "jenis_kolam TEXT," +
                          "lokasi_kolam TEXT," +
                          "tanggal_tebar TEXT," + // Akan diubah ke DATE jika pakai LocalDate
                          "tanggal_perkiraan_panen TEXT," + // Akan diubah ke DATE jika pakai LocalDate
                          "suhu_air REAL," +
                          "ph_air REAL" +
                          ");";

        String sqlIkan = "CREATE TABLE IF NOT EXISTS ikan (" +
                         "id_ikan TEXT PRIMARY KEY," +
                         "nama_ikan TEXT NOT NULL," +
                         "jumlah_ikan INTEGER," +
                         "jenis_pakan TEXT," +
                         "tanggal_pakan TEXT," + // Akan diubah ke DATE
                         "jumlah_pakan REAL," +
                         "waktu_pemberian_pakan TEXT," +
                         "tanggal_panen TEXT," + // Akan diubah ke DATE
                         "jumlah_panen INTEGER," +
                         "berat_total_panen REAL," +
                         "id_kolam TEXT," +
                         "id_peternak TEXT," +
                         "FOREIGN KEY (id_kolam) REFERENCES kolam(id_kolam)," +
                         "FOREIGN KEY (id_peternak) REFERENCES peternak(id_peternak)" +
                         ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlPeternak);
            stmt.execute(sqlKolam);
            stmt.execute(sqlIkan);
            System.out.println("Tabel berhasil dibuat atau sudah ada.");
        } catch (SQLException e) {
            System.err.println("Error saat membuat tabel: " + e.getMessage());
        }
    }

    // Metode untuk mendapatkan koneksi ke database
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Gagal koneksi ke database: " + e.getMessage());
        }
        return conn;
    }

    // ====================================================================
    // CRUD Peternak
    // ====================================================================
    public void insertPeternak(Peternak peternak) {
        String sql = "INSERT INTO peternak(id_peternak, nama_peternak, alamat_peternak) VALUES(?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, peternak.getIdPeternak());
            pstmt.setString(2, peternak.getNamaPeternak());
            pstmt.setString(3, peternak.getAlamatPeternak());
            pstmt.executeUpdate();
            System.out.println("Peternak " + peternak.getNamaPeternak() + " berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("Error insert peternak: " + e.getMessage());
        }
    }

    public List<Peternak> selectAllPeternak() {
        List<Peternak> peternakList = new ArrayList<>();
        String sql = "SELECT id_peternak, nama_peternak, alamat_peternak FROM peternak";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                peternakList.add(new Peternak(
                        rs.getString("id_peternak"),
                        rs.getString("nama_peternak"),
                        rs.getString("alamat_peternak")));
            }
        } catch (SQLException e) {
            System.err.println("Error select peternak: " + e.getMessage());
        }
        return peternakList;
    }

    // ====================================================================
    // CRUD Kolam
    // ====================================================================
    public void insertKolam(Kolam kolam) {
        String sql = "INSERT INTO kolam(id_kolam, nama_kolam, jenis_kolam, lokasi_kolam, tanggal_tebar, tanggal_perkiraan_panen, suhu_air, ph_air) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kolam.getIdKolam());
            pstmt.setString(2, kolam.getNamaKolam());
            pstmt.setString(3, kolam.getJenisKolam());
            pstmt.setString(4, kolam.getLokasiKolam());
            pstmt.setString(5, kolam.getTanggalTebar());
            pstmt.setString(6, kolam.getTanggalPerkiraanPanen());
            pstmt.setDouble(7, kolam.getSuhuAir());
            pstmt.setDouble(8, kolam.getPhAir());
            pstmt.executeUpdate();
            System.out.println("Kolam " + kolam.getNamaKolam() + " berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("Error insert kolam: " + e.getMessage());
        }
    }

    public List<Kolam> selectAllKolam() {
        List<Kolam> kolamList = new ArrayList<>();
        String sql = "SELECT id_kolam, nama_kolam, jenis_kolam, lokasi_kolam, tanggal_tebar, tanggal_perkiraan_panen, suhu_air, ph_air FROM kolam";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                kolamList.add(new Kolam(
                        rs.getString("id_kolam"),
                        rs.getString("nama_kolam"),
                        rs.getString("jenis_kolam"),
                        rs.getString("lokasi_kolam"),
                        rs.getString("tanggal_tebar"),
                        rs.getString("tanggal_perkiraan_panen"),
                        rs.getDouble("suhu_air"),
                        rs.getDouble("ph_air")));
            }
        } catch (SQLException e) {
            System.err.println("Error select kolam: " + e.getMessage());
        }
        return kolamList;
    }

    // ====================================================================
    // CRUD Ikan
    // ====================================================================
    public void insertIkan(Ikan ikan) {
        String sql = "INSERT INTO ikan(id_ikan, nama_ikan, jumlah_ikan, jenis_pakan, tanggal_pakan, jumlah_pakan, waktu_pemberian_pakan, tanggal_panen, jumlah_panen, berat_total_panen, id_kolam, id_peternak) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ikan.getIdIkan());
            pstmt.setString(2, ikan.getNamaIkan());
            pstmt.setInt(3, ikan.getJumlahIkan());
            pstmt.setString(4, ikan.getJenisPakan());
            pstmt.setString(5, ikan.getTanggalPakan());
            pstmt.setDouble(6, ikan.getJumlahPakan());
            pstmt.setString(7, ikan.getWaktuPemberianPakan());
            pstmt.setString(8, ikan.getTanggalPanen());
            pstmt.setInt(9, ikan.getJumlahPanen());
            pstmt.setDouble(10, ikan.getBeratTotalPanen());
            pstmt.setString(11, ikan.getIdKolam());
            pstmt.setString(12, ikan.getIdPeternak());
            pstmt.executeUpdate();
            System.out.println("Ikan " + ikan.getNamaIkan() + " berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("Error insert ikan: " + e.getMessage());
        }
    }

    public List<Ikan> selectAllIkan() {
        List<Ikan> ikanList = new ArrayList<>();
        String sql = "SELECT id_ikan, nama_ikan, jumlah_ikan, jenis_pakan, tanggal_pakan, jumlah_pakan, waktu_pemberian_pakan, tanggal_panen, jumlah_panen, berat_total_panen, id_kolam, id_peternak FROM ikan";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ikanList.add(new Ikan(
                        rs.getString("id_ikan"),
                        rs.getString("nama_ikan"),
                        rs.getInt("jumlah_ikan"),
                        rs.getString("jenis_pakan"),
                        rs.getString("tanggal_pakan"),
                        rs.getDouble("jumlah_pakan"),
                        rs.getString("waktu_pemberian_pakan"),
                        rs.getString("tanggal_panen"),
                        rs.getInt("jumlah_panen"),
                        rs.getDouble("berat_total_panen"),
                        rs.getString("id_kolam"),
                        rs.getString("id_peternak")));
            }
        } catch (SQLException e) {
            System.err.println("Error select ikan: " + e.getMessage());
        }
        return ikanList;
    }

    public Ikan selectIkanById(String idIkan) {
        String sql = "SELECT id_ikan, nama_ikan, jumlah_ikan, jenis_pakan, tanggal_pakan, jumlah_pakan, waktu_pemberian_pakan, tanggal_panen, jumlah_panen, berat_total_panen, id_kolam, id_peternak FROM ikan WHERE id_ikan = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idIkan);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Ikan(
                        rs.getString("id_ikan"),
                        rs.getString("nama_ikan"),
                        rs.getInt("jumlah_ikan"),
                        rs.getString("jenis_pakan"),
                        rs.getString("tanggal_pakan"),
                        rs.getDouble("jumlah_pakan"),
                        rs.getString("waktu_pemberian_pakan"),
                        rs.getString("tanggal_panen"),
                        rs.getInt("jumlah_panen"),
                        rs.getDouble("berat_total_panen"),
                        rs.getString("id_kolam"),
                        rs.getString("id_peternak"));
            }
        } catch (SQLException e) {
            System.err.println("Error select ikan by ID: " + e.getMessage());
        }
        return null;
    }
}