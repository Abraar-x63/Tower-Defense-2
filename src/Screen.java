import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
/**
 *
 * @author hewhofades
 */
public class Screen extends JPanel implements Runnable{
    public Thread thread= new Thread(this);

    public static Image[] tileset_ground = new Image[100];
    public static Image[] tileset_air = new Image[100];
    public static Image[] tileset_res = new Image[100];

    public static int myWidth, myHeight;

    public static boolean isFirst = true;

    public static Point mse = new Point(0, 0);

    public static Room room;

    public static Save save;

    public static Store store;

    public Screen(Frame frame){
        frame.addMouseListener(new KeyHandle());
        frame.addMouseMotionListener(new KeyHandle());

        thread.start();
    }

    public void define(){
        room = new Room();
        save = new Save();
        store = new Store();

        for(int i=0; i<tileset_ground.length; i++){
            tileset_ground[i] = new ImageIcon("res/tileset_ground.png").getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 27*i, 27, 27)));
        }

        for(int i=0; i<tileset_air.length; i++){
            tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
            tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 27*i, 27, 27)));
        }

        tileset_res[0] = new ImageIcon("res/cell.png").getImage();

        save.loadSave(new File("save/ulxava.txt"));
    }

    @Override
    public void paintComponent(Graphics g){

        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();
            define();

            isFirst=false;
        }

        g.setColor(new Color(50,50,50));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(0, 0, 0));
        g.drawLine(room.block[0][0].x-1, 0, room.block[0][0].x-1, room.block[room.worldHeight-1][0].y+room.blockSize+1);
        g.drawLine(room.block[0][room.worldWidth-1].x+room.blockSize, 0, room.block[0][room.worldWidth-1].x+room.blockSize, room.block[room.worldHeight-1][0].y+room.blockSize+1);
        g.drawLine(room.block[0][0].x+room.blockSize, room.block[room.worldHeight-1][0].y+room.blockSize, room.block[0][room.worldWidth-1].x+room.blockSize, room.block[room.worldHeight-1][0].y+room.blockSize);

        store.draw(g); //drawing the store
        room.draw(g);//drawing the room
    }

    public void run(){
        while(true){

            if(!isFirst){
                room.physic();
            }

            repaint();

            try{
                Thread.sleep(1);
            } catch(Exception ignored){}
        }
    }
}
