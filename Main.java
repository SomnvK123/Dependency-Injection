import Context.*;
import Entity.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ApplicationContext();

        // Quét và khởi tạo tất cả các component, lưu đúng beanName
        context.reflectionComponent(Class.forName("Entity.EmailService"));
        context.reflectionComponent(Class.forName("Entity.SMSService"));
        context.reflectionComponent(Class.forName("Entity.NotificationService"));

        // Lấy NotificationService đã được inject dependencies
        NotificationService service = (NotificationService) context.getBean("NotificationService");

        // Gọi hàm sử dụng
        service.notifyUser("Hello", "user@gmail.com");
    }
}
