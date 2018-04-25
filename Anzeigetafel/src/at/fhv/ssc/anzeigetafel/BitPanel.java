package at.fhv.ssc.anzeigetafel;
import java.awt.*;

public class BitPanel extends Panel {
    public BitPanel() {
        setSize(100,100);
        add(new BitCanvas());
    }


}
