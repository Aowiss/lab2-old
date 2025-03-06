import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private Map<String, BufferedImage> vehicleImages = new HashMap<>();

public void removeVehicleImage(Vehicle car){
    boolean modelRemains = true;

    if (!modelRemains){
        vehicleImages.remove(car.getModelName());
    }
}
    // Map to store car positions
    private Map<Vehicle, Point> carPositions = new HashMap<>();




    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    void moveit(Vehicle car){
        carPositions.put(car, new Point((int) car.GetX(), (int) car.GetY()));

    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File(pic/"Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
           vehicleImages.put("Volvo240", ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("/pics/Volvo240.jpg"))));
           vehicleImages.put("Saab95", ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("/pics/Saab95.jpg"))));
           vehicleImages.put("Scania", ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("/pics/Scania.jpg"))));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (var entry : carPositions.entrySet()) {
            Vehicle vehicle = entry.getKey();
           Point carPosition = entry.getValue();

            BufferedImage image = vehicleImages.get(vehicle.getModelName());

            if(image != null){
                g.drawImage(image, carPosition.x, carPosition.y, null);
            }

        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}

