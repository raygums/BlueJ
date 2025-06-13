// AplikasiBudidaya.java
import javafx.application.Application;
import javafx.stage.Stage;

public class AplikasiBudidaya extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Mengatur judul jendela utama aplikasi
        primaryStage.setTitle("Sistem Manajemen Ternak Ikan");

        // Buat objek Budidaya
        // Objek Budidaya ini sekarang akan berinteraksi dengan DatabaseManager
        Budidaya budidaya = new Budidaya(); 
        
        // Buat objek Menu, yang akan mengelola tampilan GUI dan interaksi dengan Budidaya
        Menu menu = new Menu(budidaya, primaryStage); 
        
        // Panggil metode untuk menampilkan menu utama aplikasi
        menu.tampilkanMenuUtama(); 
    }

    public static void main(String[] args) {
        // Ini adalah cara untuk meluncurkan aplikasi JavaFX.
        // launch() akan memanggil metode start() di atas.
        launch(args);
    }
}