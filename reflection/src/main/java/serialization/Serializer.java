package serialization;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Serializer {

    private static String ATTRIBUTE_NAME_FIELD_NAME = "id";
    private static String ATTRIBUTE_NAME_FIELD_TYPE = "type";
    private static String ATTRIBUTE_NAME_FIELD_VALUE = "value";

    public static Document serialize(Object obj, Document document) throws IllegalAccessException {
        final Field[] fields;
        final Class oclass = obj.getClass();
        final Element person;
        Element personInfo;

        fields = oclass.getDeclaredFields();

        person = document.createElement("Object");
        person.setAttribute(ATTRIBUTE_NAME_FIELD_TYPE, oclass.getName());
        document.setXmlStandalone(false);
        document.appendChild(person);
        for (Field field : fields) {
            field.setAccessible(true);
            personInfo = document.createElement("field");
            personInfo.setAttribute(ATTRIBUTE_NAME_FIELD_TYPE,
                    field.getType().getSimpleName());
            personInfo.setAttribute(ATTRIBUTE_NAME_FIELD_NAME, field.getName());
            personInfo.setAttribute(ATTRIBUTE_NAME_FIELD_VALUE, field.get(obj).toString());
            person.appendChild(personInfo);
        }
        return document;
    }

    public static Object deserialize(Document document, final Class targetClass)
            throws IllegalAccessException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {
        final Object object;
        final Constructor constructor;
        final Object[] nullArr;

        constructor = targetClass.getConstructors()[0];
        if (0 == constructor.getParameterCount()) {
            object = constructor.newInstance();
        } else {
            nullArr = new Object[constructor.getParameterCount()];
            object = constructor.newInstance(nullArr);
        }

        final Node item = document.getChildNodes().item(0);
        for (int i = 0; i < item.getChildNodes().getLength(); ++i) {
            final NamedNodeMap fieldParams = item.getChildNodes().item(i)
                    .getAttributes();
            final Field field = targetClass.getDeclaredField(fieldParams
                    .getNamedItem(ATTRIBUTE_NAME_FIELD_NAME)
                    .getNodeValue());
            field.setAccessible(true);
            field.set(object, castValue(
                    fieldParams.getNamedItem(ATTRIBUTE_NAME_FIELD_TYPE)
                            .getNodeValue(),
                    fieldParams.getNamedItem(ATTRIBUTE_NAME_FIELD_VALUE)
                            .getNodeValue()));
        }
        return object;
    }

    private static Object castValue(String type, String value)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        final Method method;
        final String CLASS_PREFIX = "java.lang.";
        final String GET_VALUES_METHOD = "valueOf";

        Class<?> castClass;
        Object castedValue = null;

        try {
            castClass = Class.forName(type);
        } catch (ClassNotFoundException e) {
            castClass = Class.forName(CLASS_PREFIX + type);
        }

        try {
            castedValue = castClass.cast(value);
        } catch (ClassCastException ex) {
            method = castClass.getMethod(GET_VALUES_METHOD, String.class);
            castedValue = method.invoke(castClass, value);
        }

        return castedValue;
    }
}
