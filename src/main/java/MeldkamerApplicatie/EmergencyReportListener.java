package MeldkamerApplicatie;

import Shared.MessageStorage;
import Shared.Report;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class EmergencyReportListener implements MessageListener {


  @Override
  public void onMessage(Message message) {
    ObjectMessage objectMessage = (ObjectMessage) message;
    try {
      Report recreport = (Report) objectMessage.getObject();

      for (Report report : MessageStorage.getInstance().getReports()) {
        if (report.getId().equals(recreport.getId())){
          report.repliesToReceive--;
          report.addResponseTime(recreport.getResponsetime().get(0));
          if (report.repliesToReceive == 0){
            System.out.println("all replies received for report" + report);
            new UserGateway().sender.sendReport(report);
          }
        }
      }
    } catch (JMSException e) {
      e.printStackTrace();

    }
  }
}
