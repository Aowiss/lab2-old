public class Platform {

    private final double maxAngle = 70;
    private final double minAngle = 0;
    private double platformAngle = 0;
    private PlatformState platformState;



    public PlatformState getPlatformState() {
        return platformState;
    }


    public double getAngle(){

        return platformAngle;
    }


    public double getMaxAngle(){
        return maxAngle;
    }

    public double getMinAngle(){
        return minAngle;
    }
    public void Raise(double amount){

        if (platformAngle > maxAngle){
            System.out.println("Cannot move past the angle limit");
            platformAngle = maxAngle;
        }

        else platformAngle += amount;

    }
    public void lower(double amount){
        if(platformAngle < minAngle){
            System.out.println("Cannot move past the angle limit");
            platformAngle = minAngle;
        }
        else platformAngle -=amount;
    }

    public void Platformcheck(){
        if(platformAngle > minAngle){
            platformState = PlatformState.UP;
        }
        else if (platformAngle == minAngle){
            platformState = PlatformState.DOWN;
        }

    }
}
