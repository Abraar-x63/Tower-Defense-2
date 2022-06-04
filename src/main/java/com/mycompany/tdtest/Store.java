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
public class Store {
    public static int shopWidth = 0;
    public static int buttonSize = 32;
    
    public Rectangle[] button = new Rectangle[shopWidth];
    
    public Store(){
        define();
    }
    
    public void define(){
        for(int i=0; i<button.length; i++){
            button[i]=new Rectangle((Screen.myWidth/2) - ((shopWidth*buttonSize)/2)+ (buttonSize*i) , 10, buttonSize, buttonSize);
        }
    }
    
    public void draw(Graphics g){
        for(int i=0; i<button.length; i++){
            g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
        }
    }
    
}
