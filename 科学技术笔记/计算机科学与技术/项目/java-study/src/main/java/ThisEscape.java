/**
 * Created by zlq on 3/17/17.
 */
public class ThisEscape {
    private String a = "abc";
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public String str = "";
            public void onEvent(Event event) {
                ThisEscape.this.a = "cccc";
                str = ThisEscape.this.a;
                System.out.println(ThisEscape.this.a);
                this.a = ThisEscape.this.a;
                this.thisEscape = ThisEscape.this;
            }
        });
    }
}
