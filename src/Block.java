import java.awt.*;

public class Block extends Rectangle {
    public Rectangle towerSquare;
    public int towerSquareSize = 130;
    public int groundID;
    public int airID;
    public int shotMob = 0;
    public boolean shooting = false;

    public Block(int x, int y, int width, int height, int groundID, int airID){
        setBounds(x, y, width, height);
        towerSquare = new Rectangle(x -(towerSquareSize/2), y- (towerSquareSize/2), width+ (towerSquareSize), height+ towerSquareSize);
        this.groundID=groundID;
        this.airID=airID;
    }

    public void draw(Graphics g){
        g.drawImage(Screen.tileset_ground[groundID], x, y, width, height, null);

        if(airID != Value.airAir){
            g.drawImage(Screen.tileset_air[airID], x, y, width, height, null);
        }
    }

    public void physic(){

    }

    public void fight(Graphics g){
        if(Screen.isDebug){
            if(airID == Value.airTowerLaser){
                g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
            }
        }
    }
}
