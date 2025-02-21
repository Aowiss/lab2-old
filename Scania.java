import java.awt.*;

public class Scania extends Truck {


    private final Platform platform;

    public double getAngle(){

        return platform.getAngle();
    }
    public Scania() {
        super(3, 150, Color.white, "Scania");

        isMoving();
        platform = new Platform();

    }

    public void platformRaise(int amount){
        if(isMoving()){
            System.out.println("cannot move platform if truck is moving");

            return;
        }

        platform.Raise(amount);

    }


    public void platformLower(int amount){
        if(isMoving()){
            System.out.println("cannot move platform if truck is moving");

            return;
        }


        platform.lower(amount);

    }

    public void isPlatformraised(){
        if (platform.getAngle() > 0 && getCurrentSpeed() > 0){

            System.out.println("Cannot drive with the platform raised!!");
            return;
        }
    }

    @Override
    public double speedFactor() {
        return  getEnginePower() * 0.01 * trimFactor;
    }

    ;


}