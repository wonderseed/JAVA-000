package Week_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> Hello = new CustomClassLoader().findClass("Hello");
            Method method = Hello.getMethod("hello");
            Object obj = Hello.newInstance();
            method.invoke(obj);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File helloFile = new File(this.getClass().getResource("Hello.xlass").getFile());
        int length = (int) helloFile.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(helloFile).read(bytes);
            for (int i = 0; i < length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }
}
