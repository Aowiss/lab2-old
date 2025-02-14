import java.awt.*;

public class Scania extends Truck {


    public Scania() {
        super(3, 150, Color.white, "Scania");

        isMoving();

    }


    public void isPlatformraised(){
        if (getAngle() > 0 && currentSpeed > 0){

            System.out.println("Cannot drive with the platform raised!!");
            currentSpeed = 0;
        }
    }
   ;


}