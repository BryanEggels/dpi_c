package Gebruikersapplicatie;

import Shared.JMS.JmsReceiver;
import Shared.JMS.JmsSender;

public class MeldkamerGateway {
    JmsSender sender;
    JmsReceiver receiver;

  public MeldkamerGateway() {
    this.sender = new JmsSender("reportRequest");
    this.receiver = new JmsReceiver("reportReply");
    sender.connect();

  }
}
