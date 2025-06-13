// Ikan.java
public class Ikan {
    private String idIkan;
    private String namaIkan;
    private int jumlahIkan;
    private String jenisPakan;
    private String tanggalPakan;
    private double jumlahPakan;
    private String waktuPemberianPakan; // Pagi, Siang, Sore
    private String tanggalPanen;
    private int jumlahPanen;
    private double beratTotalPanen;
    private String idKolam; // Menambahkan atribut idKolam
    private String idPeternak; // Menambahkan atribut idPeternak

    // Konstruktor yang diperbarui
    public Ikan(String idIkan, String namaIkan, int jumlahIkan, String jenisPakan,
                String tanggalPakan, double jumlahPakan, String waktuPemberianPakan,
                String tanggalPanen, int jumlahPanen, double beratTotalPanen,
                String idKolam, String idPeternak) { // Menambahkan parameter idKolam dan idPeternak
        this.idIkan = idIkan;
        this.namaIkan = namaIkan;
        this.jumlahIkan = jumlahIkan;
        this.jenisPakan = jenisPakan;
        this.tanggalPakan = tanggalPakan;
        this.jumlahPakan = jumlahPakan;
        this.waktuPemberianPakan = waktuPemberianPakan;
        this.tanggalPanen = tanggalPanen;
        this.jumlahPanen = jumlahPanen;
        this.beratTotalPanen = beratTotalPanen;
        this.idKolam = idKolam; // Inisialisasi idKolam
        this.idPeternak = idPeternak; // Inisialisasi idPeternak
    }

    // Getter untuk idKolam
    public String getIdKolam() {
        return idKolam;
    }

    // Getter untuk idPeternak
    public String getIdPeternak() {
        return idPeternak;
    }

    // Getter lainnya tetap sama
    public String getIdIkan() {
        return idIkan;
    }

    public String getNamaIkan() {
        return namaIkan;
    }

    public int getJumlahIkan() {
        return jumlahIkan;
    }

    public String getJenisPakan() {
        return jenisPakan;
    }

    public String getTanggalPakan() {
        return tanggalPakan;
    }

    public double getJumlahPakan() {
        return jumlahPakan;
    }

    public String getWaktuPemberianPakan() {
        return waktuPemberianPakan;
    }

    public String getTanggalPanen() {
        return tanggalPanen;
    }

    public int getJumlahPanen() {
        return jumlahPanen;
    }

    public double getBeratTotalPanen() {
        return beratTotalPanen;
    }

    @Override
    public String toString() {
        return "ID Ikan: " + idIkan + ", Nama: " + namaIkan + ", Jumlah: " + jumlahIkan +
               "\nPakan: " + jenisPakan + " (" + jumlahPakan + " kg) pada " + tanggalPakan + " (" + waktuPemberianPakan + ")" +
               "\nPanen: " + jumlahPanen + " ekor, " + beratTotalPanen + " kg pada " + tanggalPanen +
               "\nID Kolam: " + idKolam + ", ID Peternak: " + idPeternak;
    }
}