import java.awt.*;

public class Store {
    public static int shopWidth = 8;
    public static int buttonSize = 52;
    public static int cellSpace = 2;
    public static int awayFromRoom = 15;
    public static int iconSize = 20;
    public static int iconSpace = 6;
    public static int iconTextY = 15;

    public Rectangle[] button = new Rectangle[shopWidth];
    public Rectangle buttonHealth;
    public Rectangle buttonCoins;


    public Store(){
        define();
    }

    public void define(){
        for(int i = 0; i < button.length; i++){
            button[i]=new Rectangle((Screen.myWidth/2) - ((shopWidth*(buttonSize+cellSpace))/2)+ ((buttonSize+cellSpace)*i) , (Screen.room.block[Screen.room.worldHeight-1][0].y)+Screen.room.blockSize+awayFromRoom, buttonSize, buttonSize);
        }
        buttonHealth = new Rectangle( Screen.room.block[0][0].x - 1, button[0].y, iconSize, iconSize);
        buttonCoins = new Rectangle(Screen.room.block[0][0].x - 1, button[0].y + button[0].height- iconSize , iconSize, iconSize);
    }

    public void draw(Graphics g){
        for (Rectangle rectangle : button) {

            g.drawImage(Screen.tileset_res[0], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);

            if (rectangle.contains(Screen.mse)) {
                g.setColor(new Color(255, 255, 255, 50));
                g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            }
        }

        g.drawImage(Screen.tileset_res[1], buttonHealth.x, buttonHealth.y, buttonHealth.width, buttonHealth.height, null);
        g.drawImage(Screen.tileset_res[2], buttonCoins.x, buttonCoins.y, buttonCoins.width, buttonCoins.height,null);
        g.setFont(new Font("Courier New",Font.BOLD, 14));
        g.setColor(new Color(255, 255, 255));
        g.drawString("" + Screen.health, buttonHealth.x + buttonHealth.width + iconSpace , buttonHealth.y + iconTextY);
        g.drawString("" + Screen.coinage, buttonCoins.x + buttonCoins.width + iconSpace , buttonCoins.y + iconTextY);
    }

}
