package chess;

import javax.swing.ImageIcon;

public class Knight extends Piece{
	public Knight(boolean white, ImageIcon icon)
	{
		super(white, icon);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "N";
		}
		else
		{
			return "n";
		}
	}
}