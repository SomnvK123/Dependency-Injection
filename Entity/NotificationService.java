package Entity;

import Annotation.*;

@Component
public class NotificationService {
    @Autowired
    @Qualifier("emailService")
    private MessageService messageService;

    public NotificationService() {
    }

    public void notifyUser(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }

}
