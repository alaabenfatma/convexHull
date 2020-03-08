package utils;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class point{
    int x,y;
    point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class window extends JComponent{
    Dimension d = new Dimension();
    ArrayList<point> points = new ArrayList<point>();
    ArrayList<point> border = new ArrayList<point>();
    public window(){
        this.addMouseListener(new drawUtils(this));
    }
    @Override
    public void paintComponent(Graphics g){
        g = (Graphics2D)g;
        g.clearRect(0, 0, d.width, d.height);
        for (point p : points) {
            g.drawRect(p.x, p.y, 5, 5);
        }
    }
}