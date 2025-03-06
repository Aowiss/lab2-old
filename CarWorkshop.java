import java.util.ArrayList;
import java.util.List;

public class CarWorkshop <T extends Vehicle> {
    public List<T> Cars = new ArrayList<>();
    private final int maxCars = 5;




    private double x;
    private double y;
    public void addCar(T car){

        if(Cars.size() < maxCars){

            Cars.add(car);

            System.out.println("Car has been put in the workshop");

        }

        else{
            System.out.println("Workshop is full at the moment");
        }
    }

    private final int LOAD_DISTANCE = 50;

    boolean withinRadius(Vehicle car){
        double distance = Math.sqrt(Math.pow(x-car.GetX(), 2) + Math.pow(y-car.GetY(),2));
        return distance <= LOAD_DISTANCE;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void removeCar(T car){

        if(!Cars.isEmpty()){
            Vehicle retrievedcar = Cars.removeFirst();
            System.out.println(retrievedcar + "has been retrieved");
        }

        else {
            throw new IllegalArgumentException("Workshop is empty, can't remove any car");
        }
    }

    public int getMaxCars() {
        return maxCars;
    }

}
