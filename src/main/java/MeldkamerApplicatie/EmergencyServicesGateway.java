package MeldkamerApplicatie;

import Shared.JMS.JmsReceiver;
import Shared.JMS.JmsSender;
import javax.jms.MessageListener;

public class EmergencyServicesGateway {

  JmsSender policeSender;
  JmsSender ambulanceSender;
  JmsSender firebrigadeSender;
  JmsReceiver receiver;


  public EmergencyServicesGateway() {
    this.policeSender = new JmsSender("emergencyRequestPolice");
    this.ambulanceSender = new JmsSender("emergencyRequestAmbulance");
    this.firebrigadeSender = new JmsSender("emergencyRequestFirebrigade");
    this.receiver = new JmsReceiver("emergencyReply");


  }

  public void registerListener(MessageListener listener) {
    receiver.connect();
    receiver.registerListener(listener);
  }


}
