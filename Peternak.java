// Peternak.java
public class Peternak {
    private String idPeternak;
    private String namaPeternak;
    private String alamatPeternak;

    // Konstruktor
    public Peternak(String idPeternak, String namaPeternak, String alamatPeternak) {
        this.idPeternak = idPeternak;
        this.namaPeternak = namaPeternak;
        this.alamatPeternak = alamatPeternak;
    }

    // Getter
    public String getIdPeternak() {
        return idPeternak;
    }

    public String getNamaPeternak() {
        return namaPeternak;
    }

    public String getAlamatPeternak() {
        return alamatPeternak;
    }

    @Override
    public String toString() {
        return "ID: " + idPeternak + ", Nama: " + namaPeternak + ", Alamat: " + alamatPeternak;
    }
}