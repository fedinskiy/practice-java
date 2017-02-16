package classloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by fedinskiy on 15.02.17.
 */
public class GitHubClasLoader extends ClassLoader {
    private Hashtable classes = new Hashtable();
    private final String gitHubClassPath = "https://raw.githubusercontent" +
            ".com/jaowl/practice-java/master/tmp/";
    private final String jarName = "place.jar";
    private final String classFileExtension = ".class";

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

            classURL = new URL(gitHubClassPath+ jarName);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        InputStream is = null;
        try {
            JarFile jar = downloadJAR(classURL);
            JarEntry entry = jar.getJarEntry(className + classFileExtension);
            is = jar.getInputStream(entry);
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

    private JarFile downloadJAR(URL jarURL) throws IOException {
        InputStream is = null;
        FileOutputStream jarWriter = new FileOutputStream(jarName);
        JarFile jar = null;

        is = jarURL.openStream();
        int nextValue = 0;

        nextValue = is.read();
        while (-1 != nextValue) {
            jarWriter.write(nextValue);
            nextValue = is.read();
        }

        jarWriter.close();
        jar = new JarFile(new File(jarName));
        return jar;
    }

}
