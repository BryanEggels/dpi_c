package Shared.JMS;

import java.util.Properties;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.activemq.ActiveMQConnectionFactory;


public class JmsConnect {
    Connection connection;
    Session session;
    Destination Destination;

    public JmsConnect(String topic) {
        try{
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                    "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");

            props.put(("queue."+topic), topic);

            Context jndiContext = new InitialContext(props);

            ActiveMQConnectionFactory connectionFactory = (ActiveMQConnectionFactory) jndiContext
                    .lookup("ConnectionFactory");
            connectionFactory.setTrustAllPackages(true);
            connection = connectionFactory.createConnection();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //connect to the receiver destination
            Destination = (Destination)jndiContext.lookup(topic);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
