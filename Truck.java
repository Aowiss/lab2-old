import java.awt.*;

public abstract class Truck extends Vehicle{


    private final double maxAngle = 70;
    private final double minAngle = 0;
    private double platformAngle = 0;
    private PlatformState platformState;
    private final int maxCars = 5;
    private static final double LOAD_DISTANCE = 5;


    Truck(int nrDoors,double enginePower, Color color, String modelName){
        super( nrDoors, enginePower, color,  modelName);

        platformState = PlatformState.DOWN;
        platformAngle = 0;

    }


      boolean withinRadius(Vehicle car){

        double distance = Math.sqrt(Math.pow(car.GetX() - GetX(), 2)) + Math.sqrt(Math.pow(car.GetY() - GetY(),2));
        return distance <= LOAD_DISTANCE;

    }


    public boolean isMoving() {
        boolean movedetect = false;

        if (getCurrentSpeed() > 0) {
            movedetect = true;

        }
        return movedetect;
    }


}
