/**
 * Created by zlq on 3/17/17.
 */
public class EventSource {
    EventListener eventListener;
    public void registerListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void test() {
        this.eventListener.a = "b";
    }

}
