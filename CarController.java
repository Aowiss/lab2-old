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
    private final Model m;

    public CarController(Model model) {
        this.m = model;
    }
    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    //CarView frame;
    // A list of cars, modify if needed

  //  ArrayList<Vehicle> cars = new ArrayList<>();

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


}
