package Gebruikersapplicatie;

import Shared.Report;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;


public class Controller {
  @FXML
  TextField tb_alert;

  @FXML
  Button btn_submit;

  @FXML
  ListView<Report> lv_meldingen;

  @FXML
  public void handleButtonSubmit(ActionEvent actionEvent) {
    if(tb_alert.getText() != null){
      String input = tb_alert.getText();
      MeldkamerGateway gateway = new MeldkamerGateway();
      gateway.receiver.connect();
      gateway.receiver.registerListener(new ReportReplyListener());
      Report report = new Report(input);
      gateway.sender.userSendReport(new Report(input));

    }

  }
  public void replaceReport(Report report){
    int num = 0;
    for (Report reportToReplace : lv_meldingen.getItems()) {
      if (report.getId().equals(reportToReplace.getId())){
        removeReport(num);
        addReport(report);
      }
      num++;
    }
  }
  public void addReport(Report report, final int index){
    final Report report1 = report;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        lv_meldingen.getItems().add(index, report1);
      }
    });
  }
  public void removeReport(final int index){
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        lv_meldingen.getItems().remove(index);
      }
    });
  }
  public void addReport(Report report){
    final Report report1 = report;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        lv_meldingen.getItems().add(report1);
      }
    });
  }
}
