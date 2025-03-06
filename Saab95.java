import java.awt.*;



public class Saab95 extends Car {


    private TurboState turboState;




    
    public Saab95(double x, double y)  {
        super( 2,125, Color.red, "Saab95",x,y);

        this.turboState = new StateTurboOff();

    }
    


    public void setTurboOn(){
	    turboState.setTurboOn(this);
    }

    public void setTurboOff(){
        turboState.setTurboOff(this);

    }
    void setTurboState(TurboState state) {
        this.turboState = state;
    }


    
    public double speedFactor(){

        return getEnginePower() * 0.01 * turboState.getTurboMulti();
    }


}
