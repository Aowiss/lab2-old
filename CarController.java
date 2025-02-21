import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());;

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    CarWorkshop<Volvo240> vwc;


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

         cc.cars.add(new Volvo240(){{
             SetX(300);
             SetY(100);
         }});
         cc.cars.add(new Saab95());
         cc.cars.add(new Scania()  {{SetY(200);}});
         cc.vwc = new CarWorkshop<>();
         cc.vwc.setX(300);
         cc.vwc.setY(300);


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);



        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Vehicle> toRemove = new ArrayList<>();

            for (Vehicle car : cars) {
                car.move();

                int x = (int) Math.round(car.GetX());
                int y = (int) Math.round(car.GetY());
                if(x > 500 || y > 500 || x < 0 || y < 0 ){
                    car.turnLeft();
                    car.turnLeft();
                }

                if (car instanceof Volvo240 && vwc.withinRadius(car)){
                    vwc.addCar((Volvo240) car);
                    toRemove.add(car);

                    System.out.println("car taken");
                }



                frame.drawPanel.moveit(car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            cars.removeAll(toRemove);
        }
    }

    // Calls the gas method for each car once
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
}
