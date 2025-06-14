import javafx.application.Application;
import javafx.stage.Stage;

public class AplikasiBudidaya extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistem Manajemen Ternak Ikan");
        Budidaya budidaya = new Budidaya(); 
        Menu menu = new Menu(budidaya, primaryStage);         
        menu.tampilkanMenuUtama(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}