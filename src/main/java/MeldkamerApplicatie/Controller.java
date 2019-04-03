package MeldkamerApplicatie;

import Shared.MessageStorage;
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
  TextField tb_services;

  @FXML
  Button btn_submit;


  public void addReport(Report report) {
    final Report report1 = report;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        lv_reports.getItems().add(report1);
      }
    });
  }

  @FXML
  public void processReport() {
    if (tb_services.getText() != null && lv_reports.getSelectionModel() != null) {
      String processTo = tb_services.getText();
      Report currentReport = lv_reports.getSelectionModel().getSelectedItem();
      if (String.valueOf(processTo).contains("1")) {
        MeldkamerApp.getEgateway().policeSender.sendReport(currentReport);
        setRepliesToReceive(currentReport);
      }
      if (String.valueOf(processTo).contains("2")) {
        MeldkamerApp.getEgateway().ambulanceSender.sendReport(currentReport);
        setRepliesToReceive(currentReport);
      }
      if (String.valueOf(processTo).contains("3")) {
        MeldkamerApp.getEgateway().firebrigadeSender.sendReport(currentReport);
        setRepliesToReceive(currentReport);
      }
    }
  }
  public void setRepliesToReceive(Report selectedReport){
    for (Report report: MessageStorage.getInstance().getReports()) {
      if (report.getId() == selectedReport.getId()){
        report.repliesToReceive++;
      }
    }
  }
}
