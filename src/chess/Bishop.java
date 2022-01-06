package chess;

import javax.swing.ImageIcon;

public class Bishop extends Piece{
	public Bishop(boolean white, ImageIcon icon)
	{
		super(white, icon);
	}
	
	public String toString()
	{
		if(super.isWhite())
		{
			return "B";
		}
		else
		{
			return "b";
		}
	}
}