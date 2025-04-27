package bukiet.paint;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EraserToolTest {

    private Graphics2D g = mock();
    private BufferedImage image ;
    private Color currentColor;
    @Test

    void pressed() {

        //given
        EraserTool tool = new EraserTool();

        //when
        tool.pressed(image, g, 50, 100, currentColor);
        //then
        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());


    }

    @Test

    void dragged() {
        //given
        EraserTool tool = new EraserTool();

        //when
        tool.pressed(image, g, 50, 100, currentColor);

        tool.dragged(g, 200, 150);
        //then
        assertEquals(200, tool.getX(), tool.getY());
        assertEquals(150, tool.getX(), tool.getY());


    }
}