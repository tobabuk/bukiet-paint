package bukiet.paint;

import java.awt.*;

public class EraserTool implements Tool {

    private int x;
    private int y;
    int size = 15;


    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public void pressed(Graphics g, int x, int y) {
        g.setColor(Color.white);
        this.x = x;
        this.y = y;
        g.fillRect(x - size / 2, y - size / 2, size, size);
    }

    @Override
    public void dragged(Graphics g, int x, int y) {
        g.setColor(Color.white);
        g.fillRect(x - size / 2, y - size / 2, size, size);
        this.x = x;
        this.y = y;
    }

    @Override
    public void released(Graphics g, int x, int y) {

    }

    @Override
    public void preview(Graphics g) {

    }
}
