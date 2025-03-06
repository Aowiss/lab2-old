public class StateTurboOn implements TurboState {


    @Override
    public void setTurboOn(Saab95 saab) {
        System.out.println("Turbo is already ON");
    }

    @Override
    public void setTurboOff(Saab95 saab) {
        saab.setTurboState(new StateTurboOff());
        System.out.println("turbo is now OFF");

    }

    @Override
    public double getTurboMulti() {
        return 1.0;
    }
}
