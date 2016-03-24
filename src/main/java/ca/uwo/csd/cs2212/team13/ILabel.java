package ca.uwo.csd.cs2212.team13;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ILabel extends JLabel{
	
	public ILabel() {
		super();
		this.setBounds(0, 0, 160, 144);
		this.setIcon(new ImageIcon("src/main/resources/Squares.png"));
	}
}
