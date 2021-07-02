/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Luana Franciele
 */
public class MyScrollBar extends JScrollBar{
    
    JScrollBar me = this;

    public MyScrollBar(int orientation) {
        super(orientation);
        
        
        
        
        this.setUI(new BasicScrollBarUI(){
            
            private final Dimension d = new Dimension();            
            
            
            
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(new Color(0,134,195));
                g2.fillRoundRect(r.x,r.y + 15,r.width,r.height - 30,10,10);
                
                g2.dispose();
                
                
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(new Color(115,232,255));
                g2.fillRoundRect(r.x,r.y,r.width,r.height,10,10);
                
                g2.dispose();
            }

            @Override
            protected void setThumbBounds(int x, int y, int width, int height) {
                super.setThumbBounds(x, y, width, height); 
                me.repaint();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return new JButton() {
                @Override public Dimension getPreferredSize() {
                return d;
                    }
                };
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return new JButton() {
                @Override public Dimension getPreferredSize() {
                return d;
                    }
                };

            }     
        });
    }
    
    public Image createImage(Color color, Rectangle r){
        BufferedImage image = new BufferedImage(r.width, r.height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(color);
        
        g.fillRoundRect(r.x, r.y, r.width, r.height, 2, 2);
        g.dispose();
        return image;
    }
    
}
