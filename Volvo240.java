import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(double x, double y) {

        super( 4,100, Color.black, "Volvo240",x,y);
        stopEngine();
    }
    

    
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}
