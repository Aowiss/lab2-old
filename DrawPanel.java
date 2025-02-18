import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * DrawPanel is responsible for rendering the cars on the screen.
 * It dynamically supports multiple car types and updates their positions.
 */
public class DrawPanel extends JPanel {
    private List<Car> cars; // List of cars to be drawn
    private Image volvoImage;
    private Image saabImage;
    private Image scaniaImage;

    /**
     * Constructor initializes the panel and loads car images.
     * @param width Width of the panel.
     * @param height Height of the panel.
     * @param cars List of cars to be drawn.
     */
    public DrawPanel(int width, int height, List<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.green);
        this.cars = cars;

        // Load images for different car types
        volvoImage = new ImageIcon("pics/Volvo240.jpg").getImage();
        saabImage = new ImageIcon("pics/Saab95.jpg").getImage();
        scaniaImage = new ImageIcon("pics/Scania.jpg").getImage();
    }

    /**
     * Paints all cars on the panel at their respective positions.
     * @param g Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars) {
            Image carImage = getCarImage(car);
            if (carImage != null) {
                g.drawImage(carImage, (int) car.getX(), (int) car.getY(), null);
            }
        }
    }

    /**
     * Returns the correct image for the given car type.
     * @param car The car whose image is needed.
     * @return The corresponding Image object, or null if no match is found.
     */
    private Image getCarImage(Car car) {
        if (car instanceof Volvo240) return volvoImage;
        if (car instanceof Saab95) return saabImage;
        if (car instanceof Scania) return scaniaImage;
        return null;
    }
}
