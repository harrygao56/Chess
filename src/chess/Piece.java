package chess;

import javax.swing.ImageIcon;

public abstract class Piece {
	private boolean alive;
	private boolean white;
	private ImageIcon icon;
	
	public Piece(boolean white, ImageIcon icon)
	{
		this.icon = icon;
		this.white = white;
		alive = true;
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
	
	public ImageIcon getIcon()
	{
		return icon;
	}
	
	//public abstract void moves();
	
	public abstract String toString();
}
