package bukiet.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PencilTool implements Tool {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y, Color currentColor) {
      this.x = x;
      this.y = y;
      g.drawLine(x, y, x, y);

    }

    @Override
    public void dragged(Graphics2D g, int x, int y) {
        g.drawLine(this.x, this.y, x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void released(Graphics2D g, int x, int y) {

    }

    @Override
    public void preview(Graphics2D g) {

    }
}
