package utils;

import java.util.Random;

import java.awt.event.*;

class mouseUtils extends MouseAdapter {
    window w;
 
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
    Random r = new Random();

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
            
                this.w.hullfinder.findHull();
                this.w.repaint();
        }
        //Experimental
        else if (evt.getKeyChar() =='r') {
            for (int i = 0; i < r.nextInt(100); i++) {
                int x=r.nextInt(500),y=r.nextInt(500);
                w.points.add(new point(x,y));
                System.out.println(x+" "+y);
           
            }   
              w.repaint();
        }
    }
}