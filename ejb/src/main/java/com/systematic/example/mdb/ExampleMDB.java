package com.systematic.example.mdb;

import javax.annotation.PostConstruct;
import javax.annotation.security.RunAs;
import javax.ejb.*;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.UUID;

/**
 * Message-driven bean example for Red Hat support case 02415782.
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "reconnectAttempts", propertyValue = "100000"),
    @ActivationConfigProperty(propertyName = "reconnectInterval", propertyValue = "10"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:global/artemis/dynamicQueues/TestQueue"),
})
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@RunAs("PlatformRole")
public class ExampleMDB implements MessageListener {

    @PostConstruct
    public void ejbCreate()
    {
        System.out.println("ExampleMDB: constructed");
    }

    @Override
    public void onMessage(Message incomingMessage) {
        String traceId = UUID.randomUUID().toString();
        System.out.println(traceId + " ExampleMDB: incoming message");
    }

}