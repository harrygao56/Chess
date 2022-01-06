package chess;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Piece extends JLabel {
	private boolean alive;
	private boolean white;
	
	public Piece(boolean white, ImageIcon icon)
	{
		this.white = white;
		alive = true;
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); 
		icon = new ImageIcon(newimg);
		setIcon(icon);
	}
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public boolean isWhite()
	{
		return white;
	}
	
	public void die()
	{
		alive = false;
	}
	
	//public abstract void moves();
	
	public abstract String toString();
}
