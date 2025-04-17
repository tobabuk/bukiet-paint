package bukiet.paint;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
class EraserToolTest {
    private Graphics g = mock();
    @Test

    void pressed() {

        //given
        EraserTool tool = new EraserTool();

        //when
        tool.pressed(g, 50, 100);
        //then
        assertEquals(50, tool.getX(), tool.getY());
        verify(g).fillRect(43, 93, tool.getSize(), tool.getSize());

    }

    @Test

    void dragged(){
        //given
        EraserTool tool = new EraserTool();

        //when
        tool.pressed(g, 50, 100);

        tool.dragged(g, 200, 150);
        //then
        assertEquals(200, tool.getX(), tool.getY());
        assertEquals(150, tool.getX(), tool.getY());
        verify(g).fillRect(43, 93, tool.getSize(), tool.getSize());

    }
}