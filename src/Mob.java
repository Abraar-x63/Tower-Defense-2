import java.awt.*;

public class Mob extends Rectangle {

    public int mobSize = 52;
    public int mobID = Value.mobAir;
    public boolean inGame = false;

    public Mob() {

    }

    public void spawnMob(int mobID) {
        for (int y = 0; y < Screen.room.block.length; y++) {
            if (Screen.room.block[y][0].groundID == Value.groundRoad) {
                setBounds(Screen.room.block[y][0].x, Screen.room.block[y][0].y, mobSize, mobSize);
            }
        }
        setBounds(10,10,100,100);
        this.mobID = mobID;
        inGame = true;
    }

    public void physic() {

    }

    public void draw(Graphics g) {
        g.drawImage(Screen.tileset_mob[mobID], x, y, width, height, null);
    }

}
