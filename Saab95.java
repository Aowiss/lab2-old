import java.awt.*;



public class Saab95 extends Car {

    public boolean turboOn;





    
    public Saab95(double x, double y)  {
        super( 2,125, Color.red, "Saab95",x,y);
	    turboOn = false;
        stopEngine();


    }
    


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }


    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
