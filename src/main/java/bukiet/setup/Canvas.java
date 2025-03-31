package bukiet.setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.event.ActionListener;


public class Canvas extends JFrame implements ActionListener {
    private final DrawingComponent draw = new DrawingComponent();
    private JButton colorButton;
    private JButton lineButton;
    private Color currentColor = Color.BLACK;
    private enum Mode {
        COLOR, LINE;
    }
    private Mode currentMode = Mode.COLOR;

    public Canvas() {
        setTitle("Paint Application");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        colorButton = new JButton("Choose Color");
        lineButton = new JButton("Line");
        colorButton.addActionListener(this);
        lineButton.addActionListener(this);

        panel.add(colorButton);
        panel.add(lineButton);
        add(panel, BorderLayout.EAST);
        add(draw, BorderLayout.CENTER);




        draw.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if (!currentMode.equals(Mode.LINE)) {
                    draw.drawFromMouse(event.getX(), event.getY(), currentColor);
                }
            }


            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });





        draw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (currentMode.equals(Mode.LINE)) {
                    draw.startLineDrawing(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentMode.equals(Mode.LINE)) {
                    draw.endLineDrawing(e.getX(), e.getY(), currentColor);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            Color color = JColorChooser.showDialog(this, "Pick a Color", currentColor);
            if (color != null) {
                currentColor = color;
            }
        } else if (e.getSource() == lineButton) {

            currentMode = Mode.LINE;
        }
    }



    public static void main(String[] args) {
        Canvas frame = new Canvas();
        frame.setVisible(true);


    }
}
