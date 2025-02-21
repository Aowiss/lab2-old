import java.awt.*;
import java.util.ArrayDeque;
import java.util.Objects;

public class CarTransport extends Truck {






    private final int maxCars = 5;



    public int GetCargosize(){
        return cargo.size();
    }
    private ArrayDeque<Vehicle> cargo = new ArrayDeque<>();
    private final Platform platform;
    public CarTransport(){

        super(2, 300, Color.black, "CarTransport");
        canTransportmove();
        platform = new Platform();


    }

    @Override
    public double speedFactor() {
        return  getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void move() {
        super.move();
        stayWithTransport();
    }


    public void platformraise(){

        if(isMoving()){
            System.out.print("cant move platform if truck is moving");
            return;
        }
    }
    public void stayWithTransport(){


        for (Vehicle cars : cargo) {
            cars.SetX(this.GetX());
            cars.SetY(this.GetY());

            }




    }

    public void canTransportmove(){

        if (Objects.requireNonNull(platform.getPlatformState()) == PlatformState.DOWN) if (isMoving()) {
            System.out.println("Can't move with ramp down");

            return;

        }
    }

    boolean canLoad(Vehicle car){

        boolean loadable = false;
        if( (Objects.requireNonNull(platform.getPlatformState()) == PlatformState.DOWN) && cargo.size() < maxCars && withinRadius(car)) {
            loadable = true;
        }

        return loadable;
    }
    public void loadCar(Vehicle car){
        if(canLoad(car)){

            cargo.add(car);

        }
        stayWithTransport();



    }
    public Vehicle deLoadCar(Vehicle car) {

        if (!cargo.isEmpty() && canLoad(car)) {

            Vehicle unloadedcar = cargo.remove();

            System.out.println(unloadedcar + " has been unloaded");

            return unloadedcar;

        } else return null;

    }


    public void platformRaise() {

        if (isMoving()) {

            System.out.println("Cannot move platform if truck is moving!!");

            return;

        }
        platform.Raise(70);
    }




}

