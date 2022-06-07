import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Screen extends JPanel implements Runnable{
    public Thread thread= new Thread(this);

    public static Image[] tileset_ground = new Image[100];
    public static Image[] tileset_air = new Image[100];
    public static Image[] tileset_res = new Image[100];
    public static Image[] tileset_mob = new Image[100];
    public static  Mob[] mobs = new Mob[100];

    public static int myWidth, myHeight;
    public static int coinage = 10, health = 100;
    public static boolean isFirst = true;
    public static Point mse = new Point(0, 0);
    public static Room room;
    public static Save save;
    public static Store store;


    public Screen(Frame frame) {

        frame.addMouseListener(new KeyHandle());
        frame.addMouseMotionListener(new KeyHandle());

        thread.start();
    }

    public void define() {

        room = new Room();
        save = new Save();
        store = new Store();

        for(int i=0; i<tileset_ground.length; i++) {
            tileset_ground[i] = new ImageIcon("res/tileset_ground.png").getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 27*i, 27, 27)));
        }

        for(int i=0; i<tileset_air.length; i++) {
            tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
            tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 27*i, 27, 27)));
        }

        tileset_res[0] = new ImageIcon("res/cell.png").getImage();
        tileset_res[1] = new ImageIcon("res/heart.png").getImage();
        tileset_res[2] = new ImageIcon("res/coin.png").getImage();
        tileset_mob[0] = new ImageIcon("res/mob.png").getImage();

        save.loadSave(new File("save/ulxava.txt"));

        for (int i = 0; i < mobs.length; i++) {
            mobs[i] = new Mob();
            mobs[i].spawnMob(i);
        }

    }

    @Override
    public void paintComponent(Graphics g){

        if(isFirst && health > 0) {
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




        room.draw(g);//drawing the room
        for (Mob mob : mobs) {
            if (mob.inGame) {
                mob.draw(g);
            }
        }
        store.draw(g); //drawing the store


        if (health < 1) {
            g.setColor(new Color(240,20, 20));
            g.fillRect(0,0, myWidth,myHeight);
            g.setColor(new Color(255,255, 255));
            g.setFont(new Font("Courier New", Font.BOLD, 14));
            g.drawString("GAME OVER!",10, 10);
        }

    }



    public int spawnTime = 2400, spawnFrame = 0;
    public void mobSpawner() {
        if (spawnFrame >= spawnTime) {
            for (Mob mob : mobs) {
                if (!mob.inGame) {
                    mob.spawnMob(0);
                    break;
                }
            }
            spawnFrame = 0;
        } else {
            spawnFrame += 1;
        }
    }


    public void run(){
        //noinspection InfiniteLoopStatement
        while(true){

            if(!isFirst){
                room.physic();
                mobSpawner();

                for (Mob mob : mobs) {
                    if (mob.inGame) {
                        mob.physic();
                    }
                }

            }

            repaint();

            try{
                Thread.sleep(1);
            } catch(Exception ignored){}
        }
    }
}
