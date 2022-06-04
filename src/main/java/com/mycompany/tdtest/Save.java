/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tdtest;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hewhofades
 */
public class Save {
    public void loadSave(File loadPath){
        try {
            Scanner loadScanner = new Scanner(loadPath);
            
            while(loadScanner.hasNext()){
                for(int y=0; y<Screen.room.block.length; y++){
                   for(int x=0; x<Screen.room.block[0].length; x++){
                       Screen.room.block[y][x].groundID= loadScanner.nextInt();
                   } 
                }
                
                for(int y=0; y<Screen.room.block.length; y++){
                   for(int x=0; x<Screen.room.block[0].length; x++){
                       Screen.room.block[y][x].airID= loadScanner.nextInt();
                   } 
                }
            }
            
            loadScanner.close();
        } catch (Exception e) {}
    }
}
