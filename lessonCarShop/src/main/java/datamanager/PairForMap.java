package datamanager;

import java.io.Serializable;

/**
 * Created by sa on 08.02.17.
 */
public class PairForMap implements Serializable{
    private Serializable key;
    private Serializable value;

    public Serializable getKey() {
        return key;
    }

    public void setKey(Serializable key) {
        this.key = key;
    }

    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }

    public PairForMap(Serializable key, Serializable value) {

        this.key = key;
        this.value = value;
    }
}
