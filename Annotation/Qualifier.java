package Annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })

public @interface Qualifier {
    String value() default ""; // Name of the bean to be injected
}
