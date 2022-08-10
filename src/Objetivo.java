import java.awt.Color;
import java.awt.Graphics;

public class Objetivo {

    public void paint(Graphics graph){
        graph.setColor(Color.BLUE);
        graph.drawRect(935 - 95, 560 - 120, 40, 40);
        graph.fillRect(935 - 95, 560 - 120, 40, 40);
    }
    
}
