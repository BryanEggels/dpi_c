package AmbuApplicatie;

import Shared.JMS.JmsReceiver;
import Shared.JMS.JmsSender;
import javax.jms.MessageListener;

public class MeldkamerGateway {
  JmsSender sender;
  JmsReceiver receiver;

  public MeldkamerGateway() {
    this.sender = new JmsSender("emergencyReply");
    this.receiver = new JmsReceiver("emergencyRequestAmbulance");
    sender.connect();
  }

  public void registerListener(MessageListener listener){
    receiver.connect();
    receiver.registerListener(listener);
  }
}
