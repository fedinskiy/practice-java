package helpers;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class DOMHelper {
    private DocumentBuilder builder;
    private DocumentBuilderFactory factory;
    private DOMImplementation domImplementation;

    public DOMHelper() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        domImplementation = builder.getDOMImplementation();
    }

    public Document createDocument() {
        return domImplementation.createDocument(null, // namespaceURI
                null, // qualifiedName
                null);
    }

    public Document readDocument(String path) throws IOException, SAXException {
        return builder.parse(new File(path));
    }
}
