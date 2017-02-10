import helpers.DOMHelper;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import serialization.Serializer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class main {
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException,
            IllegalAccessException, TransformerException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException {
        final String schemapath = args[0];
        final String fileWritePath = args[1];
        final String fileReadPath = args[2];
        final DOMHelper DOMOperations;
        final Document readDocument;
        Document writeDocument;

        DOMOperations = new DOMHelper();

        writeDocument = DOMOperations.createDocument();
        testWrite(fileWritePath, writeDocument);
        readDocument = DOMOperations.readDocument(fileReadPath);
        testRead(readDocument);
    }

    private static void testRead(Document document)
            throws NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InstantiationException,
            InvocationTargetException {

        Person getted = (Person) Serializer.deserialize(document, Person.class);
        System.out.println(getted);
    }

    private static void testWrite(String filepath, Document doc) throws
            ParserConfigurationException, IllegalAccessException,
            TransformerException, IOException, NoSuchFieldException {
        final File file;
        final Person person;

        file = new File(filepath);
        person = new Person("Jonhn Connor", 20, 7.5);

        doc = Serializer.serialize(person, doc);
        write(doc, file);
    }

    public static void write(Document doc, File file)
            throws TransformerException, IOException {
        DOMSource source = new DOMSource(doc);
        FileWriter writer = new FileWriter(file);
        StreamResult result = new StreamResult(writer);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }
}
