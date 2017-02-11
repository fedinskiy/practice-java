package serialization;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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

    public static Object deserialize(Document document, final Class targetClass)
            throws IllegalAccessException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException {
        final Object object;
        final Constructor constructor;
        final Object[] nullArr;

        constructor = targetClass.getConstructors()[0];
        nullArr = new Object[constructor.getParameterCount()];
        object = constructor.newInstance(nullArr);

        final Node item = document.getChildNodes().item(0);
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
        }
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
