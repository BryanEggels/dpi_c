package MeldkamerApplicatie;

import Shared.MessageStorage;
import Shared.Report;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class ReportListener implements MessageListener {

  @Override
  public void onMessage(Message message) {
    ObjectMessage objectMessage = (ObjectMessage) message;
    try {
      Report report = (Report) objectMessage.getObject();
      System.out.println(report.toString());
      report.setId(message.getJMSMessageID());
      MessageStorage.getInstance().addReport(report);
      MeldkamerApp.addReport(report);


    } catch (JMSException e) {
      e.printStackTrace();

    }
  }
}
