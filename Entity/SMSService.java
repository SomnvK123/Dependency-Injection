package Entity;

import Annotation.*;

@Component
@Qualifier("SMSService")
public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        // Logic to send SMS
        System.out.println("SMS sent to " + recipient + " with message: " + message);
    }

}
