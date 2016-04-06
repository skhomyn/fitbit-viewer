package ca.uwo.csd.cs2212.team13;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class to display the background panel of the app
 * @author Robin
 *
 */
public class BackgroundPanel extends JPanel implements Serializable{

	private Image background;

	/**
	 * constructor
	 */
	public BackgroundPanel()
	{
	    try {
			background = ImageIO.read(new File("src/main/resources/Squares.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            
	}

	/**
	 * get the backround of the preferred dimensions
	 * @return backround
     */
	@Override
	public Dimension getPreferredSize() {
	    return background == null ? new Dimension(0, 0) : new Dimension(background.getWidth(this), background.getHeight(this));            
	}

	/**
	 * paints the componenet
	 * @param g
     */
	@Override
	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);

	    if (background != null) {                
	        Insets insets = getInsets();

	        int width = getWidth() - 1 - (insets.left + insets.right);
	        int height = getHeight() - 1 - (insets.top + insets.bottom);

	        int x = (width - background.getWidth(this)) / 2;
	        int y = (height - background.getHeight(this)) / 2;

	        g.drawImage(background, x, y, this);                
	    }

	}
	

}
