import javax.swing.*;
import java.awt.*;

public class CoverScreen extends JFrame {

    public static String title = "TD by The Sentinels";
    public static Dimension size = new Dimension(725, 550);

    public CoverScreen(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    public void init(){
        setLayout(new GridLayout(1,1,0,0));

        CoverPanel coverPanel = new CoverPanel(this);
        add(coverPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        CoverScreen coverScreen = new CoverScreen();
        CoverPanel cp = new CoverPanel(coverScreen);
        cp.showCover();
    }

    public static void startGame() {
        new Frame();
    }
}
