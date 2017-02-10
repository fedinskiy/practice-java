package calculators;

import consumer.Consumer;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Unator extends BasicCalculator {
    private static volatile Consumer locked;

    public Unator(Consumer consumer, int[] toCalc) {
        super(consumer, toCalc);
    }

    @Override
    protected Consumer getLocker() {
        return locked;
    }

    @Override
    protected void setLocker(Consumer consumer) {
        locked=consumer;
    }
    @Override
    protected int getPower() {
        return 1;
    }

    @Override
    public void toConsumer(Consumer consumer, int myValue) {
        consumer.message(0,0,myValue);
    }
}
