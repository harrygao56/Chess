package chess;

import javax.swing.ImageIcon;

public class Pawn extends Piece{
	public Pawn(boolean white, ImageIcon icon)
	{
		super(white, icon);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "P";
		}
		else
		{
			return "p";
		}
	}
}