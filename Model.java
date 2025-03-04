import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Model {


    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<CarWorkshop> workshops = new ArrayList<>();

    private static final int delay = 50;

    private Timer timer;

    public void start(ActionListener timerListener){
        timer = new Timer(delay, timerListener);
        timer.start();
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }


    void brake(int amount){
        double brake = ((double) amount) /100;
        for (Vehicle car : cars){
            car.brake(brake);
        }

    }
    void turboOn(){
        for(Vehicle car: cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turboOff(){
        for(Vehicle car: cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void lowerBed(int amount){

        for(Vehicle car: cars){
            if(car instanceof Scania){
                ((Scania) car).platformLower( amount);
            }
        }
    }
    void liftBed(int amount){
        for(Vehicle car: cars){
            if(car instanceof Scania){
                ((Scania) car).platformRaise( amount);

            }
        }
    }

    void startEngine(){
        for(Vehicle car: cars){
            car.startEngine();
        }
    }
    void stopEngine(){
        for(Vehicle car: cars){
            car.stopEngine();
        }
    }
    void turnLeft(){
        for(Vehicle car: cars){
            car.turnLeft();
        }
    }
    void turnRight(){
        for(Vehicle car: cars){
            car.turnRight();
        }
    }
}
