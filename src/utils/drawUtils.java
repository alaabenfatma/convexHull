package utils;

import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

public class drawUtils extends MouseInputAdapter {
    window w;
    drawUtils(window _w){
        w = _w;
    }
    
    public void mouseClicked(MouseEvent e){
        w.repaint();
    }
}