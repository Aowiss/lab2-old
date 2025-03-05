public class CarFactory {





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
