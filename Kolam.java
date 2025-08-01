public class Kolam {
    private String idKolam;
    private String namaKolam;
    private String jenisKolam; 
    private String lokasiKolam;
    private String tanggalTebar; 
    private String tanggalPerkiraanPanen; 
    private double suhuAir;
    private double phAir;

    public Kolam(String idKolam, String namaKolam, String jenisKolam,
                 String lokasiKolam, String tanggalTebar, String tanggalPerkiraanPanen,
                 double suhuAir, double phAir) {
        this.idKolam = idKolam;
        this.namaKolam = namaKolam;
        this.jenisKolam = jenisKolam;
        this.lokasiKolam = lokasiKolam;
        this.tanggalTebar = tanggalTebar;
        this.tanggalPerkiraanPanen = tanggalPerkiraanPanen;
        this.suhuAir = suhuAir;
        this.phAir = phAir;
    }

    public String getIdKolam() {
        return idKolam;
    }

    public String getNamaKolam() {
        return namaKolam;
    }

    public String getJenisKolam() {
        return jenisKolam;
    }

    public String getLokasiKolam() {
        return lokasiKolam;
    }

    public String getTanggalTebar() {
        return tanggalTebar;
    }

    public String getTanggalPerkiraanPanen() {
        return tanggalPerkiraanPanen;
    }

    public double getSuhuAir() {
        return suhuAir;
    }

    public double getPhAir() {
        return phAir;
    }

    @Override
    public String toString() {
        return "ID Kolam: " + idKolam + ", Nama: " + namaKolam + ", Jenis: " + jenisKolam +
               ", Lokasi: " + lokasiKolam + ", Tebar: " + tanggalTebar +
               ", Perkiraan Panen: " + tanggalPerkiraanPanen + ", Suhu: " + suhuAir + "°C, pH: " + phAir;
    }
}