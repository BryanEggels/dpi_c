package MeldkamerApplicatie;

import Shared.Report;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MeldkamerApp extends Application {

    static Controller controller;
    static EmergencyServicesGateway egateway;
    static UserGateway gateway;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MeldkamerApplicatie.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.setTitle("Meldkamer Applicatie");
        primaryStage.setScene(new Scene(root, 400, 225));
        primaryStage.show();

    }


    public static EmergencyServicesGateway getEgateway() {
        return egateway;
    }

    public static void setEgateway(EmergencyServicesGateway egateway) {
        MeldkamerApp.egateway = egateway;
    }

    public static UserGateway getGateway() {
        return gateway;
    }

    public static void setGateway(UserGateway gateway) {
        MeldkamerApp.gateway = gateway;
    }

    public static void main(String[] args) {
        gateway = new UserGateway();
        gateway.registerListener(new ReportListener());
        egateway = new EmergencyServicesGateway();
        egateway.registerListener(new EmergencyReportListener());
        launch(args);



    }
    public static void addReport(Report report){
        controller.addReport(report);
    }

}
