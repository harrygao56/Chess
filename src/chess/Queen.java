package chess;

import javax.swing.ImageIcon;

public class Queen extends Piece{
	public Queen(boolean white, ImageIcon icon)
	{
		super(white, icon);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "Q";
		}
		else
		{
			return "q";
		}
	}
}