import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {
    static private final String FRAME_NAME = "CarSim 1.0";
    private final Model m;
    private final CarController c;
    private final CarView v;

    public App() {
        this.m = new Model();
        this.c = new CarController(m);
        this.v = new CarView(FRAME_NAME, c);
        m.addListener(v);
        m.start();
    }




    public static void main(String[] args) {
        App carSimApp = new App();
    }
}
