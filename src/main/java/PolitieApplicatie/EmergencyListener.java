package PolitieApplicatie;

import Shared.MessageStorage;
import Shared.Report;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class EmergencyListener implements MessageListener {

  @Override
  public void onMessage(Message message) {
    ObjectMessage objectMessage = (ObjectMessage) message;
    try {
      Report report = (Report) objectMessage.getObject();
      System.out.println(report.toString());
      MessageStorage.getInstance().addReport(report);
      PolitieApplicatie.addReport(report);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}