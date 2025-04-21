package Reflection;

import java.lang.reflect.*;

public class Reflection {
    public static String reflectionComponent(Object obj) {
        Class<?> clazz = obj.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getParameterCount() == 0) {
                try {
                    System.out.println("Method Name: " + method.getName());
                    Object result = method.invoke(obj);
                    System.out.println("Return Value: " + result);
                } catch (Exception e) {
                    System.out.println("Error invoking method: " + method.getName() + ": " + e.getMessage());
                }
            }
        }
        return clazz.getName();
    }
}
