package chess;

import javax.swing.ImageIcon;

public class Rook extends Piece{
	public Rook(boolean white, ImageIcon icon)
	{
		super(white, icon);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "R";
		}
		else
		{
			return "r";
		}
	}
}