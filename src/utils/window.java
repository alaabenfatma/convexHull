package utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class point {
    int x, y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class window extends JComponent {
    Dimension d = new Dimension();
    ArrayList<point> points = new ArrayList<point>();
    ArrayList<point> border = new ArrayList<point>();
    hullFinder hullfinder;

    public window() {

        this.addMouseListener(new mouseUtils(this));
        this.addKeyListener(new keyUtils(this));
        hullfinder = new hullFinder(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        g = (Graphics2D) g;
        g.clearRect(0, 0, d.width, d.height);
        for (point p : points) {
            g.drawRect(p.x, p.y, 5, 5);
        }
        if(!border.isEmpty()){
            int i = 0;
            for (i = 0; i < border.size()-1; i++) {
                g.drawLine(border.get(i).x, border.get(i).y,border.get(i+1).x, border.get(i+1).y);
            }
            g.drawLine(border.get(i).x, border.get(i).y,border.get(0).x, border.get(0).y);
        }
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
}