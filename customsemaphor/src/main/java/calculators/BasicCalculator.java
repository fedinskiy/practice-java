package calculators;

import consumer.Consumer;

/**
 * Created by fedinskiy on 10.02.17.
 */
public abstract class BasicCalculator implements Runnable{
    private final int[] values;

    private Consumer consumer;

    public BasicCalculator(Consumer consumer,int[] toCalc) {
        this.consumer=consumer;
        values=toCalc;

    }
    protected abstract Consumer getLocker();

    protected abstract void setLocker(Consumer consumer);

    protected abstract int getPower();


    public abstract void toConsumer(Consumer consumer, int i);

    @Override
    public void run() {
        for(int i:this.values){
            while (true) {
                if (consumer != this.getLocker()) {
                    this.setLocker(consumer);
                    break;
                }
            }
            this.toConsumer(consumer, (int) Math.pow(i,this.getPower()));
            this.setLocker(null);
        }
    }
}
