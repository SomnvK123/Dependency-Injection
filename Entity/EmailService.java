package Entity;

import Annotation.*;

@Component
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        // Logic to send email
        System.out.println("Email sent to " + recipient + " with message: " + message);
    }

}
