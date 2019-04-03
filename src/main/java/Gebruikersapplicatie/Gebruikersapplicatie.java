package Gebruikersapplicatie;

import Shared.Report;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gebruikersapplicatie extends Application {

    static List<Report> reports;
    static Controller controller;

    public static Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        Gebruikersapplicatie.controller = controller;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gebruikersapplicatie.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        primaryStage.setTitle("User Application");
        primaryStage.setScene(new Scene(root, 400, 225));
        primaryStage.show();
    }


    public static void main(String[] args) {
        reports = new ArrayList<>();
        launch(args);
    }

    public static List<Report> getReports() {
        return reports;
    }

    public static void setReports(List<Report> reports) {
        Gebruikersapplicatie.reports = reports;
    }
    public static void addReport(Report report){
        controller.addReport(report);
    }
}
