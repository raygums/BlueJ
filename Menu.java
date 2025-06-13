// ... (import-import lainnya tetap sama)
// import-import yang ada di Menu.java Anda sebelumnya
import javafx.geometry.Insets;
import javafx.geometry.Pos; // Import untuk Pos
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane; // Import GridPane
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane; // Import ScrollPane
import java.util.List;

import java.util.Optional; // Pastikan ini ada

public class Menu {
    private Budidaya budidaya;
    private Stage stage;

    public Menu(Budidaya budidaya, Stage stage) {
        this.budidaya = budidaya;
        this.stage = stage;
    }

    // =======================================================================
    // MENU UTAMA (3 Pilihan dengan Warna Berbeda)
    // =======================================================================
    public void tampilkanMenuUtama() {
        VBox root = new VBox(30);
        root.setPadding(new Insets(60));
        root.setAlignment(Pos.CENTER);

        Label judul = new Label("Sistem Manajemen Ternak Ikan"); // Judul utama aplikasi
        judul.getStyleClass().add("label-main-menu-title");

        Button btnManajemenPeternak = new Button("Manajemen Peternak");
        Button btnManajemenKolam = new Button("Manajemen Kolam");
        Button btnManajemenIkan = new Button("Manajemen Ikan");

        btnManajemenPeternak.getStyleClass().addAll("button-main-menu", "button-peternak");
        btnManajemenKolam.getStyleClass().addAll("button-main-menu", "button-kolam");
        btnManajemenIkan.getStyleClass().addAll("button-main-menu", "button-ikan");

        btnManajemenPeternak.setMaxWidth(Double.MAX_VALUE);
        btnManajemenKolam.setMaxWidth(Double.MAX_VALUE);
        btnManajemenIkan.setMaxWidth(Double.MAX_VALUE);

        root.getChildren().addAll(judul,
                                  btnManajemenPeternak,
                                  btnManajemenKolam,
                                  btnManajemenIkan);

        Scene scene = new Scene(root, 700, 550);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Sistem Manajemen Ternak Ikan");
        stage.show();

        btnManajemenPeternak.setOnAction(e -> tampilkanSubMenuPeternak());
        btnManajemenKolam.setOnAction(e -> tampilkanSubMenuKolam());
        btnManajemenIkan.setOnAction(e -> tampilkanSubMenuIkan());
    }

