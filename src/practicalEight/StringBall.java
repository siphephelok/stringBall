package practicalEight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringBall extends JPanel {
    int xPos = 0;
    int yPos = 0;
    int ballRadius = 10;
    int panelSize = 300;
    Color color = Color.red;
    boolean reversing = false;
    boolean moving = true;
    int i = 0;
    Timer timer;
    int updatePos = 1;

    public StringBall(){
        this.setLayout(new BorderLayout());
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xPos + updatePos > panelSize - 2 * ballRadius){
                    reversing = true;
                } else if (xPos - updatePos < 0) {
                    reversing = false;
                }
                if (moving){
                    if(!reversing){
                        xPos += updatePos;
                        yPos +=updatePos;
                    }else {
                        xPos -= updatePos;
                        yPos -= updatePos;
                    }
                }
                repaint();
            }
        });
        setPreferredSize(new Dimension(panelSize, panelSize));
        timer.start();
        this.setVisible(true);

        RepaintKeyListener keyListener = new RepaintKeyListener();
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    private class RepaintKeyListener extends KeyAdapter{
        int xPos = 0;

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                moving = !moving;
                System.out.println(moving);
            }
        }
    }
    public void paintComponent(Graphics g){
        int yOffset = 0;
        super.paintComponent(g);
        this.setBackground(Color.BLUE);
        String words = "Ball on a string";
        g.setColor(Color.PINK);
        FontMetrics fontMetrics = g.getFontMetrics();
        g.drawString(words, (this.getWidth() - fontMetrics.stringWidth(words)) / 2, yOffset);

        g.setColor(Color.white);
        g.drawLine(0, 0, panelSize, panelSize);

        g.setColor(Color.green);
        g.drawRect(xPos, yPos, ballRadius * 2, ballRadius * 2);
        g.setColor(Color.red);
        g.fillOval(xPos,yPos, ballRadius * 2, ballRadius * 2);
    }
}
