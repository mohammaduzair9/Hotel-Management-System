/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.awt.AlphaComposite;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


/*

This Class is used for tranparenting the background Frame

*/

class ContentPane extends JPanel {

    public ContentPane() {
        setOpaque(false);
    }
    
     @Override
    protected void paintComponent(Graphics g) {

        // Allow super to paint
        super.paintComponent(g);

        // Apply our own painting effect
        Graphics2D g2d = (Graphics2D) g.create();
        // 50% transparent Alpha
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        g2d.setColor(getBackground());
        g2d.fill(getBounds());

        g2d.dispose();

    }
}