import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;

public class Screen extends JPanel implements Runnable {

    public Thread thread = new Thread(this);
    
    public static Image[] tileset_ground = new Image[100];
    public static Image[] tileset_air = new Image[100];
    public static Boolean isFirst= true;
    public static int myWidth, myHeight;
    public static Room room;
    public static Save save;

    public Screen() {
        thread.start();
//        this.setBackground(Color.PINK);
    }

    public void define() {

        room = new Room();
        save = new Save();

        for (int i = 0; i < tileset_ground.length; i++) {
            tileset_ground[i] = new ImageIcon("res/tileset_ground.png").getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }

        for (int i = 0; i < tileset_air.length; i++) {
            tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
            tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }

        save.loadSave(new File("save/mission1.apff"));

    }
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        if (isFirst) {
            define();
            isFirst = false;
        }
        g2D.clearRect(0, 0, getWidth(), getHeight());

        room.draw(g2D);
    }

//    public static int fpsFrame = 0, fps = 1000000;
    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            if (!isFirst){
                myHeight = getHeight();
                myWidth = getWidth();
                room.physic();
            }

            repaint();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
