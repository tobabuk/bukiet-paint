package bukiet.paint;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PencilToolTest {
    private Graphics2D g = mock();
    private BufferedImage image;
    private Color currentColor;
    @Test
    void pressed() {
        //given
        PencilTool tool = new PencilTool();


        //when
        tool.pressed(image, g, 50, 100, currentColor);
        //then

        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());
        verify(g).drawLine(50, 100, 50, 100);

    }

    @Test
    void dragged() {
        //given
        PencilTool tool = new PencilTool();
        tool.pressed(image, g, 50, 100, currentColor);
        //when
        tool.dragged(g, 200, 150);
        //then
        assertEquals(200, tool.getX());
        assertEquals(150, tool.getY());
        verify(g).drawLine(50, 100, 200, 150);

    }

    @Test
    void released() {
        //given
        PencilTool tool = new PencilTool();
        //when
        tool.released(g, 100, 200);
        //then
        verifyNoMoreInteractions(g);
    }
}