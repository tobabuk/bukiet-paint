package bukiet.setup;

import bukiet.paint.PencilTool;
import bukiet.paint.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Draw the buffered image to the screen
 */

public class DrawingComponent extends JComponent {
    private final BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

    private Tool tool;


    public DrawingComponent() {
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());

    }


    public BufferedImage getImage() {
        return image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        Graphics2D g2= (Graphics2D) g;
                tool.preview(g2);
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

}



