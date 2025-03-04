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
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

  //  ArrayList<Vehicle> cars = new ArrayList<>();
    CarWorkshop<Volvo240> vwc = new CarWorkshop<>();
    Saab95 saab = new Saab95();

    public void brake(int gasAmount) {
        m.brake(gasAmount);
    }
    public void gas(int gasAmount) {
        m.gas(gasAmount);
    }
    public void startEngine() {
        m.startEngine();
    }
    public void stopEngine(){
        m.stopEngine();
    }
    public void turboOn() {
        m.turboOn();
    }
    public void turboOff() {
        m.turboOff();
    }
    public void liftBed(int amount) {
        m.liftBed(amount);
    }
    public void lowerBed(int amount) {
        m.lowerBed(amount);
    }
    public void turnLeft() {
        m.turnLeft();
    }
    public void turnRight(){
        m.turnRight();
    }


    //methods:


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Vehicle> toRemove = new ArrayList<>();

            for (Vehicle car : m.cars) {
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
            m.cars.removeAll(toRemove);
        }
    }

    ActionListener getTimerListener() { return new TimerListener(); }

    private Model m = new Model();
    public Model getM(){
        return m;
    }


}
