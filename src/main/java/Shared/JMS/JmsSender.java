package Shared.JMS;

import Gebruikersapplicatie.Gebruikersapplicatie;
import Shared.Report;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;


public class JmsSender extends JmsConnect {


    MessageProducer producer;

    String correlationID;

    public JmsSender(String topicName) {
        super(topicName);
        this.connect();
    }

    public JmsSender(String topicName, String correlationID){
        super(topicName);
        this.correlationID = correlationID;
    }

    public boolean connect(){
        try {
            producer = session.createProducer(Destination);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendReport(Report report){
        try {
            Message msg =  session.createObjectMessage(report);
            if (report.getId() != null){
                msg.setJMSCorrelationID(report.getId());
            }
            producer.send(msg);
            System.out.println(msg.getJMSMessageID());
            return true;
        } catch (JMSException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean userSendReport(Report report){
        try {
            Message msg =  session.createObjectMessage(report);
            producer.send(msg);
            System.out.println(msg.getJMSMessageID());
            report.setId(msg.getJMSMessageID());
            Gebruikersapplicatie.addReport(report);
            return true;
        } catch (JMSException e) {
            e.printStackTrace();
            return false;
        }
    }
}
