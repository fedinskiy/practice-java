package calculators;

import consumer.Consumer;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Kvadrator extends BasicCalculator {
    private static volatile Consumer locked;

    @Override
    protected Consumer getLocker() {
        return locked;
    }

    @Override
    protected void setLocker(Consumer consumer) {
        locked=consumer;
    }

    public Kvadrator(Consumer consumer,int[] toCalc) {
        super(consumer,toCalc);
    }

    protected int getPower() {
        return 2;
    }

    public void toConsumer(Consumer consumer, int myValue) {
        consumer.message(0,myValue,0);
    }
}
