import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {









    public static void main(String[] args) {



        // Instance of this class
        CarController cc = new CarController();

        cc.getM().cars.add(new Volvo240(){{
            SetX(300);
            SetY(100);
        }});

        cc.getM().cars.add(cc.saab);

        cc.getM().cars.add(new Scania()  {{SetY(200);}});
        cc.getM().workshops.add(cc.vwc);
        cc.vwc.setX(300);
        cc.vwc.setY(300);


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);



        // Start the timer
        cc.getM().start(cc.getTimerListener());
    }
}
