package bukiet.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BucketFillTool implements Tool {
    private int x;
    private int y;
    private int originalColor;
    private Color fillColor;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y, Color currentColor) {
        int originalColor = image.getRGB(x, y);
        if (originalColor == currentColor.getRGB())
        { return; }
        fill(image, x, y, originalColor, currentColor.getRGB());
    }

    private void fill(BufferedImage image, int x, int y, int originalColor, int newColor) {
        if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight())
        { return; }
        if (image.getRGB(x, y) != originalColor)
        { return; }

        image.setRGB(x, y, newColor);

        fill(image, x + 1, y, originalColor, newColor);
        fill(image, x - 1, y, originalColor, newColor);
        fill(image, x, y + 1, originalColor, newColor);
        fill(image, x, y - 1, originalColor, newColor);
    }



    @Override
    public void dragged(Graphics2D g, int x, int y) {
        //empty
    }

    @Override
    public void released(Graphics2D g, int x, int y) {
        //verify no action
    }

    @Override
    public void preview(Graphics2D g) {
        //empty
    }
}
