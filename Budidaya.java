import java.util.ArrayList;
import java.util.List;

public class Budidaya {
    private DatabaseManager dbManager; // Objek DatabaseManager

    // Konstruktor
    public Budidaya() {
        dbManager = new DatabaseManager(); // Inisialisasi DatabaseManager saat objek Budidaya dibuat
    }

    // Tambah peternak ke database
    public void tambahPeternak(Peternak peternak) {
        dbManager.insertPeternak(peternak);
    }

    // Ambil list peternak dari database
    public List<Peternak> getDaftarPeternak() {
        return dbManager.selectAllPeternak();
    }

    // Tambah kolam ke database
    public void tambahKolam(Kolam kolam) {
        dbManager.insertKolam(kolam);
    }

    // Ambil list kolam dari database
    public List<Kolam> getDaftarKolam() {
        return dbManager.selectAllKolam();
    }

    // Tambah ikan ke database
    public void tambahIkan(Ikan ikan) {
        dbManager.insertIkan(ikan);
    }

    // Ambil list ikan dari database
    public List<Ikan> getDaftarIkan() {
        return dbManager.selectAllIkan();
    }

    // Cari ikan berdasarkan ID dari database
    public Ikan cariIkanById(String idIkan) {
        return dbManager.selectIkanById(idIkan);
    }
}