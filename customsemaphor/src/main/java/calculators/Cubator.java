package calculators;

import consumer.Consumer;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Cubator extends BasicCalculator{
    private static volatile Consumer locked;
    public Cubator(Consumer consumer, int[] toCalc) {
        super(consumer,toCalc);
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
    protected int getPower(){
        return 3;
    }
    @Override
    public void toConsumer(Consumer consumer, int myValue) {
        consumer.message(myValue,0,0);
    }


}
