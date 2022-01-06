package chess;

import javax.swing.ImageIcon;

public class King extends Piece{
	public King(boolean white, ImageIcon icon)
	{
		super(white, icon);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "K";
		}
		else
		{
			return "k";
		}
	}
}