package bukiet.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EraserTool implements Tool {


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
        g.setColor(Color.white);
        this.x = x;
        this.y = y;
    }


    @Override
    public void dragged(Graphics2D g, int x, int y) {
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(35));
        g.setColor(Color.WHITE);
        g.drawLine(this.x, this.y, x, y);
        g.setStroke(oldStroke);
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
