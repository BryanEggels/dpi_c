package MeldkamerApplicatie;

import Shared.JMS.JmsReceiver;
import Shared.JMS.JmsSender;
import javax.jms.MessageListener;

public class UserGateway {
  JmsSender sender;
  JmsReceiver receiver;


  public UserGateway() {
    this.sender = new JmsSender("reportReply");
    this.receiver = new JmsReceiver("reportRequest");
    sender.connect();

  }
  public void registerListener(MessageListener listener){
    receiver.connect();
    receiver.registerListener(listener);
  }



}
