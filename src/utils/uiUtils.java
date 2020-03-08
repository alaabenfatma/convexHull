package utils;

import java.util.Random;

import java.awt.event.*;

class mouseUtils extends MouseAdapter {
    window w;
    Random r = new Random();

    mouseUtils(window _w) {
        w = _w;
    }

    public void mouseClicked(MouseEvent e) {
        w.points.add(new point(e.getX(), e.getY()));
        System.out.println(e.getX() + " " + e.getY());
        w.repaint();
    }
}

class keyUtils extends KeyAdapter {
    window w;
    keyUtils(window _w) {
        this.w = _w;
    }

    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.w.points.clear();
            this.w.border.clear();
            this.w.repaint();
            System.out.println("All points have been deleted.");
        }
        else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                this.w.hullfinder.findHull();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            
        }
    }
}