public class UpState implements PlatState{

    @Override
    public void raise(Platform platform, double amount) {
        double newAngle = platform.getAngle() + amount;
        if(newAngle> platform.getMaxAngle()){
            newAngle = platform.getMaxAngle();
            System.out.println("cant move past angle limit");
        }
        platform.setAngle(newAngle);
    }

    @Override
    public void lower(Platform platform, double amount) {

        double newAngle = platform.getAngle() - amount;
        if(newAngle < platform.getMinAngle()){
            newAngle = platform.getMinAngle();
            System.out.println("Cant move past angle limit");
            platform.setState(new DownState());
        }

        platform.setAngle(newAngle);
    }
}
