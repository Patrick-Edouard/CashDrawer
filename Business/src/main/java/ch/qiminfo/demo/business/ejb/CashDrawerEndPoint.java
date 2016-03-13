package ch.qiminfo.demo.business.ejb;


import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by patrick-edouard on 3/7/16.
 */
/*
@MessageDriven(mappedName = "ReRatting_Queue",activationConfig =
{
@ActivationConfigProperty(propertyName="messagingType", propertyValue="javax.jms.MessageListener"),
@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
@ActivationConfigProperty(propertyName="Destination", propertyValue="java:/queue/ReRatting_Queue"),
@ActivationConfigProperty(propertyName="ConnectionFactoryName", propertyValue="ConnectionFactory"),
@ActivationConfigProperty(propertyName="MaxPoolSize", propertyValue="1"),
@ActivationConfigProperty(propertyName="MaxMessages", propertyValue="1"),
@ActivationConfigProperty(propertyName = "useJNDI", propertyValue = "true")
})
public class CashDrawerEndPoint implements MessageListener {

    public void onMessage(Message message) {

    }
}
*/
