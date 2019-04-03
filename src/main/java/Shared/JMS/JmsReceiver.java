package Shared.JMS;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

public class JmsReceiver extends JmsConnect {





    MessageConsumer consumer;
    public JmsReceiver (String topic) {
        super(topic);
    }
    public boolean connect(){
        try{

            consumer = session.createConsumer(Destination);
            connection.start(); // this is needed to start receiving messages
            return true;


        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void registerListener(MessageListener listener){
        try {
            consumer.setMessageListener(listener);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
