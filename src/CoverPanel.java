import javax.swing.*;
import java.awt.*;


public class CoverPanel extends JPanel {

    public static boolean startt = true;
    public static Image cvr;

    public CoverPanel(CoverScreen coverScreen) {

        cvr = new ImageIcon("res/cover.png").getImage();
        coverScreen.addMouseListener(new DefaultKeyHandle());
        coverScreen.addMouseMotionListener(new DefaultKeyHandle());

    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(cvr,3,4,this);
    }

    public void showCover(){
        while(startt){
            repaint();
        }

        CoverScreen.startGame();
    }
}
