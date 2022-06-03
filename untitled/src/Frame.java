import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public static String title = "TD by The Sentinels";
    public static Dimension size = new Dimension(700,550);
    public Frame() {

        this.setTitle(title);
        this.setSize(size);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();

    }

    public void init() {

        this.setLayout(new GridLayout(1, 1, 0, 0));
        Screen screen = new Screen();
        add(screen);

        this.setVisible(true);
    }


}
