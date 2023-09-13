package be.bf.bf_2023_jakartaee.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class RequestHelper {
    public static  <T> T parseBody(BufferedReader body, Class<T> tClass) {
        try {
            Constructor<T> constructor = tClass.getConstructor();
            T instance = constructor.newInstance();
            String line = body.readLine();
            String[] params = line.split("&");
            Map<String, Object> kvp = new HashMap<>();
            for(String param: params) {
                String[] pData = param.split("=");
                try {
                    Field field = tClass.getDeclaredField(pData[0]);
                    field.setAccessible(true);
                    field.set(instance, pData[1]);
                } catch (NoSuchFieldException e) { }
            }

            return instance;
        } catch (IOException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
