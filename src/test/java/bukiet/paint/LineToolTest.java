package bukiet.paint;

import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LineToolTest {

        private Graphics g = mock();

        @Test
        void pressed() {
            //given
            LineTool tool = new LineTool();


            //when
            tool.pressed(g, 50, 100);
            //then

            assertEquals(50, tool.getX1(), tool.getY1());

        }

        @Test
        void dragged() {
            //given
            LineTool tool = new LineTool();
            tool.pressed(g, 50, 100);
            //when
            tool.dragged(g, 200, 150);
            //then
            assertEquals(50, tool.getX1(), tool.getY1());
            assertEquals(200, tool.getX2(), tool.getY2());

        }

        @Test
        void released() {
            //given
            LineTool tool = new LineTool();
            //when
            tool.pressed(g, 50, 100);
            tool.dragged(g, 200, 150);
            tool.released(g, 100, 200);
            //then
            verify(g).drawLine(50, 100, 200, 150);
        }
    }

