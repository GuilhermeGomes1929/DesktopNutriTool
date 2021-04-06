/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Luana Franciele
 */
public class MyScrollBar extends JScrollBar{

    public MyScrollBar(int orientation) {
        super(orientation);
        
        
        
        this.setUI(new BasicScrollBarUI(){
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
               g.drawImage(createImage(Color.BLUE), 
                       thumbBounds.x, thumbBounds.y, 
                       thumbBounds.width, thumbBounds.height, null); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                g.drawImage(createImage(Color.RED), 
                       trackBounds.x, trackBounds.y, 
                       trackBounds.width, trackBounds.height, null); //To change body of generated methods, choose Tools | Templates.
            }
        
        });
    }
    
    public Image createImage(Color color){
        BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, 20, 16);
        g.dispose();
        return image;
    }
    
}
