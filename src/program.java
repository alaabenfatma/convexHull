import utils.*;
import javax.swing.*;
public class program implements Runnable{
    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.add(new window());
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        program p = new program();
        p.run();
    }

    
}