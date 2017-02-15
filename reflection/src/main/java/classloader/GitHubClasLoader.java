package classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

/**
 * Created by fedinskiy on 15.02.17.
 */
public class GitHubClasLoader extends ClassLoader {
    private Hashtable classes = new Hashtable();
    private final String gitHubClassPath = "https://raw.githubusercontent" +
            ".com/jaowl/practice-java/master/tmp/";
    private final String classFileExtension=".class";

    public GitHubClasLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String s) throws ClassNotFoundException {
        return findClass(s);
    }

    @Override
    protected Class<?> findClass(String className) throws
            ClassNotFoundException {
        Class result = null;
        System.out.println("class loading is in process");
        byte classByte[] = new byte[0];
        URL classURL = null;

        result = (Class) classes.get(className); //checks in cached classes
        if (result != null) {
            return result;
        }

        try {
            return findSystemClass(className);
        } catch (Exception e) {
        }

        try {

            classURL = new URL(gitHubClassPath + className+classFileExtension);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        InputStream is = null;
        try {
            is = classURL.openStream();
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = 0;

            nextValue = is.read();
            while (-1 != nextValue) {
                byteStream.write(nextValue);
                nextValue = is.read();
            }
            classByte = byteStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }



        result = defineClass(className, classByte, 0, classByte.length, null);
        classes.put(className, result);
        return result;
    }


}
