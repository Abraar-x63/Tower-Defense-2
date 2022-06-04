/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdtest;

import java.awt.*;

/**
 *
 * @author hewhofades
 */
public class Room {
    
    public int worldWidth = 12;
    public int worldHeight= 8;
    public int blockSize=54;
    
    public Block[][] block;
    
    public Room(){
       define();
    }
    
    public void define(){
        block = new Block[worldHeight][worldWidth];
        
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block[0].length; x++){
                block[y][x]=new Block(((x)*blockSize), y*blockSize, blockSize, blockSize, Value.groundGrass, Value.airAir);
            }
        }
    }
    
    public void physic(){
        
    }
    
    public void draw(Graphics g){
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block[0].length; x++){
                block[y][x].draw(g);
            }
        }
    }
}
