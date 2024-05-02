package practicalEight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringBall extends JPanel {
    int xPos = 0;
    int yPos = 0;
    int ballRadius = 10;
    int panelSize = 300;

    public StringBall(){
        setPreferredSize(new Dimension(100, 100));
    }

}
