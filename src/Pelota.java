import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

public class Pelota{
    Laberinto lab = new Laberinto();
    
    int [][] laberinto = lab.obtieneLaberinto();

    Random random = new Random();

    int randomY = random.nextInt(10 + 1) + 1;

    int x = 40, y = 40*randomY;

    int height = 40, width = 40, move = 40;

    public void paint(Graphics graph)
    {
        graph.setColor(Color.red);
        graph.fillOval(x, y, width, height);
        graph.setColor(Color.red);
        graph.drawOval(x, y, width, height);
    }

    public void presionarTecla(KeyEvent press)
    {

        /* Movimiento hacia arriba */
        if(press.getKeyCode() == 38)
        {
            while(laberinto[y/40-1][(x/40)] != 1)
            {
                y = y - move;                
            }
        }
        
        /* Movimiento hacia abajo */
        if(press.getKeyCode() == 40)
        {
            while(laberinto[y/40+1][(x/40)] != 1)
            {
                y = y + move;
            }
        }

        /* Movimiento hacia izquierda */
        if(press.getKeyCode() == 37)
        {
            while(laberinto[y/40][(x/40)-1] != 1)
            {
                x = x - move;
            }
        }

        /* Movimiento hacia derecha */
        if(press.getKeyCode() == 39)
        {
            while(laberinto[y/40][(x/40)+1] != 1)
            {
                x = x + move;
            }
        }

        if(x==840 && y==440)
        {
            JOptionPane.showMessageDialog(null, "Fin del juego!");
            System.exit(0);
        }
    }

}
