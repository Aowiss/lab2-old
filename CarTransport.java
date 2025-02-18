import java.awt.*;
import java.util.ArrayDeque;
import java.util.Objects;

public class CarTransport extends Truck {




    public void setX(double x){

        super.setX(x);

        stayWithTransport();
    }

    public void setY(double y){
        super.setY(y);
        stayWithTransport();
    }

    private final int maxCars = 5;



    public int GetCargosize(){
        return cargo.size();
    }
    private ArrayDeque<Car> cargo = new ArrayDeque<>();
    private final Platform platform;
    public CarTransport(){

        super(2, 300, Color.black, "CarTransport");
        canTransportmove();
        platform = new Platform();


    }

    @Override
    public void move() {
        super.move();
        stayWithTransport();
    }


    public void platformraise(){

        if(isMoving()){
            System.out.print("cant move platform if truck is moving");
            currentSpeed = 0;
        }
    }
    public void stayWithTransport(){


        for (Car cars : cargo) {
            cars.SetX(this.GetX());
            cars.SetY(this.GetY());

            }




    }

    public void canTransportmove(){

        if (Objects.requireNonNull(platform.getPlatformState()) == PlatformState.DOWN) if (isMoving()) {
            System.out.println("Can't move with ramp down");

            currentSpeed = 0;

        }
    }

    boolean canLoad(Car car){

        boolean loadable = false;
        if( (Objects.requireNonNull(platform.getPlatformState()) == PlatformState.DOWN) && cargo.size() < maxCars && withinRadius(car)) {
            loadable = true;
        }

        return loadable;
    }
    public void loadCar(Car car){
        if(canLoad(car)){

            cargo.add(car);

        }
        stayWithTransport();



    }
    public Car deLoadCar(Car car) {

        if (!cargo.isEmpty() && canLoad(car)) {

            Car unloadedcar = cargo.remove();

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

