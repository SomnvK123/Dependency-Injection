package Context;

import Annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class ApplicationContext {

    private static final Map<String, Object> beans = new HashMap<>();

    public void reflectionComponent(Class<?> cla) throws Exception {
        if (cla.isAnnotationPresent(Component.class)) { // Kiểm tra xem class có annotation @Component không
            // Tạo instance của class được quét
            Object instance = cla.getDeclaredConstructor().newInstance();
            String beanName = cla.getSimpleName(); // Lưu tên bean theo kiểu class name
            beans.put(beanName, instance); // Lưu vào beans map với tên đúng

            System.out.println("Created instance of: " + beanName);

            // Duyệt qua tất cả các field trong class để kiểm tra và inject dependencies
            for (Field field : cla.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) { // Kiểm tra xem field có annotation @Autowired không
                    Qualifier qualifier = field.getAnnotation(Qualifier.class);
                    String dependencyName = qualifier != null ? qualifier.value() : field.getType().getSimpleName();
                    Object fieldInstance = beans.get(dependencyName);

                    if (fieldInstance == null) {
                        for (Object obj : beans.values()) {
                            Class<?> impClass = obj.getClass();
                            if (field.getType().isAssignableFrom(impClass)) {
                                Qualifier qualifierAnnotation = impClass.getAnnotation(Qualifier.class);
                                if (qualifierAnnotation != null && qualifierAnnotation.value().equals(dependencyName)) {
                                    fieldInstance = obj;
                                    break;
                                }
                            }
                        }
                    }

                    if (fieldInstance != null) {
                        field.setAccessible(true);
                        field.set(instance, fieldInstance);
                        System.out.println("Injected dependency: " + dependencyName + " into " + cla.getName());
                    } else {
                        throw new RuntimeException("No suitable bean found for " + dependencyName);
                    }
                }
            }
        }
    }

    public Object getBean(String name) {
        return beans.get(name);
    }
}
