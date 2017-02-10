package serialization;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.lang.reflect.Field;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Serializer {

    public static Document serialize(Object obj, Document document) throws IllegalAccessException {
        final Field[] fields;
        final Class oclass = obj.getClass();
        final Element person;
        Element personInfo;

        fields = oclass.getDeclaredFields();


        person = document.createElement("Object");
        person.setAttribute("type", oclass.getName());
        document.setXmlStandalone(false);
        document.appendChild(person);
        for (Field field : fields) {
            field.setAccessible(true);
            personInfo = document.createElement("field");
            personInfo.setAttribute("type", field.getType().getSimpleName());
            personInfo.setAttribute("id", field.getName());
            personInfo.setAttribute("value", field.get(obj).toString());
            person.appendChild(personInfo);
        }
        return document;
    }

    public static Object deserialize(Document document, Object object)
            throws IllegalAccessException, NoSuchFieldException {
        final Field[] fields;
        final Class targetClass;
        final Element person;

        targetClass = object.getClass();
        fields = targetClass.getDeclaredFields();

        final Node item = document.getChildNodes().item(0);
        System.out.println(item.getAttributes().getNamedItem("type").getNodeValue());
        for (int i = 0; i < item.getChildNodes().getLength(); ++i) {
            final NamedNodeMap fieldParams = item.getChildNodes().item(i)
                    .getAttributes();
            final Field field = targetClass.getDeclaredField(fieldParams
                    .getNamedItem("id")
                    .getNodeValue());
            field.setAccessible(true);
            field.set(object, castValue(
                    fieldParams.getNamedItem("type").getNodeValue(),
                    fieldParams.getNamedItem("value").getNodeValue()));

            System.out.println();
        }

        // System.out.println(document.getChildNodes().item(0).getNodeName());
        // final NodeList nodeFields = person.getElementsByTagName("field");

        return object;
    }

    private static Object castValue(String type, String value) {
        switch (type.toLowerCase()) {
            case "string":
                return value;
            case "integer":
                return Integer.valueOf(value);
            case "double":
                return Double.parseDouble(value);
        }
        return null;
    }
}
