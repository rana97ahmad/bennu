/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bennu;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class Lives {
        public int x;
    public int y;
    public String imagepath;

    public Lives(int x, int y, String imagepath) {
        this.x = x;
        this.y = y;
        this.imagepath = imagepath;
    }
  
    public void drawLives(Graphics g) {
        ImageIcon img = new ImageIcon(imagepath);
        g.drawImage(img.getImage(), x, y, null);
    } 
}
