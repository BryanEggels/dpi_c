package PolitieApplicatie;

import Shared.Report;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PolitieApplicatie extends Application {

  public static Controller controller;



  static MeldkamerGateway gateway;

  @Override
  public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/PolitieApplicatie.fxml"));
    Parent root = loader.load();
    controller = loader.getController();
    primaryStage.setTitle("Politie Applicatie");
    primaryStage.setScene(new Scene(root, 400, 225));
    primaryStage.show();
  }


  public static void main(String[] args) {
    gateway = new MeldkamerGateway();
    gateway.registerListener(new EmergencyListener());
    launch(args);

  }
  public static void addReport(Report report){
    controller.addReport(report);
  }

  public static MeldkamerGateway getGateway() {
    return gateway;
  }

  public static void setGateway(MeldkamerGateway gateway) {
    PolitieApplicatie.gateway = gateway;
  }


}
