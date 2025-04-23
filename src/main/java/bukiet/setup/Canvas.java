package bukiet.setup;

import bukiet.paint.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Canvas extends JFrame implements ActionListener {

    private final DrawingComponent canvas = new DrawingComponent();
    private JButton colorButton;
    private JButton lineButton;
    private JButton penButton;
    private JButton eraserButton;
    private Color currentColor = Color.BLACK;
    private Tool tool = new LineTool();
    private PaintController controller;

    public Canvas() {

        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        colorButton = new JButton("Choose Color");
        lineButton = new JButton("Line");
        penButton = new JButton("Pen");
        eraserButton = new JButton("Eraser");
        colorButton.addActionListener(this);
        lineButton.addActionListener(this);
        penButton.addActionListener(this);
        eraserButton.addActionListener(this);
        panel.add(colorButton);
        panel.add(penButton);
        panel.add(lineButton);
        panel.add(eraserButton);
        add(panel, BorderLayout.EAST);
        add(canvas, BorderLayout.CENTER);

        canvas.setTool(tool);


        controller = new PaintController(canvas, currentColor, tool);
        controller.mouseController();

    }

    public static void main(String[] args) {
        new Canvas().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            Color color = JColorChooser.showDialog(this, "Pick a Color", currentColor);
            if (color != null) {
                currentColor = color;
                controller.setCurrentColor(color);
            }
        } else if (e.getSource() == lineButton) {
            tool = new LineTool();
            controller.setTool(tool);
        } else if (e.getSource() == penButton) {
            tool = new PencilTool();
            controller.setTool(tool);
        } else if (e.getSource() == eraserButton) {
            tool = new EraserTool();
            controller.setTool(tool);
        }
    }
}