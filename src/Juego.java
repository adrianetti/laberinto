/* 
Codigo creado por Adrian Ambrosetti C.I.: V27462249
Asignatura: PROGRAMACIÓN I (0416202) LAPSO 2022-1
UNIVERSIDAD NACIONAL EXPERIMENTAL DEL TÁCHIRA
*/


/* Imports */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.text.DecimalFormat;


/* Juego */
public class Juego extends JPanel{
    Laberinto laberinto = new Laberinto();
    Pelota pelota = new Pelota();
    Objetivo objetivo = new Objetivo();

    static Timer timer;	
	static int second;
    static int minute;
	static String ddSecond;
    static String ddMinute;	
	static DecimalFormat dFormat = new DecimalFormat("00");    
    static JLabel counterLabel;

    public static int nivel = 1;

    public Juego(){
        addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                pelota.presionarTecla(e);                                
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        setFocusable(true);
    }

    @Override
    public void paint(Graphics graph)
    {
        laberinto.paint(graph);
        pelota.paint(graph);
        objetivo.paint(graph);
    }
    public static void main(String[] args) throws Exception {
        JFrame ventana = new JFrame("Laberinto, Parcial 2");

        Juego juego = new Juego();
        counterLabel = new JLabel("");
        counterLabel.setText("05:00");
		second =0;
		minute =5;
		countdownTimer();
		timer.start();

        ventana.getContentPane().add(juego, BorderLayout.CENTER);
        ventana.getContentPane().add(counterLabel, BorderLayout.EAST);
        
        ventana.setSize(1000, 560);

        ventana.setLocationRelativeTo(null);

        ventana.setVisible(true);

        ventana.setResizable(false);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            try {
                Thread.sleep(20);
                
            } catch(InterruptedException ex) {
            }

            ventana.repaint();
   
        }
    }

    /* Temporizador */

    public static void countdownTimer() {
		
        timer = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);	
                counterLabel.setText(ddMinute + ":" + ddSecond);
                
                if(second==-1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);	
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }
                if(minute==0 && second==0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Fin del juego!");
                    System.exit(0);
                }
            }
        });		
    }	
}
