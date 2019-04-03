package Gebruikersapplicatie;

import Shared.Report;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class ReportReplyListener implements MessageListener {

  @Override
  public void onMessage(Message message) {
    ObjectMessage objectMessage = (ObjectMessage) message;
    try {
      Report recreport = (Report) objectMessage.getObject();
      System.out.println(recreport.toString());

      Gebruikersapplicatie.getController().replaceReport(recreport);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
