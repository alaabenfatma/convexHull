package utils;

import java.util.Random;

import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;

public class drawUtils extends MouseAdapter {
    window w;
    Random r = new Random();
    drawUtils(window _w){
        w = _w;
    }
    
    public void mouseClicked(MouseEvent e){
        w.points.add(new point(e.getX(),e.getY()));
        System.out.println(e.getX()+" "+e.getY());
        w.repaint();
    }
}