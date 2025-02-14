import java.util.ArrayList;
import java.util.List;

public class CarWorkshop <T extends Car> {
    public List<T> Cars = new ArrayList<>();
    private final int maxCars = 5;

    public void addCar(T car){

        if(Cars.size() < maxCars){

            Cars.add(car);

            System.out.println("Car has been put in the workshop");

        }

        else{
            System.out.println("Workshop is full at the moment");
        }
    }

    public void removeCar(T car){

        if(!Cars.isEmpty()){
            Car retrievedcar = Cars.removeFirst();
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
