package serializer;

import java.lang.reflect.Field;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Serializer {
    private Document document;

    public Serializer(Document document) {
        this.document = document;
    }

    public void serialize(Object obj) throws IllegalAccessException {
        final Field[] fields;

        Class oclass = obj.getClass();

        fields = oclass.getFields();
        final Element person = document.createElement("Person");
        for(Field field:fields){
           person.setAttribute(field.getName(),field.get(obj).toString());
        }
    }
}
