public class StateTurboOff implements TurboState{
    @Override
    public void setTurboOn(Saab95 saab) {
        saab.setTurboState(new StateTurboOn());
        System.out.println("Turbo is now ON");
    }

    @Override
    public void setTurboOff(Saab95 saab) {
        System.out.println("Turbo is already OFF");

    }

    @Override
    public double getTurboMulti() {
        return 1.3;
    }
}
