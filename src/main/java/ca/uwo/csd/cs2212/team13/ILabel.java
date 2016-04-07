package ca.uwo.csd.cs2212.team13;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A JLabel that has an icon associated with it, used in Daily Dashboard
 */
public class ILabel extends JLabel{

	/**
	 * Creates an ILabel
	 */
	public ILabel() {
		super();
		this.setBounds(0, 0, 160, 144);
		this.setIcon(new ImageIcon("src/main/resources/Squares.png"));
	}
}
