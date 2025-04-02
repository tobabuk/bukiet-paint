package bukiet.setup;

import bukiet.paint.PencilTool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Draw the buffered image to the screen
 */

public class DrawingComponent extends JComponent {
    private final BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

    private int startX = -1;
    private int startY = -1;
    private int endX = -1;
    private int endY = -1;
    private boolean isDrawingLine = true;
    private PencilTool tool = new PencilTool();


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

        if (isDrawingLine) {
            g.setColor(Color.DARK_GRAY);
            g.drawLine(startX, startY, endX, endY);
        }
    }

    //have to make this so that the mouse dragged doesnt follow all x and y coordinatat , instead want just start
    public void drawLine(int startX, int startY, int endX, int endY, Color currentColor) {
        Graphics g = image.getGraphics();
        g.setColor(currentColor);

        g.drawLine(startX, startY, endX, endY);
        g.dispose();
        repaint();
        this.startX = -1;
        this.startY = -1;
        this.endX = -1;
        this.endY = -1;
        isDrawingLine = true;


    }


    public void drawFromMouse(int x, int y, Color currentColor) {
        Graphics g = image.getGraphics();
        g.setColor(currentColor);
        tool.pressed(g, x, y);
        tool.dragged(g, x, y);
        tool.released(g, x, y);
    }

    public void endLineDrawing(int x, int y, Color currentColor) {
        if (isDrawingLine) {
            endX = x;
            endY = y;
            drawLine(startX, startY, endX, endY, currentColor);
        }
    }

    public void startPreview(int x, int y) {
        startX = x;
        startY = y;
        isDrawingLine = true;
        repaint();
    }

    public void endPreview(int x, int y) {
        endX = x;
        endY = y;
        repaint();
    }


}
