import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    ArrayList<Vehicle> cars = new ArrayList<>();
    CarWorkshop<Volvo240> workShop = new CarWorkshop<>();
    ArrayList<ObserverListener> Listeners = new ArrayList<>();
    CarFactory factory = new CarFactory();
    private final Timer timer;
    private final int DELAY = 50;


    DrawPanel panel = new DrawPanel(500,500);






    private class Loop implements ActionListener {


        @Override
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


                if(addToWorkshop(car)){
                    toRemove.add(car);
                }

                notifyListeners(car);
            }
            cars.removeAll(toRemove);
        }
    }
        public Model(){

        workShop.setX(300);
        workShop.setY(300);

        cars.add(factory.createVolvo(200,300));

        cars.add(factory.createSaab(0,200));
        cars.add(factory.createScania(0,300));
        timer = new Timer(DELAY, new Loop());

    }

    public void addListener(ObserverListener listener){
        Listeners.add(listener);

    }
    void addCar(){
        int maxCars = 10;

        if(cars.size()>= maxCars){
            System.out.println("Car limit reached");
            return;
        }
           cars.add( factory.getRandom());


    }


    void removeCar(){

        if(!cars.isEmpty()){
            Vehicle removedCar = cars.removeLast();

            panel.removeVehicleImage(removedCar);
            panel.repaint();
        }


    }

    void start(){
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

    boolean addToWorkshop(Vehicle v) {
         if (v instanceof Volvo240 && workShop.withinRadius(v)){
             workShop.addCar((Volvo240) v);
             return true;

         }
         return false;
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
                ((Scania) car).lower( amount);
            }
        }
    }

    void liftBed(int amount){
        for(Vehicle car: cars){
            if(car instanceof Scania){
                ((Scania) car).Raise( amount);

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
    void notifyListeners(Vehicle car){
        for(ObserverListener listener: Listeners){
            listener.update(car);
        }
    }
}
