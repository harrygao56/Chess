package chess;

public class Pawn extends Piece{
	public Pawn(boolean white)
	{
		super(white);
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