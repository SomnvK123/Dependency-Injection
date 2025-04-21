import Entity.EmailService;
import Entity.MessageService;

public class Main {
    public static void main(String[] args) {
        MessageService emailService = new EmailService() {
            public void sendMessage(String message, String recipient) {
                // Logic to send email
                System.out.println("Email sent to " + recipient + " with message: " + message);
            }
        };
        MyApplication app = new MyApplication(emailService);
        app.processMessages("Hello, Dependency Injection!", "8x9m4@example.com");
    }
}
