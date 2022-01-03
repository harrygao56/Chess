package chess;

public class Rook extends Piece{
	public Rook(boolean white)
	{
		super(white);
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