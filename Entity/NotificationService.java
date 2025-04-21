package Entity;

import Annotation.*;

@Component
public class NotificationService {
    @Autowired
    @Qualifier("emailService")
    private MessageService messageService;

    public void nofity(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }

}
