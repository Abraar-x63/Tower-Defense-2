import java.awt.event.*;
import java.awt.*;

public class KeyHandle implements MouseMotionListener, MouseListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        // Screen.mse = new Point(e.getX() + ((Frame.size.width - Screen.myWidth)/2), (e.getY()) + ((Frame.size.width - Screen.myWidth)/2));
        Screen.mse = new Point(e.getX() + ((Frame.size.width - Screen.myWidth)/2), (e.getY()) + ((Frame.size.height - Screen.myHeight)/2));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Screen.mse = new Point(e.getX() - ((Frame.size.width - Screen.myWidth)/2), (e.getY()) - ((Frame.size.height - Screen.myHeight)/2));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent m) {
        Screen.store.click(m.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
