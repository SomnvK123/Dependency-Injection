package Entity;

import Annotation.*;

public interface MessageService {
    void sendMessage(String message, String recipient);
}