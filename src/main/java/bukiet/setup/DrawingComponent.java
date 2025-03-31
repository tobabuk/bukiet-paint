package bukiet.setup;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;



public class DrawingComponent extends JComponent {
    private final BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

    public  DrawingComponent() {
        Graphics g = image.getGraphics();
       g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    private int oldX = -1;
    private int oldY = -1;
    private int startX = -1;
    private int startY = -1;
    private int endX = -1;
    private int endY = -1;
boolean isDrawingLine = true;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
//have to make this so that the mouse dragged doesnt follow all x and y coordinatat , instead want just start
public void drawLine(int startX, int startY, int endX, int endY,  Color currentColor){
    Graphics g = image.getGraphics();
    g.setColor(currentColor);
    g.drawLine(startX, startY, endX, endY);

    g.dispose();
    repaint();
    this.startX = -1;
    this.startY = -1;
    this.endX = -1;
    this.endY = -1;
    isDrawingLine = false;

}

    public void drawFromMouse(int x, int y, Color currentColor) {
        Graphics g = image.getGraphics();
        g.setColor(currentColor);
        if (oldX != -1 && oldY != -1) {
            g.drawLine(oldX, oldY, x, y);

        }
        oldX = x;
        oldY = y;

        g.dispose();
        repaint();
    }

    public void startLineDrawing(int x, int y) {
        startX = x;
        startY = y;
        isDrawingLine = true;
    }

    // Set the end point and draw the line
    public void endLineDrawing(int x, int y, Color currentColor) {
        if (isDrawingLine) {
            endX = x;
            endY = y;
            drawLine(startX, startY, endX, endY, currentColor);
        }
    }

    // Reset scribble state
    public void resetScribble() {
        oldX = -1;
        oldY = -1;
    }

}
