package AmbuApplicatie;

import Shared.Report;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
  @FXML
  ListView<Report> lv_reports;

  @FXML
  Button btn_submit;

  @FXML
  TextField tb_replyTime;

  @FXML
  Button btn_ignore;


  public void processReport(){
    if (tb_replyTime != null){
      String responstime = "ambulance: " + tb_replyTime.getText();
      Report currentReport = lv_reports.getSelectionModel().getSelectedItem();
      currentReport.addResponseTime(responstime);
      AmbuApplicatie.getGateway().sender.sendReport(currentReport);
    }

  }

  public void addReport(Report report){
    final Report report1 = report;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        lv_reports.getItems().add(report1);
      }
    });
  }


  public void ignore(){

  }

}
