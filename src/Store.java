import java.awt.*;
/**
 *
 * @author hewhofades
 */
public class Store {
    public static int shopWidth = 8;
    public static int buttonSize = 52;
    public static int cellSpace = 2;
    public static int awayFromRoom = 15;

    public Rectangle[] button = new Rectangle[shopWidth];

    public Store(){
        define();
    }

    public void define(){
        for(int i=0; i<button.length; i++){
            button[i]=new Rectangle((Screen.myWidth/2) - ((shopWidth*(buttonSize+cellSpace))/2)+ ((buttonSize+cellSpace)*i) , (Screen.room.block[Screen.room.worldHeight-1][0].y)+Screen.room.blockSize+awayFromRoom, buttonSize, buttonSize);
        }
    }

    public void draw(Graphics g){
        for (Rectangle rectangle : button) {

            g.drawImage(Screen.tileset_res[0], rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);

            if (rectangle.contains(Screen.mse)) {
                g.setColor(new Color(255, 255, 255, 50));
                g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            }

        }
    }

}
