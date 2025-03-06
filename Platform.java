public class Platform implements MovablePlatform{

    private final double maxAngle = 70;
    private final double minAngle = 0;
    private double platformAngle = 0;
    private PlatState platformState;






    public double getAngle(){

        return platformAngle;
    }
    public void setAngle(double angle){
        this.platformAngle = angle;


    }

    public void setState(PlatState newState){
        this.platformState = newState;
    }



    public Platform(){


        this.platformState = new DownState();
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
        Platformcheck();

    }
    public void lower(double amount){
        if(platformAngle < minAngle){
            System.out.println("Cannot move past the angle limit");
            platformAngle = minAngle;
        }
        else platformAngle -=amount;

        Platformcheck();
    }

    public void Platformcheck(){
        if(platformAngle > minAngle){
            platformState = new UpState();
        }
        else if (platformAngle == minAngle){
            platformState = new DownState();
        }
        }




}
