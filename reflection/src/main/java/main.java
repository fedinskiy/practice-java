import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import persons.Person;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        final String schemapath= args[0];
        final String filepath = args[1];
        Person person = new Person();
        try {
            person.getClass().getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        person.getClass().getDeclaredFields()[0].getName();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation impl = builder.getDOMImplementation(); // более сложный, но и более гибкий способ создания документов
        Document doc = impl.createDocument(null, // namespaceURI
                null, // qualifiedName
                null); // doctype
    }
}
