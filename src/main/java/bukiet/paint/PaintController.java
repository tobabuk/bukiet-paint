package bukiet.paint;

import bukiet.setup.DrawingComponent;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;


import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintController {

    private DrawingComponent canvas;
    private Color currentColor;
    private Tool tool;


    public PaintController(DrawingComponent canvas, Color currentColor, Tool tool) {
        this.canvas = canvas;
        this.currentColor = currentColor;
        this.tool = tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void mouseController() {

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(currentColor);
                tool.dragged(g, e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(currentColor);
                tool.pressed(g, e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(currentColor);
                tool.released(g, e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}




