import java.util.ArrayList;
import java.util.Random;

public class CarFactory {


    String[] modelArray = {"Volvo240", "Saab95", "Scania"};

    Vehicle getRandom(){
        Random rand = new Random();
        String model = modelArray[rand.nextInt(modelArray.length)];
        double posX = rand.nextDouble(0, 500);
        double posY = rand.nextDouble(0,500);
        switch (model){
            case "Volvo240" ->{
                return createVolvo(posX,posY);

            }
            case "Saab95" -> {
                 return createSaab(posX,posY);

            }
            case "Scania" -> {
                return createScania(posX,posY);
            }
            default -> throw new IllegalStateException("Unexpected value: " + model);

        }

    }

    public Vehicle createVolvo(double x, double y){
        return new Volvo240(x,y);

    }
    public Vehicle createSaab(double x, double y){
        return new Saab95(x,y);
    }
    public Vehicle createScania(double x, double y){
        return new Scania(x,y);
    }
}
