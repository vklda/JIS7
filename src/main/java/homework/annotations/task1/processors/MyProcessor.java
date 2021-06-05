package homework.annotations.task1.processors;

import homework.annotations.task1.annotations.MyAnnotation;

import java.lang.reflect.Field;

public class MyProcessor {

    public boolean process(Object object) throws IllegalAccessException {
        boolean result = false;
        Class<?> clazz = object.getClass();
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getAnnotatedType().getType().equals(Integer.class)) {
                    if ((Integer) field.get(object) > 9) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