    // =======================================================================
    // SUB-MENU PETERNAK (Warna Hijau)
    // =======================================================================
    private void tampilkanSubMenuPeternak() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.CENTER);

        Label judul = new Label("Manajemen Peternak");
        judul.getStyleClass().addAll("label-sub-menu-title", "peternak");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        Button btnTambahPeternak = new Button("Tambah Peternak");
        Button btnLihatPeternak = new Button("Lihat Daftar Peternak");
        Button btnKembali = new Button("Kembali ke Menu Utama");

        btnTambahPeternak.setMaxWidth(Double.MAX_VALUE);
        btnLihatPeternak.setMaxWidth(Double.MAX_VALUE);
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        root.getChildren().addAll(judul, btnTambahPeternak, btnLihatPeternak, new Separator(), btnKembali);

        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Manajemen Peternak");
        stage.show();

        btnTambahPeternak.setOnAction(e -> tampilkanFormTambahPeternak());
        btnLihatPeternak.setOnAction(e -> tampilkanDaftarPeternak());
        btnKembali.setOnAction(e -> tampilkanMenuUtama());
    }

    // =======================================================================
    // SUB-MENU KOLAM (Warna Kuning)
    // =======================================================================
    private void tampilkanSubMenuKolam() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.CENTER);

        Label judul = new Label("Manajemen Kolam");
        judul.getStyleClass().addAll("label-sub-menu-title", "kolam");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        Button btnTambahKolam = new Button("Tambah Kolam");
        Button btnLihatKolam = new Button("Lihat Daftar Kolam");
        Button btnKembali = new Button("Kembali ke Menu Utama");

        btnTambahKolam.setMaxWidth(Double.MAX_VALUE);
        btnLihatKolam.setMaxWidth(Double.MAX_VALUE);
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        root.getChildren().addAll(judul, btnTambahKolam, btnLihatKolam, new Separator(), btnKembali);

        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Manajemen Kolam");
        stage.show();

        btnTambahKolam.setOnAction(e -> tampilkanFormTambahKolam());
        btnLihatKolam.setOnAction(e -> tampilkanDaftarKolam());
        btnKembali.setOnAction(e -> tampilkanMenuUtama());
    }

    // =======================================================================
    // SUB-MENU IKAN (Warna Merah)
    // =======================================================================
    private void tampilkanSubMenuIkan() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.CENTER);

        Label judul = new Label("Manajemen Ikan");
        judul.getStyleClass().addAll("label-sub-menu-title", "ikan");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        Button btnTambahIkan = new Button("Tambah Data Ikan");
        Button btnLihatIkan = new Button("Lihat Daftar Ikan");
        Button btnCariIkan = new Button("Cari Data Lengkap Ikan");
        Button btnKembali = new Button("Kembali ke Menu Utama");

        btnTambahIkan.setMaxWidth(Double.MAX_VALUE);
        btnLihatIkan.setMaxWidth(Double.MAX_VALUE);
        btnCariIkan.setMaxWidth(Double.MAX_VALUE);
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        root.getChildren().addAll(judul, btnTambahIkan, btnLihatIkan, btnCariIkan, new Separator(), btnKembali);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Manajemen Ikan");
        stage.show();

        btnTambahIkan.setOnAction(e -> tampilkanFormTambahIkan());
        btnLihatIkan.setOnAction(e -> tampilkanDaftarIkan());
        btnCariIkan.setOnAction(e -> tampilkanFormCariIkan());
        btnKembali.setOnAction(e -> tampilkanMenuUtama());
    }


    // =======================================================================
    // METODE FORM DAN DAFTAR
    // =======================================================================

    private void tampilkanFormTambahPeternak() {
        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(30));

        Label judul = new Label("Tambah Peternak Baru");
        judul.getStyleClass().addAll("label-sub-menu-title", "peternak");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(15);
        formGrid.getStyleClass().addAll("grid-pane", "grid-pane-peternak");
        formGrid.setPadding(new Insets(20));

        TextField tfId = new TextField();
        tfId.setPromptText("ID Peternak (misal: P001)");
        tfId.getStyleClass().add("text-field-peternak");
        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama Peternak");
        tfNama.getStyleClass().add("text-field-peternak");
        TextField tfAlamat = new TextField();
        tfAlamat.setPromptText("Alamat Peternak");
        tfAlamat.getStyleClass().add("text-field-peternak");

        int row = 0;
        formGrid.add(new Label("ID Peternak:"), 0, row); formGrid.add(tfId, 1, row++);
        formGrid.add(new Label("Nama Peternak:"), 0, row); formGrid.add(tfNama, 1, row++);
        formGrid.add(new Label("Alamat:"), 0, row); formGrid.add(tfAlamat, 1, row++);

        Button btnSimpan = new Button("Simpan");
        Button btnKembali = new Button("Kembali");
        btnSimpan.setMaxWidth(Double.MAX_VALUE);
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        mainVBox.getChildren().addAll(judul, formGrid, btnSimpan, btnKembali);

        Scene scene = new Scene(mainVBox, 500, 450);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Tambah Peternak");
        stage.show();

        btnSimpan.setOnAction(e -> {
            String id = tfId.getText().trim();
            String nama = tfNama.getText().trim();
            String alamat = tfAlamat.getText().trim();

            if (id.isEmpty() || nama.isEmpty() || alamat.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error Input", "Semua field harus diisi!");
                return;
            }

            // PERUBAHAN UNTUK DATABASE: Cek keberadaan di DB
            boolean exists = budidaya.getDaftarPeternak().stream()
                    .anyMatch(p -> p.getIdPeternak().equals(id));
            if (exists) {
                showAlert(Alert.AlertType.ERROR, "ID Duplikat", "ID Peternak sudah terdaftar!");
                return;
            }

            Peternak peternak = new Peternak(id, nama, alamat);
            budidaya.tambahPeternak(peternak); // PERUBAHAN UNTUK DATABASE: Simpan ke DB
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Peternak berhasil ditambahkan!");
            this.tampilkanSubMenuPeternak();
        });

        btnKembali.setOnAction(e -> this.tampilkanSubMenuPeternak());
    }

    private void tampilkanDaftarPeternak() {
        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(30));

        Label judul = new Label("Daftar Peternak");
        judul.getStyleClass().addAll("label-sub-menu-title", "peternak");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        TextArea taDaftar = new TextArea();
        taDaftar.setEditable(false);
        taDaftar.setPrefHeight(400);
        taDaftar.setWrapText(true);

        StringBuilder sb = new StringBuilder();
        // PERUBAHAN UNTUK DATABASE: Memuat data dari DB setiap kali dibuka
        List<Peternak> daftarPeternak = budidaya.getDaftarPeternak();
        if (daftarPeternak.isEmpty()) {
            sb.append("Belum ada peternak terdaftar.");
        } else {
            for (Peternak p : daftarPeternak) {
                sb.append(p.toString()).append("\n--------------------\n");
            }
        }
        taDaftar.setText(sb.toString());

        Button btnKembali = new Button("Kembali");
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        mainVBox.getChildren().addAll(judul, taDaftar, btnKembali);

        Scene scene = new Scene(mainVBox, 550, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Daftar Peternak");
        stage.show();

        btnKembali.setOnAction(e -> this.tampilkanSubMenuPeternak());
    }

    private void tampilkanFormTambahKolam() {
        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(30));

        Label judul = new Label("Tambah Kolam Baru");
        judul.getStyleClass().addAll("label-sub-menu-title", "kolam");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(15);
        formGrid.getStyleClass().addAll("grid-pane", "grid-pane-kolam");
        formGrid.setPadding(new Insets(20));

        TextField tfIdKolam = new TextField();
        tfIdKolam.setPromptText("ID Kolam (misal: K001)");
        tfIdKolam.getStyleClass().add("text-field-kolam");
        TextField tfNamaKolam = new TextField();
        tfNamaKolam.setPromptText("Nama Kolam");
        tfNamaKolam.getStyleClass().add("text-field-kolam");

        ComboBox<String> cbJenisKolam = new ComboBox<>();
        cbJenisKolam.getItems().addAll("Terpal", "Beton", "Tanah");
        cbJenisKolam.setPromptText("Pilih Jenis Kolam");
        cbJenisKolam.setMaxWidth(Double.MAX_VALUE);
        cbJenisKolam.getStyleClass().add("combo-box-kolam");

        TextField tfLokasiKolam = new TextField();
        tfLokasiKolam.setPromptText("Lokasi Kolam");
        tfLokasiKolam.getStyleClass().add("text-field-kolam");

        TextField tfTanggalTebar = new TextField();
        tfTanggalTebar.setPromptText("DD-MM-YYYY");
        tfTanggalTebar.getStyleClass().add("text-field-kolam");
        TextField tfTanggalPerkiraanPanen = new TextField();
        tfTanggalPerkiraanPanen.setPromptText("DD-MM-YYYY");
        tfTanggalPerkiraanPanen.getStyleClass().add("text-field-kolam");

        TextField tfSuhuAir = new TextField();
        tfSuhuAir.setPromptText("Suhu Air (°C)");
        tfSuhuAir.getStyleClass().add("text-field-kolam");
        TextField tfPhAir = new TextField();
        tfPhAir.setPromptText("pH Air (0-14)");
        tfPhAir.getStyleClass().add("text-field-kolam");

        int row = 0;
        formGrid.add(new Label("ID Kolam:"), 0, row); formGrid.add(tfIdKolam, 1, row++);
        formGrid.add(new Label("Nama Kolam:"), 0, row); formGrid.add(tfNamaKolam, 1, row++);
        formGrid.add(new Label("Jenis Kolam:"), 0, row); formGrid.add(cbJenisKolam, 1, row++);
        formGrid.add(new Label("Lokasi Kolam:"), 0, row); formGrid.add(tfLokasiKolam, 1, row++);
        formGrid.add(new Label("Tanggal Tebar:"), 0, row); formGrid.add(tfTanggalTebar, 1, row++);
        formGrid.add(new Label("Perkiraan Panen:"), 0, row); formGrid.add(tfTanggalPerkiraanPanen, 1, row++);
        formGrid.add(new Label("Suhu Air (°C):"), 0, row); formGrid.add(tfSuhuAir, 1, row++);
        formGrid.add(new Label("pH Air:"), 0, row); formGrid.add(tfPhAir, 1, row++);

        Button btnSimpan = new Button("Simpan");
        Button btnKembali = new Button("Kembali");
        btnSimpan.setMaxWidth(Double.MAX_VALUE);
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        mainVBox.getChildren().addAll(judul, formGrid, btnSimpan, btnKembali);

        Scene scene = new Scene(mainVBox, 600, 750);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Tambah Kolam");
        stage.show();

        btnSimpan.setOnAction(e -> {
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
                showAlert(Alert.AlertType.ERROR, "Error Input", "Semua field harus diisi!");
                return;
            }

            double suhuAir;
            double phAir;
            try {
                suhuAir = Double.parseDouble(suhuAirStr);
                phAir = Double.parseDouble(phAirStr);
                if (suhuAir < 0 || phAir < 0 || phAir > 14) {
                    showAlert(Alert.AlertType.ERROR, "Input Tidak Valid", "Suhu atau pH tidak valid (pH antara 0-14, suhu > 0).");
                    return;
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Format Angka Salah", "Suhu atau pH harus berupa angka!");
                return;
            }

            // PERUBAHAN UNTUK DATABASE: Cek keberadaan di DB
            boolean exists = budidaya.getDaftarKolam().stream()
                    .anyMatch(k -> k.getIdKolam().equals(idKolam));
            if (exists) {
                showAlert(Alert.AlertType.ERROR, "ID Duplikat", "ID Kolam sudah terdaftar!");
                return;
            }

            Kolam kolam = new Kolam(idKolam, namaKolam, jenisKolam, lokasiKolam,
                                    tanggalTebar, tanggalPerkiraanPanen, suhuAir, phAir);
            budidaya.tambahKolam(kolam); // PERUBAHAN UNTUK DATABASE: Simpan ke DB
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Kolam berhasil ditambahkan!");
            this.tampilkanSubMenuKolam();
        });

        btnKembali.setOnAction(e -> this.tampilkanSubMenuKolam());
    }

    private void tampilkanDaftarKolam() {
        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(30));

        Label judul = new Label("Daftar Kolam");
        judul.getStyleClass().addAll("label-sub-menu-title", "kolam");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        TextArea taDaftar = new TextArea();
        taDaftar.setEditable(false);
        taDaftar.setPrefHeight(400);
        taDaftar.setWrapText(true);

        StringBuilder sb = new StringBuilder();
        // PERUBAHAN UNTUK DATABASE: Memuat data dari DB setiap kali dibuka
        List<Kolam> daftarKolam = budidaya.getDaftarKolam();
        if (daftarKolam.isEmpty()) {
            sb.append("Belum ada kolam terdaftar.");
        } else {
            for (Kolam k : daftarKolam) {
                sb.append(k.toString()).append("\n--------------------\n");
            }
        }
        taDaftar.setText(sb.toString());

        Button btnKembali = new Button("Kembali");
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        mainVBox.getChildren().addAll(judul, taDaftar, btnKembali);

        Scene scene = new Scene(mainVBox, 650, 650);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Daftar Kolam");
        stage.show();

        btnKembali.setOnAction(e -> this.tampilkanSubMenuKolam());
    }

    private void tampilkanFormTambahIkan() {
        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(30));

        Label judul = new Label("Tambah Data Ikan Baru");
        judul.getStyleClass().addAll("label-sub-menu-title", "ikan");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(15);
        formGrid.getStyleClass().addAll("grid-pane", "grid-pane-ikan");
        formGrid.setPadding(new Insets(20));

        TextField tfIdIkan = new TextField();
        tfIdIkan.setPromptText("ID Ikan (misal: IK001)");
        tfIdIkan.getStyleClass().add("text-field-ikan");
        TextField tfNamaIkan = new TextField();
        tfNamaIkan.setPromptText("Nama Ikan");
        tfNamaIkan.getStyleClass().add("text-field-ikan");
        TextField tfJumlahIkan = new TextField();
        tfJumlahIkan.setPromptText("Jumlah Ikan (ekor)");
        tfJumlahIkan.getStyleClass().add("text-field-ikan");
        TextField tfJenisPakan = new TextField();
        tfJenisPakan.setPromptText("Jenis Pakan");
        tfJenisPakan.getStyleClass().add("text-field-ikan");
        TextField tfTanggalPakan = new TextField();
        tfTanggalPakan.setPromptText("DD-MM-YYYY");
        tfTanggalPakan.getStyleClass().add("text-field-ikan");
        TextField tfJumlahPakan = new TextField();
        tfJumlahPakan.setPromptText("Jumlah Pakan (kg)");
        tfJumlahPakan.getStyleClass().add("text-field-ikan");

        ComboBox<String> cbWaktuPakan = new ComboBox<>();
        cbWaktuPakan.getItems().addAll("Pagi", "Siang", "Sore");
        cbWaktuPakan.setPromptText("Pilih Waktu Pakan");
        cbWaktuPakan.setMaxWidth(Double.MAX_VALUE);
        cbWaktuPakan.getStyleClass().add("combo-box-ikan");

        TextField tfTanggalPanen = new TextField();
        tfTanggalPanen.setPromptText("DD-MM-YYYY");
        tfTanggalPanen.getStyleClass().add("text-field-ikan");
        TextField tfJumlahPanen = new TextField();
        tfJumlahPanen.setPromptText("Jumlah Panen (ekor)");
        tfJumlahPanen.getStyleClass().add("text-field-ikan");
        TextField tfBeratTotalPanen = new TextField();
        tfBeratTotalPanen.setPromptText("Berat Total Panen (kg)");
        tfBeratTotalPanen.getStyleClass().add("text-field-ikan");

        // PERUBAHAN UNTUK DATABASE: Memuat ulang daftar kolam/peternak saat form ikan dibuka
        ComboBox<Kolam> cbKolam = new ComboBox<>();
        cbKolam.getItems().addAll(budidaya.getDaftarKolam()); // Memuat ulang
        cbKolam.setPromptText("Pilih Kolam");
        cbKolam.setMaxWidth(Double.MAX_VALUE);
        cbKolam.setConverter(new javafx.util.StringConverter<Kolam>() {
            @Override
            public String toString(Kolam kolam) {
                return kolam != null ? kolam.getNamaKolam() + " (ID: " + kolam.getIdKolam() + ")" : "";
            }
            @Override
            public Kolam fromString(String string) { return null; }
        });
        cbKolam.getStyleClass().add("combo-box-ikan");

        ComboBox<Peternak> cbPeternak = new ComboBox<>();
        cbPeternak.getItems().addAll(budidaya.getDaftarPeternak()); // Memuat ulang
        cbPeternak.setPromptText("Pilih Peternak");
        cbPeternak.setMaxWidth(Double.MAX_VALUE);
        cbPeternak.setConverter(new javafx.util.StringConverter<Peternak>() {
            @Override
            public String toString(Peternak peternak) {
                return peternak != null ? peternak.getNamaPeternak() + " (ID: " + peternak.getIdPeternak() + ")" : "";
            }
            @Override
            public Peternak fromString(String string) { return null; }
        });
        cbPeternak.getStyleClass().add("combo-box-ikan");

        int row = 0;
        formGrid.add(new Label("ID Ikan:"), 0, row); formGrid.add(tfIdIkan, 1, row++);
        formGrid.add(new Label("Nama Ikan:"), 0, row); formGrid.add(tfNamaIkan, 1, row++);
        formGrid.add(new Label("Jumlah Ikan (tebar):"), 0, row); formGrid.add(tfJumlahIkan, 1, row++);
        formGrid.add(new Label("Jenis Pakan:"), 0, row); formGrid.add(tfJenisPakan, 1, row++);
        formGrid.add(new Label("Tanggal Pakan:"), 0, row); formGrid.add(tfTanggalPakan, 1, row++);
        formGrid.add(new Label("Jumlah Pakan:"), 0, row); formGrid.add(tfJumlahPakan, 1, row++);
        formGrid.add(new Label("Waktu Pakan:"), 0, row); formGrid.add(cbWaktuPakan, 1, row++);
        formGrid.add(new Label("Tanggal Panen:"), 0, row); formGrid.add(tfTanggalPanen, 1, row++);
        formGrid.add(new Label("Jumlah Panen:"), 0, row); formGrid.add(tfJumlahPanen, 1, row++);
        formGrid.add(new Label("Berat Total Panen:"), 0, row); formGrid.add(tfBeratTotalPanen, 1, row++);
        formGrid.add(new Label("Pilih Kolam:"), 0, row); formGrid.add(cbKolam, 1, row++);
        formGrid.add(new Label("Pilih Peternak:"), 0, row); formGrid.add(cbPeternak, 1, row++);

        Button btnSimpan = new Button("Simpan");
        Button btnKembali = new Button("Kembali");
        btnSimpan.setMaxWidth(Double.MAX_VALUE);
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(formGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(450);

        mainVBox.getChildren().addAll(judul, scrollPane, btnSimpan, btnKembali);

        Scene scene = new Scene(mainVBox, 700, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Tambah Data Ikan");
        stage.show();

        btnSimpan.setOnAction(e -> {
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
            Kolam selectedKolam = cbKolam.getValue();
            Peternak selectedPeternak = cbPeternak.getValue();

            if (idIkan.isEmpty() || namaIkan.isEmpty() || jumlahIkanStr.isEmpty() || jenisPakan.isEmpty() ||
                tanggalPakan.isEmpty() || jumlahPakanStr.isEmpty() || waktuPakan == null ||
                tanggalPanen.isEmpty() || jumlahPanenStr.isEmpty() || beratTotalPanenStr.isEmpty() ||
                selectedKolam == null || selectedPeternak == null) {
                showAlert(Alert.AlertType.ERROR, "Error Input", "Semua field harus diisi, termasuk Kolam dan Peternak.");
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
                    showAlert(Alert.AlertType.ERROR, "Input Tidak Valid", "Jumlah harus positif (atau nol untuk panen jika belum).");
                    return;
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Format Angka Salah", "Jumlah harus angka yang valid!");
                return;
            }

            // PERUBAHAN UNTUK DATABASE: Cek keberadaan di DB
            boolean exists = budidaya.getDaftarIkan().stream().anyMatch(i -> i.getIdIkan().equals(idIkan));
            if (exists) {
                showAlert(Alert.AlertType.ERROR, "ID Duplikat", "ID Ikan sudah terdaftar!");
                return;
            }

            Ikan ikan = new Ikan(idIkan, namaIkan, jumlahIkan, jenisPakan, tanggalPakan, jumlahPakan,
                                 waktuPakan, tanggalPanen, jumlahPanen, beratTotalPanen,
                                 selectedKolam.getIdKolam(), selectedPeternak.getIdPeternak());
            budidaya.tambahIkan(ikan); // PERUBAHAN UNTUK DATABASE: Simpan ke DB
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Ikan berhasil ditambahkan!");
            this.tampilkanSubMenuIkan();
        });

        btnKembali.setOnAction(e -> this.tampilkanSubMenuIkan());
    }

    private void tampilkanDaftarIkan() {
        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(30));

        Label judul = new Label("Daftar Ikan");
        judul.getStyleClass().addAll("label-sub-menu-title", "ikan");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        TextArea taDaftar = new TextArea();
        taDaftar.setEditable(false);
        taDaftar.setPrefHeight(400);
        taDaftar.setWrapText(true);

        StringBuilder sb = new StringBuilder();
        // PERUBAHAN UNTUK DATABASE: Memuat data dari DB setiap kali dibuka
        List<Ikan> daftarIkan = budidaya.getDaftarIkan();
        if (daftarIkan.isEmpty()) {
            sb.append("Belum ada data ikan.");
        } else {
            for (Ikan i : daftarIkan) {
                sb.append(i.toString()).append("\n--------------------\n");
            }
        }
        taDaftar.setText(sb.toString());

        Button btnKembali = new Button("Kembali");
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        mainVBox.getChildren().addAll(judul, taDaftar, btnKembali);

        Scene scene = new Scene(mainVBox, 700, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Daftar Ikan");
        stage.show();

        btnKembali.setOnAction(e -> this.tampilkanSubMenuIkan());
    }

    private void tampilkanFormCariIkan() {
        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(30));

        Label judul = new Label("Cari Data Lengkap Ikan");
        judul.getStyleClass().addAll("label-sub-menu-title", "ikan");
        judul.setAlignment(Pos.CENTER);
        judul.setPrefWidth(Double.MAX_VALUE);

        GridPane searchGrid = new GridPane();
        searchGrid.setHgap(15);
        searchGrid.setVgap(15);
        searchGrid.getStyleClass().addAll("grid-pane", "grid-pane-ikan");
        searchGrid.setPadding(new Insets(20));

        TextField tfIdCari = new TextField();
        tfIdCari.setPromptText("Masukkan ID Ikan yang dicari");
        tfIdCari.getStyleClass().add("text-field-ikan");

        searchGrid.add(new Label("ID Ikan:"), 0, 0);
        searchGrid.add(tfIdCari, 1, 0);

        Button btnCari = new Button("Cari");
        Button btnKembali = new Button("Kembali");
        btnCari.setMaxWidth(Double.MAX_VALUE);
        btnKembali.setMaxWidth(Double.MAX_VALUE);

        TextArea taHasil = new TextArea();
        taHasil.setEditable(false);
        taHasil.setPrefHeight(350);
        taHasil.setWrapText(true);

        mainVBox.getChildren().addAll(judul, searchGrid, btnCari, new Separator(), taHasil, btnKembali);

        Scene scene = new Scene(mainVBox, 700, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Cari Data Ikan");
        stage.show();

        btnCari.setOnAction(e -> {
            String idCari = tfIdCari.getText().trim();
            if (idCari.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error Input", "ID Ikan harus diisi!");
                taHasil.clear();
                return;
            }

            // PERUBAHAN UNTUK DATABASE: Menggunakan cariIkanById dari Budidaya
            Ikan ikanDitemukan = budidaya.cariIkanById(idCari);

            if (ikanDitemukan == null) { // Jika tidak ditemukan
                taHasil.setText("Ikan dengan ID '" + idCari + "' tidak ditemukan.");
            } else {
                Kolam kolamTerkait = budidaya.getDaftarKolam().stream()
                                            .filter(k -> k.getIdKolam().equals(ikanDitemukan.getIdKolam()))
                                            .findFirst().orElse(null);

                Peternak peternakTerkait = budidaya.getDaftarPeternak().stream()
                                                  .filter(p -> p.getIdPeternak().equals(ikanDitemukan.getIdPeternak()))
                                                  .findFirst().orElse(null);

                StringBuilder hasil = new StringBuilder();
                hasil.append("--- Data Ikan ---\n");
                hasil.append("ID Ikan                : ").append(ikanDitemukan.getIdIkan()).append("\n");
                hasil.append("Nama Ikan              : ").append(ikanDitemukan.getNamaIkan()).append("\n");
                hasil.append("Jumlah Ikan (tebar)    : ").append(ikanDitemukan.getJumlahIkan()).append(" ekor\n");
                hasil.append("Jenis Pakan            : ").append(ikanDitemukan.getJenisPakan()).append("\n");
                hasil.append("Tanggal Pakan          : ").append(ikanDitemukan.getTanggalPakan()).append("\n");
                hasil.append("Jumlah Pakan           : ").append(ikanDitemukan.getJumlahPakan()).append(" kg\n");
                hasil.append("Waktu Pemberian Pakan  : ").append(ikanDitemukan.getWaktuPemberianPakan()).append("\n");
                hasil.append("Tanggal Panen          : ").append(ikanDitemukan.getTanggalPanen()).append("\n");
                hasil.append("Jumlah Panen           : ").append(ikanDitemukan.getJumlahPanen()).append(" ekor\n");
                hasil.append("Berat Total Panen      : ").append(ikanDitemukan.getBeratTotalPanen()).append(" kg\n\n");

                hasil.append("--- Data Kolam Terkait ---\n");
                if (kolamTerkait != null) {
                    hasil.append("ID Kolam               : ").append(kolamTerkait.getIdKolam()).append("\n");
                    hasil.append("Nama Kolam             : ").append(kolamTerkait.getNamaKolam()).append("\n");
                    hasil.append("Jenis Kolam            : ").append(kolamTerkait.getJenisKolam()).append("\n");
                    hasil.append("Lokasi Kolam           : ").append(kolamTerkait.getLokasiKolam()).append("\n");
                    hasil.append("Tanggal Tebar          : ").append(kolamTerkait.getTanggalTebar()).append("\n");
                    hasil.append("Perkiraan Panen        : ").append(kolamTerkait.getTanggalPerkiraanPanen()).append("\n");
                    hasil.append("Suhu Air               : ").append(kolamTerkait.getSuhuAir()).append("°C\n");
                    hasil.append("pH Air                 : ").append(kolamTerkait.getPhAir()).append("\n\n");
                } else {
                    hasil.append("Kolam dengan ID '").append(ikanDitemukan.getIdKolam()).append("' tidak ditemukan.\n\n");
                }

                hasil.append("--- Data Peternak Terkait ---\n");
                if (peternakTerkait != null) {
                    hasil.append("ID Peternak            : ").append(peternakTerkait.getIdPeternak()).append("\n");
                    hasil.append("Nama Peternak          : ").append(peternakTerkait.getNamaPeternak()).append("\n");
                    hasil.append("Alamat Peternak        : ").append(peternakTerkait.getAlamatPeternak()).append("\n");
                } else {
                    hasil.append("Peternak dengan ID '").append(ikanDitemukan.getIdPeternak()).append("' tidak ditemukan.\n");
                }

                taHasil.setText(hasil.toString());
            }
        });

        btnKembali.setOnAction(e -> this.tampilkanSubMenuIkan());
    }

    private void showAlert(Alert.AlertType tipe, String title, String pesan) {
        Alert alert = new Alert(tipe);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}