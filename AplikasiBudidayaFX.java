import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AplikasiBudidayaFX extends Application {

    private Budidaya budidaya = new Budidaya();
    private ObservableList<Peternak> observablePeternak = FXCollections.observableArrayList();
    private ObservableList<Kolam> observableKolam = FXCollections.observableArrayList();
    private ObservableList<Ikan> observableIkan = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplikasi Budi Daya Ikan JavaFX");

        observablePeternak.addAll(budidaya.getDaftarPeternak());
        observableKolam.addAll(budidaya.getDaftarKolam());
        observableIkan.addAll(budidaya.getDaftarIkan());

        TabPane tabPane = new TabPane();

        Tab tabPeternak = new Tab("Peternak", buatPanelPeternak());
        Tab tabKolam = new Tab("Kolam", buatPanelKolam());
        Tab tabIkan = new Tab("Ikan", buatPanelIkan());

        tabPane.getTabs().addAll(tabPeternak, tabKolam, tabIkan);

        Scene scene = new Scene(tabPane, 750, 600); // Ukuran diperbesar
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Panel tambah & lihat peternak (tidak ada perubahan)
    private Pane buatPanelPeternak() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField tfId = new TextField();
        tfId.setPromptText("ID Peternak");
        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama Peternak");
        TextField tfAlamat = new TextField();
        tfAlamat.setPromptText("Alamat");

        Button btnTambah = new Button("Tambah Peternak");

        ListView<Peternak> listViewPeternak = new ListView<>(observablePeternak);

        btnTambah.setOnAction(e -> {
            String id = tfId.getText().trim();
            String nama = tfNama.getText().trim();
            String alamat = tfAlamat.getText().trim();

            if (id.isEmpty() || nama.isEmpty() || alamat.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Form tidak boleh kosong");
                return;
            }

            boolean exists = observablePeternak.stream().anyMatch(p -> p.getIdPeternak().equals(id));
            if (exists) {
                showAlert(Alert.AlertType.ERROR, "ID Peternak sudah ada");
                return;
            }

            Peternak peternak = new Peternak(id, nama, alamat);
            budidaya.tambahPeternak(peternak);
            observablePeternak.add(peternak);

            tfId.clear();
            tfNama.clear();
            tfAlamat.clear();
        });

        vbox.getChildren().addAll(
            new Label("Tambah Peternak"),
            tfId, tfNama, tfAlamat,
            btnTambah,
            new Label("Daftar Peternak"),
            listViewPeternak
        );

        return vbox;
    }

    // Panel tambah & lihat kolam (tidak ada perubahan signifikan, hanya memastikan ComboBox Peternak kosong jika tidak relevan)
    private Pane buatPanelKolam() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField tfIdKolam = new TextField();
        tfIdKolam.setPromptText("ID Kolam");
        TextField tfNamaKolam = new TextField();
        tfNamaKolam.setPromptText("Nama Kolam");

        ComboBox<String> cbJenisKolam = new ComboBox<>(FXCollections.observableArrayList("Terpal", "Beton", "Tanah"));
        cbJenisKolam.setPromptText("Jenis Kolam");

        TextField tfLokasiKolam = new TextField();
        tfLokasiKolam.setPromptText("Lokasi Kolam");

        TextField tfTanggalTebar = new TextField();
        tfTanggalTebar.setPromptText("Tanggal Tebar (DD-MM-YYYY)");
        TextField tfTanggalPerkiraanPanen = new TextField();
        tfTanggalPerkiraanPanen.setPromptText("Tanggal Perkiraan Panen (DD-MM-YYYY)");

        TextField tfSuhuAir = new TextField();
        tfSuhuAir.setPromptText("Suhu Air (°C)");
        TextField tfPhAir = new TextField();
        tfPhAir.setPromptText("pH Air");

        Button btnTambahKolam = new Button("Tambah Kolam");

        ListView<Kolam> listViewKolam = new ListView<>(observableKolam);

        btnTambahKolam.setOnAction(e -> {
            String idKolam = tfIdKolam.getText().trim();
            String namaKolam = tfNamaKolam.getText().trim();
            String jenisKolam = cbJenisKolam.getValue();
            String lokasiKolam = tfLokasiKolam.getText().trim();
            String tanggalTebar = tfTanggalTebar.getText().trim();
            String tanggalPerkiraanPanen = tfTanggalPerkiraanPanen.getText().trim();
            String suhuAirStr = tfSuhuAir.getText().trim();
            String phAirStr = tfPhAir.getText().trim();

            if (idKolam.isEmpty() || namaKolam.isEmpty() || jenisKolam == null || lokasiKolam.isEmpty() ||
                tanggalTebar.isEmpty() || tanggalPerkiraanPanen.isEmpty() || suhuAirStr.isEmpty() || phAirStr.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Semua form harus diisi");
                return;
            }

            double suhuAir;
            double phAir;
            try {
                suhuAir = Double.parseDouble(suhuAirStr);
                phAir = Double.parseDouble(phAirStr);
                if (suhuAir < 0 || phAir < 0 || phAir > 14) {
                    showAlert(Alert.AlertType.ERROR, "Suhu atau pH tidak valid");
                    return;
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Suhu atau pH harus angka");
                return;
            }

            boolean exists = observableKolam.stream().anyMatch(k -> k.getIdKolam().equals(idKolam));
            if (exists) {
                showAlert(Alert.AlertType.ERROR, "ID Kolam sudah ada");
                return;
            }

            Kolam kolam = new Kolam(idKolam, namaKolam, jenisKolam, lokasiKolam,
                                    tanggalTebar, tanggalPerkiraanPanen, suhuAir, phAir);
            budidaya.tambahKolam(kolam);
            observableKolam.add(kolam);

            tfIdKolam.clear();
            tfNamaKolam.clear();
            cbJenisKolam.setValue(null);
            tfLokasiKolam.clear();
            tfTanggalTebar.clear();
            tfTanggalPerkiraanPanen.clear();
            tfSuhuAir.clear();
            tfPhAir.clear();
        });

        vbox.getChildren().addAll(
            new Label("Tambah Kolam"),
            tfIdKolam, tfNamaKolam, cbJenisKolam, tfLokasiKolam,
            tfTanggalTebar, tfTanggalPerkiraanPanen, tfSuhuAir, tfPhAir,
            btnTambahKolam,
            new Label("Daftar Kolam"),
            listViewKolam
        );

        return vbox;
    }

    // Panel tambah & lihat ikan (Perubahan besar di sini)
    private Pane buatPanelIkan() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField tfIdIkan = new TextField();
        tfIdIkan.setPromptText("ID Ikan");
        TextField tfNamaIkan = new TextField();
        tfNamaIkan.setPromptText("Nama Ikan");
        TextField tfJumlahIkan = new TextField();
        tfJumlahIkan.setPromptText("Jumlah Ikan (ekor)");
        TextField tfJenisPakan = new TextField();
        tfJenisPakan.setPromptText("Jenis Pakan");
        TextField tfTanggalPakan = new TextField();
        tfTanggalPakan.setPromptText("Tanggal Pakan (DD-MM-YYYY)");
        TextField tfJumlahPakan = new TextField();
        tfJumlahPakan.setPromptText("Jumlah Pakan (kg)");

        ComboBox<String> cbWaktuPakan = new ComboBox<>(FXCollections.observableArrayList("Pagi", "Siang", "Sore"));
        cbWaktuPakan.setPromptText("Waktu Pemberian Pakan");

        TextField tfTanggalPanen = new TextField();
        tfTanggalPanen.setPromptText("Tanggal Panen (DD-MM-YYYY)");
        TextField tfJumlahPanen = new TextField();
        tfJumlahPanen.setPromptText("Jumlah Panen (ekor)");
        TextField tfBeratTotalPanen = new TextField();
        tfBeratTotalPanen.setPromptText("Berat Total Panen (kg)");

        // Menambahkan ComboBox untuk memilih Kolam dan Peternak
        ComboBox<Kolam> cbKolam = new ComboBox<>();
        cbKolam.setItems(observableKolam); // Menggunakan observableList Kolam
        cbKolam.setPromptText("Pilih Kolam");
        cbKolam.setConverter(new javafx.util.StringConverter<Kolam>() {
            @Override
            public String toString(Kolam kolam) {
                return kolam != null ? kolam.getNamaKolam() + " (ID: " + kolam.getIdKolam() + ")" : "";
            }
            @Override
            public Kolam fromString(String string) {
                // Not used for selection, only for display
                return null;
            }
        });

        ComboBox<Peternak> cbPeternak = new ComboBox<>();
        cbPeternak.setItems(observablePeternak); // Menggunakan observableList Peternak
        cbPeternak.setPromptText("Pilih Peternak");
        cbPeternak.setConverter(new javafx.util.StringConverter<Peternak>() {
            @Override
            public String toString(Peternak peternak) {
                return peternak != null ? peternak.getNamaPeternak() + " (ID: " + peternak.getIdPeternak() + ")" : "";
            }
            @Override
            public Peternak fromString(String string) {
                // Not used for selection, only for display
                return null;
            }
        });

        Button btnTambahIkan = new Button("Tambah Ikan");

        ListView<Ikan> listViewIkan = new ListView<>(observableIkan);

        btnTambahIkan.setOnAction(e -> {
            String idIkan = tfIdIkan.getText().trim();
            String namaIkan = tfNamaIkan.getText().trim();
            String jumlahIkanStr = tfJumlahIkan.getText().trim();
            String jenisPakan = tfJenisPakan.getText().trim();
            String tanggalPakan = tfTanggalPakan.getText().trim();
            String jumlahPakanStr = tfJumlahPakan.getText().trim();
            String waktuPakan = cbWaktuPakan.getValue();
            String tanggalPanen = tfTanggalPanen.getText().trim();
            String jumlahPanenStr = tfJumlahPanen.getText().trim();
            String beratTotalPanenStr = tfBeratTotalPanen.getText().trim();
            Kolam selectedKolam = cbKolam.getValue(); // Ambil objek Kolam yang dipilih
            Peternak selectedPeternak = cbPeternak.getValue(); // Ambil objek Peternak yang dipilih

            if (idIkan.isEmpty() || namaIkan.isEmpty() || jumlahIkanStr.isEmpty() || jenisPakan.isEmpty() ||
                tanggalPakan.isEmpty() || jumlahPakanStr.isEmpty() || waktuPakan == null ||
                tanggalPanen.isEmpty() || jumlahPanenStr.isEmpty() || beratTotalPanenStr.isEmpty() ||
                selectedKolam == null || selectedPeternak == null) { // Validasi tambahan
                showAlert(Alert.AlertType.ERROR, "Semua form harus diisi, termasuk Kolam dan Peternak");
                return;
            }

            int jumlahIkan;
            double jumlahPakan;
            int jumlahPanen;
            double beratTotalPanen;
            try {
                jumlahIkan = Integer.parseInt(jumlahIkanStr);
                jumlahPakan = Double.parseDouble(jumlahPakanStr);
                jumlahPanen = Integer.parseInt(jumlahPanenStr);
                beratTotalPanen = Double.parseDouble(beratTotalPanenStr);

                if (jumlahIkan <= 0 || jumlahPakan <= 0 || jumlahPanen < 0 || beratTotalPanen < 0) {
                    showAlert(Alert.AlertType.ERROR, "Jumlah harus positif (atau nol untuk panen jika belum)");
                    return;
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Jumlah harus angka yang valid");
                return;
            }

            boolean exists = observableIkan.stream().anyMatch(i -> i.getIdIkan().equals(idIkan));
            if (exists) {
                showAlert(Alert.AlertType.ERROR, "ID Ikan sudah ada");
                return;
            }

            // Membuat objek Ikan dengan ID Kolam dan ID Peternak
            Ikan ikan = new Ikan(idIkan, namaIkan, jumlahIkan, jenisPakan, tanggalPakan, jumlahPakan,
                                 waktuPakan, tanggalPanen, jumlahPanen, beratTotalPanen,
                                 selectedKolam.getIdKolam(), selectedPeternak.getIdPeternak());
            budidaya.tambahIkan(ikan);
            observableIkan.add(ikan);

            tfIdIkan.clear();
            tfNamaIkan.clear();
            tfJumlahIkan.clear();
            tfJenisPakan.clear();
            tfTanggalPakan.clear();
            tfJumlahPakan.clear();
            cbWaktuPakan.setValue(null);
            tfTanggalPanen.clear();
            tfJumlahPanen.clear();
            tfBeratTotalPanen.clear();
            cbKolam.setValue(null); // Bersihkan pilihan ComboBox
            cbPeternak.setValue(null); // Bersihkan pilihan ComboBox
        });

        vbox.getChildren().addAll(
            new Label("Tambah Data Ikan"),
            tfIdIkan, tfNamaIkan, tfJumlahIkan,
            tfJenisPakan, tfTanggalPakan, tfJumlahPakan, cbWaktuPakan,
            tfTanggalPanen, tfJumlahPanen, tfBeratTotalPanen,
            new Label("Hubungkan dengan Kolam:"), cbKolam,
            new Label("Hubungkan dengan Peternak:"), cbPeternak,
            btnTambahIkan,
            new Label("Daftar Ikan"),
            listViewIkan
        );

        return vbox;
    }

    private void showAlert(Alert.AlertType tipe, String pesan) {
        Alert alert = new Alert(tipe);
        alert.setContentText(pesan);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}