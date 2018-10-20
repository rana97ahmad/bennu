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
public class End {
      public int x;
    public int y;
    public String imagepath;

  
    public End(int xaxis, int yaxis, String imagepath) {
        this.x = xaxis;
        this.y = yaxis;
        this.imagepath = imagepath;
    }


    public void drawend(Graphics g){
      ImageIcon img = new ImageIcon(imagepath);
      g.drawImage(img.getImage(), x, y, null);
    }
}
