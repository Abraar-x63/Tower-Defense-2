/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdtest;
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
    
    public static int myWidth, myHeight;
    
    public static boolean isFirst = true;
    
    public static Point mse = new Point(0, 0);
    
    public static Room room;
    
    public static Save save;
    
    public static Store store;
    
    public Screen(){
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
        
        g.clearRect(0, 0, getWidth(), getHeight());
        
        room.draw(g);//drawing the room
        store.draw(g); //drawing the store
    }
    
    public void run(){
        while(true){
            
            if(!isFirst){
                room.physic();
            }
            
            repaint();
            
            try{
                Thread.sleep(1);
            } catch(Exception e){}
        }
    }
}
